package com.talentZone.shopping.car.service;

import com.talentZone.shopping.car.dto.InvoiceShoppingCarDto;
import com.talentZone.shopping.car.entity.ItemCar;
import com.talentZone.shopping.car.entity.Product;
import com.talentZone.shopping.car.entity.ShoppingCar;
import com.talentZone.shopping.car.repository.ItemCartRepository;
import com.talentZone.shopping.car.repository.ProductRepository;
import com.talentZone.shopping.car.repository.ShoppingCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Autowired
    private ShoppingCarRepository shoppingCarRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ItemCartRepository itemCartRepository;


    @Override
    public List<ShoppingCar> findAllCarts() {
        return shoppingCarRepository.findAll();
    }

    @Override
    public Integer addProduct(String carId, String productId, Integer quantity) {
        Integer addedQuantity = quantity;
        ItemCar itemCar;
        ShoppingCar shoppingCar = shoppingCarRepository.findById(carId).get();

        try {
            if (shoppingCar != null){
                itemCar = addProductToCar(productId, quantity);
                shoppingCar.addItemCar(itemCar);
            } else {
                shoppingCar = new ShoppingCar();
                itemCar = addProductToCar(productId, quantity);
                shoppingCar.addItemCar(itemCar);
            }
            shoppingCarRepository.save(shoppingCar);
            return addedQuantity;

        } catch (Exception e){

        }
        return -1;
    }

    private ItemCar addProductToCar(String productId, Integer quantity) throws RuntimeException {
        Integer addedQuantity = quantity;
        Product product = productRepository.findById(productId).get();
        ItemCar itemCar = itemCartRepository.findByProduct(product);
        System.out.println("itemcar: "+itemCar);

        if (product == null){
            throw new RuntimeException("The product not exist");
        }

        if (itemCar != null){
            addedQuantity = itemCar.getQuantity()+ quantity;
            itemCar.setQuantity(addedQuantity);;
        } else {
            itemCar = new ItemCar();
            itemCar.setQuantity(quantity);
            itemCar.setProduct(product);
        }

        itemCartRepository.save(itemCar);
        return itemCar;
    }

    @Override
    public Integer updateQuantity(String carId, String productId, Integer quantity) {
        ShoppingCar shoppingCar = shoppingCarRepository.findById(carId).get();
        if (shoppingCar != null) {
            Product product = productRepository.findById(productId).get();
            ItemCar itemCar = itemCartRepository.findByProduct(product);
            System.out.println("itemcar 2: "+itemCar);

            int subtotal = product.getValue() * quantity;
            shoppingCar.totalInvoice();
            System.out.println("subtotal: "+ subtotal + itemCar);
            return subtotal;

        }
        return -1;
    }

    @Override
    public String createShoppingCar(){
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar= shoppingCarRepository.save(shoppingCar);
        return shoppingCar.getId();
    }

    @Override
    public InvoiceShoppingCarDto invoiceShoppingCar(String id) {
        ShoppingCar shoppingCar = shoppingCarRepository.findById(id).get();
        InvoiceShoppingCarDto invoice = new InvoiceShoppingCarDto();
        invoice.setTotal(shoppingCar.totalInvoice());
        invoice.setShoppingCar(shoppingCar);
        invoice.setId("1");
        return invoice;
    }
}
