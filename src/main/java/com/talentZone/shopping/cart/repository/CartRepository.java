package com.talentZone.shopping.cart.repository;

import com.talentZone.shopping.cart.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Cart findCartByCustomerId(String customerId);
}
