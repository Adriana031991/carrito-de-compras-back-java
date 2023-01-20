package com.talentZone.shopping.car.service;

import com.talentZone.shopping.car.Utils.ProductDtoToEntity;
import com.talentZone.shopping.car.dto.ProductDto;
import com.talentZone.shopping.car.entity.Product;
import com.talentZone.shopping.car.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServicesImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductDtoToEntity dtoToEntity;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Product findItemById(String id) {
        return repository.findItemById(id);
    }

    @Override
    public Product save(ProductDto productDto) {
        return repository.insert(dtoToEntity.convert(productDto));
    }

    @Override
    public Product update(ProductDto itemRequestDto, String id) {
        Product productToUpdate =  repository.findById(id).get();

        productToUpdate.setName(itemRequestDto.getName());
        productToUpdate.setValue(itemRequestDto.getValue());
        productToUpdate.setQuantity(itemRequestDto.getQuantity());

        return repository.save(productToUpdate);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
