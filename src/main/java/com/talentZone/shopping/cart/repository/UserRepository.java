package com.talentZone.shopping.cart.repository;

import com.talentZone.shopping.cart.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findUserByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);
}