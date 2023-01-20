package com.talentZone.shopping.car.service;

import com.talentZone.shopping.car.dto.ProductDto;
import com.talentZone.shopping.car.entity.Product;

import java.util.List;

public interface ProductService {
        List<Product> findAll();

    Product findByName(String name);

    Product findItemById(String id);

    Product save(ProductDto itemRequestDto);

    Product update(ProductDto itemRequestDto, String id);

        void delete(String id);

}
