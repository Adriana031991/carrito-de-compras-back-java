package com.talentZone.shopping.cart.service;

import com.talentZone.shopping.cart.dto.ItemRequestDto;
import com.talentZone.shopping.cart.entity.Item;

import java.awt.print.Pageable;
import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item findByName(String name);

    Item findItemById(String id);

    Item saveOrUpdate(ItemRequestDto itemRequestDto);

    void delete(String id);
}
