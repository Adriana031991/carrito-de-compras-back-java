package com.talentZone.shopping.car.repository;

import com.talentZone.shopping.car.entity.ShoppingCar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCarRepository extends MongoRepository<ShoppingCar, String> {

}
