package com.talentZone.shopping.car.service;

import com.talentZone.shopping.car.dto.ShoppingCarDto;
import com.talentZone.shopping.car.entity.ShoppingCar;

import java.util.List;

public interface ShoppingCarService {
    ShoppingCar addToCar(ShoppingCarDto shoppingCarDto);


    List<ShoppingCar> findAllCarts();

}
