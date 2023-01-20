package com.talentZone.shopping.car.controller;

import com.talentZone.shopping.car.dto.InvoiceShoppingCarDto;
import com.talentZone.shopping.car.entity.ShoppingCar;
import com.talentZone.shopping.car.service.ShoppingCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/shopping-car")
public class ShoppingCarController {
    private ShoppingCarService shoppingCarService;

    public ShoppingCarController(ShoppingCarService shoppingCarService) {
        this.shoppingCarService = shoppingCarService;
    }

    @PostMapping("/create-shopping-car")
    private ResponseEntity createShoppingCar(){
        try {
            String idShoppingCar = shoppingCarService.createShoppingCar();
            return new ResponseEntity<>(idShoppingCar, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Carts method error {}", e.getMessage(), e);
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
    @GetMapping("/invoice/{id}")
    private ResponseEntity getInvoiceShoppingCarById(@PathVariable(value = "id") String carId) {
        try {
            InvoiceShoppingCarDto invoice = shoppingCarService.invoiceShoppingCar(carId);
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Carts method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add-product-to-car/{cid}/{pid}/{qty}")
    private ResponseEntity addProductToCar(@PathVariable(value = "cid") String carId,
                                           @PathVariable(value = "pid") String productId,
                                           @PathVariable(value = "qty") Integer quantity){
        try {
            Integer addQuantity = shoppingCarService.addProduct(carId, productId, quantity);
            return new ResponseEntity<>(addQuantity, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Carts method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PostMapping("/update-quantity/{cid}/{pid}/{qty}")
    private ResponseEntity updateQuantity(@PathVariable(value = "cid") String carId,
                                          @PathVariable(value = "pid") String productId,
                                          @PathVariable(value = "qty") Integer quantity){
        try {
            Integer addQuantity = shoppingCarService.updateQuantity(carId, productId, quantity);
            return new ResponseEntity<>(addQuantity, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Carts method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
