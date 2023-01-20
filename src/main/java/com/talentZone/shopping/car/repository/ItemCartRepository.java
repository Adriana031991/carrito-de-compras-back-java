package com.talentZone.shopping.car.repository;

import com.talentZone.shopping.car.entity.ItemCar;
import com.talentZone.shopping.car.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCartRepository extends MongoRepository<ItemCar, String> {
    ItemCar findByProduct(Product product);


}
