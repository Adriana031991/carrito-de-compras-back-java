package com.talentZone.shopping.cart.utils;

import com.talentZone.shopping.cart.dto.CartRequestDto;
import com.talentZone.shopping.cart.entity.Cart;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CartRequestDtoToCart implements Converter<CartRequestDto, Cart> {

    @Override
    public Cart convert(CartRequestDto cartRequest) {
        Cart cart = new Cart();
        if (!StringUtils.isEmpty(cartRequest.getId())) {
            cart.setId(cartRequest.getId());
        }
        cart.setCustomerId(cartRequest.getCustomerId());
        cart.setItems(cartRequest.getItems());
        return cart;
    }
}
