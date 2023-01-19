package com.talentZone.shopping.cart.controller;

import com.talentZone.shopping.cart.dto.CartRequestDto;
import com.talentZone.shopping.cart.entity.Cart;
import com.talentZone.shopping.cart.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "/create")
    private ResponseEntity create(@RequestBody CartRequestDto cartRequestDto) {
        try {
            Cart cart = cartService.saveOrUpdate(cartRequestDto);
            return new ResponseEntity<>(cart, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Create Cart method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/cartbycustomerid")
    private ResponseEntity getCartByCustomerId(@RequestBody CartRequestDto cartRequestDto) {
        try {
            Cart cart = cartService.findCartByCustomerId(cartRequestDto);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Cart by Customer id method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/carts")
    private ResponseEntity getCarts() {
        try {
            List<Cart> carts = cartService.findAllCarts();
            return new ResponseEntity<>(carts, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Cart by Customer id method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
