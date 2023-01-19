package com.talentZone.shopping.cart.service;

import com.talentZone.shopping.cart.dto.CustomerRequestDto;
import com.talentZone.shopping.cart.entity.Customer;

import java.awt.print.Pageable;
import java.util.List;

public interface CustomerService {

    List<Customer> findAll();
    Customer saveOrUpdate(CustomerRequestDto customerRequestDto);

    Customer findCustomerByName(String name);

    Customer findCustomerByEmail(String email);

    void delete(String id);

}
