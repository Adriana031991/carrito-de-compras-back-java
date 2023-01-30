package com.talentZone.shopping.car.service;

import com.talentZone.shopping.car.dto.ProductDto;
import com.talentZone.shopping.car.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> findAllProducts();

    Page<Product> findAllPageable(Pageable pageable);

    Product findByName(String name);

    Product findItemById(String id);

    Product save(ProductDto productDto);

    Product update(ProductDto itemRequestDto, String id);

    Map<String,String> delete(String id);

    List<Product> saveAll(List<Product> products);

}
