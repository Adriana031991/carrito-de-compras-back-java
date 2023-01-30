package com.talentZone.shopping.car.controller;

import com.talentZone.shopping.car.dto.ProductDto;
import com.talentZone.shopping.car.entity.Product;
import com.talentZone.shopping.car.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("products")
public class ProductController {
    private ProductService service;

    @Autowired
    public ProductController(ProductService productService) {
        this.service = productService;
    }

    @GetMapping
    public ResponseEntity products() {
        try {
            List<Product> products = service.findAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Items method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/paginated")
    public ResponseEntity productsPaginated(@RequestParam(defaultValue = "0") Integer page,
                                             @RequestParam(defaultValue = "10") Integer size) {
        try {
            Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
            Page<Product> products = service.findAllPageable(pageable);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Items paginated method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/product-by-name/{name}")
    public ResponseEntity getProductByName(@PathVariable(value = "name") String name) {
        try {
            Product product = service.findByName(name);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Item by Name method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/product-by-id/{id}")
    public ResponseEntity getProductById(@PathVariable(value = "id") String id) {
        try {
            Product product = service.findItemById(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find Item by Id method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ProductDto productDto) {
        try {
            Product product = service.save(productDto);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Create Item method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@RequestBody ProductDto productDto, @PathVariable(value = "id") String id) {
        try {
            Product product = service.update(productDto, id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Update Item method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Map<String,String>> delete(@PathVariable(value = "id") String id) {
        try {
            Map<String,String> response = service.delete(id);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error no delete {}", e.getMessage(), e);
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            return (ResponseEntity<Map<String, String>>) ResponseEntity.internalServerError();

        }
    }
}
