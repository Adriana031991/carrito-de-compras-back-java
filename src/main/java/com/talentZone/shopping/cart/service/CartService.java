package com.talentZone.shopping.cart.service;

import com.talentZone.shopping.cart.dto.CartRequestDto;
import com.talentZone.shopping.cart.entity.Cart;

import java.util.List;

public interface CartService {
    Cart saveOrUpdate(CartRequestDto cartRequestDto);

    Cart findCartByCustomerId(CartRequestDto cartRequestDto);

    List<Cart> findAllCarts();
}
