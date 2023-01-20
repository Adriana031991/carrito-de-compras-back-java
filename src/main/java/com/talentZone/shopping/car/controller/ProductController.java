package com.talentZone.shopping.car.controller;

import com.talentZone.shopping.car.dto.ProductDto;
import com.talentZone.shopping.car.entity.Product;
import com.talentZone.shopping.car.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("products")
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService productService) {
        this.service = productService;
    }

    @GetMapping
    private ResponseEntity products() {
        try {
            List<Product> products = service.findAll();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Items method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/product-by-name/{name}")
    private ResponseEntity getProductByName(@PathVariable(value = "name") String name) {
        try {
            Product product = service.findByName(name);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Item by Name method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/product-by-id/{id}")
    private ResponseEntity getProductById(@PathVariable(value = "id") String id) {
        try {
            Product product = service.findItemById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Item by Id method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    private ResponseEntity create(@RequestBody ProductDto productDto) {
        try {
            Product product = service.save(productDto);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Create Item method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/update/{id}")
    private ResponseEntity update(@RequestBody ProductDto productDto, @PathVariable(value = "id") String id) {
        try {
            Product product = service.update(productDto, id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Update Item method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    private ResponseEntity delete(@PathVariable(value = "id") String id) {
        try {
            service.delete(id);
            return new ResponseEntity<>("Success to remove Item!", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Erro no delete {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
