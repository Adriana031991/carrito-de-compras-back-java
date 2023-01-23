package com.talentZone.shopping.car.repository;

import com.talentZone.shopping.car.entity.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product findByName(String name);

    Product findItemById(String id);
}
