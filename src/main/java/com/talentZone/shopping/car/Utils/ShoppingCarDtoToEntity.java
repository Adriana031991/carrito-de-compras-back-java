package com.talentZone.shopping.car.Utils;

import com.talentZone.shopping.car.dto.ShoppingCarDto;
import com.talentZone.shopping.car.entity.ShoppingCar;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ShoppingCarDtoToEntity implements Converter<ShoppingCarDto, ShoppingCar> {

    @Override
    public ShoppingCar convert(ShoppingCarDto dto) {
        ShoppingCar cart = new ShoppingCar();
        if (!StringUtils.isEmpty(dto.getId())) {
            cart.setId(dto.getId());
        }
        cart.setItemsCar(dto.getItemsCar());
        return cart;
    }
}
