package com.talentZone.shopping.cart.utils;

import com.talentZone.shopping.cart.dto.ItemRequestDto;
import com.talentZone.shopping.cart.entity.Item;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ItemRequestDtoToItem implements Converter<ItemRequestDto, Item> {

    @Override
    public Item convert(ItemRequestDto itemRequest) {
        Item item = new Item();
        if (!StringUtils.isEmpty(itemRequest.getId())) {
            item.setId(itemRequest.getId());
        }
        item.setName(itemRequest.getName());
        item.setValue(itemRequest.getValue());
        item.setQuantity(itemRequest.getQuantity());
        return item;
    }
}
