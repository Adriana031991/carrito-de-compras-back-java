package com.talentZone.shopping.cart.repository;

import com.talentZone.shopping.cart.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findAll();

    Customer findCustomerByName(String name);

    Customer findCustomerByEmail(String email);
}
