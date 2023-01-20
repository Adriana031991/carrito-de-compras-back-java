package com.talentZone.shopping.car.Utils;

import com.talentZone.shopping.car.dto.ItemCarDto;
import com.talentZone.shopping.car.entity.ItemCar;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class ItemCarDtoToEntity implements Converter<ItemCarDto, ItemCar> {

    @Override
    public ItemCar convert(ItemCarDto dto) {
        ItemCar item = new ItemCar();
        if (!StringUtils.isEmpty(dto.getId())) {
            item.setId(dto.getId());
        }
        item.setProduct(dto.getProduct());
        item.setQuantity(dto.getQuantity());

        return item;
    }
}
