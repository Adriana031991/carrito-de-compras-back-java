package com.talentZone.shopping.cart.utils;

import com.talentZone.shopping.cart.dto.CustomerRequestDto;
import com.talentZone.shopping.cart.entity.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class CustomerRequestDtoToCustomer implements Converter<CustomerRequestDto, Customer> {

    @Override
    public Customer convert(CustomerRequestDto customerRequest) {
        Customer customer = new Customer();
        if (!StringUtils.isEmpty(customerRequest.getId())) {
            customer.setId(customerRequest.getId());
        }
        customer.setEmail(customerRequest.getEmail());
        customer.setName(customerRequest.getName());
        return customer;
    }
}
