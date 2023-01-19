package com.talentZone.shopping.cart.service;

import com.talentZone.shopping.cart.dto.ItemRequestDto;
import com.talentZone.shopping.cart.entity.Item;
import com.talentZone.shopping.cart.repository.ItemRepository;
import com.talentZone.shopping.cart.utils.ItemRequestDtoToItem;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemRequestDtoToItem itemRequestDtoToItem;

//    @Autowired
//    public ItemServiceImpl(ItemRepository itemRepository, ItemRequestDtoToItem itemRequestDtoToItem) {
//        this.itemRepository = itemRepository;
//        this.itemRequestDtoToItem = itemRequestDtoToItem;
//    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findByName(String name) {
        return itemRepository.findByName(name);
    }

    @Override
    public Item findItemById(String id) {
        return itemRepository.findItemById(id);
    }

    @Override
    public Item saveOrUpdate(ItemRequestDto itemRequestDto) {
        return itemRepository.save(itemRequestDtoToItem.convert(itemRequestDto));
    }

    @Override
    public void delete(String id) {
        itemRepository.deleteById(id);
    }
}
