package com.talentZone.shopping.cart.repository;

import com.talentZone.shopping.cart.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findAll();

    Item findByName(String name);

    Item findItemById(String id);
}
