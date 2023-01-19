package com.talentZone.shopping.cart.controller;

import com.talentZone.shopping.cart.dto.CustomerRequestDto;
import com.talentZone.shopping.cart.entity.Customer;
import com.talentZone.shopping.cart.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/customers")
    private ResponseEntity customers() {
        try {
            List<Customer> customers = customerService.findAll();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find All Customers method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/customerbyname/{name}")
    private ResponseEntity getCustomerByName(@PathVariable(value = "name") String name) {
        try {
            Customer customer = customerService.findCustomerByName(name);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Customer by Name method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/customerbyemail/{email}")
    private ResponseEntity getCustomerByEmail(@PathVariable(value = "email") String email) {
        try {
            Customer customer = customerService.findCustomerByEmail(email);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Customer by Name method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/create")
    private ResponseEntity create(@RequestBody CustomerRequestDto customerRequestDto) {
        try {
            Customer customer = customerService.saveOrUpdate(customerRequestDto);
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Create Customer method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/update")
    private ResponseEntity update(@RequestBody CustomerRequestDto customerRequestDto) {
        try {
            Customer customer = customerService.saveOrUpdate(customerRequestDto);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Update Customer method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    private ResponseEntity delete(@PathVariable(value = "id") String id) {
        try {
            customerService.delete(id);
            return new ResponseEntity<>("Success to remove Customer!", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Delete Customer method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
