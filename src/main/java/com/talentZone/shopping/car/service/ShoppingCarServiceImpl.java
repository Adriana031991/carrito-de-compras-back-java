package com.talentZone.shopping.car.service;

import com.talentZone.shopping.car.entity.ItemCar;
import com.talentZone.shopping.car.entity.Product;
import com.talentZone.shopping.car.entity.ShoppingCar;
import com.talentZone.shopping.car.enums.StatusShoppingCar;
import com.talentZone.shopping.car.exception.ValidationException;
import com.talentZone.shopping.car.repository.ItemCartRepository;
import com.talentZone.shopping.car.repository.ProductRepository;
import com.talentZone.shopping.car.repository.ShoppingCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public Optional<ShoppingCar> findCart(String carId) {
        return shoppingCarRepository.findById(carId);
    }


    @Override
    public Integer addProduct(String carId, String productId, Integer quantity) {
        Integer addedQuantity = quantity;
        ItemCar itemCar;
        Optional<ShoppingCar> shoppingCar = shoppingCarRepository.findById(carId);

        try {
            if (shoppingCar.isPresent()) {
                itemCar = addProductToCar(productId, quantity);
                shoppingCar.get().addItemCar(itemCar);
                shoppingCar.get().setStatus(StatusShoppingCar.PENDING);
                shoppingCarRepository.save(shoppingCar.get());
            System.out.println("q"+shoppingCar.get() );
            } else {
                shoppingCar = Optional.of(new ShoppingCar());
                itemCar = addProductToCar(productId, quantity);
                shoppingCar.get().addItemCar(itemCar);
                shoppingCar.get().setStatus(StatusShoppingCar.ACTIVE);
                shoppingCarRepository.save(shoppingCar.get());
            System.out.println("w"+shoppingCar.get() );
            }
            return addedQuantity;

        } catch (Exception e) {

        }

        return -1;
    }

    private ItemCar addProductToCar(String productId, Integer quantity) throws ValidationException {
        Integer addedQuantity = quantity;
        Optional<Product> product = productRepository.findById(productId);

        if (product.isEmpty()) {
            throw new ValidationException("The product not exist");
        }

        ItemCar itemCar = itemCartRepository.findByProduct(product.get());


        if (itemCar != null) {
            addedQuantity = itemCar.getQuantity() + quantity;
            itemCar.setQuantity(addedQuantity);
        System.out.println("e"+itemCar );

        } else {
            itemCar = new ItemCar();
            itemCar.setQuantity(quantity);
            itemCar.setProduct(product.get());
        System.out.println("f"+itemCar );
        }

        itemCartRepository.save(itemCar);

        return itemCar;
    }

    @Override
    public Integer updateQuantity(String carId, String productId, Integer quantity) {
        Optional<ShoppingCar> shoppingCar = shoppingCarRepository.findById(carId);
        if (shoppingCar.isEmpty()) {
            Optional<Product> product = productRepository.findById(productId);
            if (product.isEmpty()) {
                throw new ValidationException("Not found product");
            }
            int subtotal = product.get().getValue() * quantity;
            shoppingCar.get().totalInvoice();
            return subtotal;

        }
        return -1;
    }

    @Override
    public Map<String,String> createShoppingCar() {
        Map<String,String> response = new HashMap<>();

        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar = shoppingCarRepository.save(shoppingCar);
        response.put("idShoppingCart", shoppingCar.getId());
        return response;
    }


}
