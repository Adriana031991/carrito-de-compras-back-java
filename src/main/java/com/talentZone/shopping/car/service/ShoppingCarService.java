package com.talentZone.shopping.car.service;

import com.talentZone.shopping.car.dto.ShoppingCarDto;
import com.talentZone.shopping.car.entity.ShoppingCar;

import java.util.List;
import java.util.Map;

public interface ShoppingCarService {

    List<ShoppingCar> findAllCarts();

    Integer addProduct(String carId, String productId, Integer quantity);

    Integer updateQuantity(String carId, String productId, Integer quantity);

    Map<String,String> createShoppingCar();




}
