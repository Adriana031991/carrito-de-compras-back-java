package com.talentZone.shopping.cart.service;

import com.talentZone.shopping.cart.dto.CartRequestDto;
import com.talentZone.shopping.cart.entity.Cart;
import com.talentZone.shopping.cart.repository.CartRepository;
import com.talentZone.shopping.cart.utils.CartRequestDtoToCart;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CartServiceImpl implements CartService {


    private CartRepository cartRepository;

    private CartRequestDtoToCart cartRequestDtoToCart;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, CartRequestDtoToCart cartRequestDtoToCart) {
        this.cartRepository = cartRepository;
        this.cartRequestDtoToCart = cartRequestDtoToCart;
    }


    @Override
    public Cart saveOrUpdate(CartRequestDto cartRequestDto) {
        return cartRepository.save(cartRequestDtoToCart.convert(cartRequestDto));
    }

    @Override
    public Cart findCartByCustomerId(CartRequestDto cartRequestDto) {
        return cartRepository.findCartByCustomerId(cartRequestDto.getCustomerId());
    }

    @Override
    public List<Cart> findAllCarts() {
        return cartRepository.findAll();
    }
}
