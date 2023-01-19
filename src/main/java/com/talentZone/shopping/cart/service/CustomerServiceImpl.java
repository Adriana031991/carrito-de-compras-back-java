package com.talentZone.shopping.cart.service;

import com.talentZone.shopping.cart.dto.CustomerRequestDto;
import com.talentZone.shopping.cart.entity.Customer;
import com.talentZone.shopping.cart.repository.CustomerRepository;
import com.talentZone.shopping.cart.utils.CustomerRequestDtoToCustomer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerRequestDtoToCustomer customerRequestDtoToCustomer;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveOrUpdate(CustomerRequestDto customerRequestDto) {
        return customerRepository.save(customerRequestDtoToCustomer.convert(customerRequestDto));
    }

    @Override
    public Customer findCustomerByName(String name) {
        return customerRepository.findCustomerByName(name);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
