package com.talentZone.shopping.car.service;

import com.talentZone.shopping.car.Utils.InvoiceEntityToDto;
import com.talentZone.shopping.car.dto.InvoiceDto;
import com.talentZone.shopping.car.entity.Invoice;
import com.talentZone.shopping.car.entity.ItemCar;
import com.talentZone.shopping.car.entity.Product;
import com.talentZone.shopping.car.entity.ShoppingCar;
import com.talentZone.shopping.car.enums.StatusShoppingCar;
import com.talentZone.shopping.car.exception.ValidationException;
import com.talentZone.shopping.car.repository.InvoiceRepository;
import com.talentZone.shopping.car.repository.ProductRepository;
import com.talentZone.shopping.car.repository.ShoppingCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ShoppingCarRepository shoppingCarRepository;

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private ProductService productService;


    @Autowired
    private InvoiceEntityToDto invoiceEntityToDto;

    @Override
    public String createIdInvoice() {
        Invoice invoice = new Invoice();
        invoice = invoiceRepository.save(invoice);
        return invoice.getId();
    }

    @Override
    public List<InvoiceDto> findAllInvoices() {

        List<Invoice> invoices = invoiceRepository.findAll();
        return (List<InvoiceDto>) invoiceEntityToDto.convert((Invoice) invoices);
    }


    @Transactional
    @Override
    public InvoiceDto invoiceShoppingCar(String id) {
        Optional<ShoppingCar> shoppingCar = shoppingCarRepository.findById(id);

        if (shoppingCar.isEmpty()) {
            throw new ValidationException("Not found shopping cart");
        }

        Collection<String> idProducts = shoppingCar.get().getItemsCar().stream().map(i -> i.getProduct().getId()).collect(Collectors.toList());
        List<Product> products = (List<Product>) this.productRepository.findAllById(idProducts);

        List<Product> productsToUpdate = new ArrayList<>();

        Invoice invoice = new Invoice();
        invoice.setDate(LocalDate.now());
        invoice.setProducts(shoppingCar.get().getItemsCar().stream().map(i -> i.getProduct()).collect(Collectors.toList()));
        invoice.setTotal(shoppingCar.get().totalInvoice());

        for (ItemCar itemCar : shoppingCar.get().getItemsCar()) {
            Optional<Product> product = products.stream().filter(pr -> pr.getId().equals(itemCar.getProduct().getId())).findAny();
            if (product.isEmpty()) {
                throw new ValidationException("Not found product");
            }

            if (product.get().getQuantity() < itemCar.getQuantity())
                throw new ValidationException("There are not enough stocks for the product: " + product.get().getName());

            product.get().setQuantity(product.get().getQuantity() - itemCar.getQuantity());
            productsToUpdate.add(product.get());
        }

        shoppingCar.get().setStatus(StatusShoppingCar.CLOSED);
        shoppingCar.get().setInvoice(invoice);
        this.shoppingCarRepository.save(shoppingCar.get());
        this.productService.saveAll(productsToUpdate);
        this.invoiceRepository.save(invoice);

        return invoiceEntityToDto.convert(invoice);
    }
}
