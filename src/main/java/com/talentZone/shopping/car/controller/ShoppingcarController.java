package com.talentZone.shopping.car.controller;

import com.talentZone.shopping.car.dto.ShoppingCarDto;
import com.talentZone.shopping.car.entity.ShoppingCar;
import com.talentZone.shopping.car.service.ShoppingCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/shopping-car")
public class ShoppingcarController {
    private ShoppingCarService shoppingCarService;

    @Autowired
    public ShoppingcarController(ShoppingCarService shoppingCarService) {
        this.shoppingCarService = shoppingCarService;
    }

    @PostMapping
    private ResponseEntity create(@RequestBody ShoppingCarDto shoppingCarDto ) {
        try {
            ShoppingCar cart = shoppingCarService.addToCar(shoppingCarDto);
            return new ResponseEntity<>(cart, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Create Cart method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    private ResponseEntity getCarts() {
        try {
            List<ShoppingCar> shoppingCar = shoppingCarService.findAllCarts();
            return new ResponseEntity<>(shoppingCar, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Carts method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
