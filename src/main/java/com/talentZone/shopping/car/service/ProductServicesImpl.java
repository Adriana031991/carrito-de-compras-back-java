package com.talentZone.shopping.car.service;

import com.talentZone.shopping.car.Utils.ProductDtoToEntity;
import com.talentZone.shopping.car.dto.ProductDto;
import com.talentZone.shopping.car.entity.Product;
import com.talentZone.shopping.car.exception.ValidationException;
import com.talentZone.shopping.car.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServicesImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductDtoToEntity dtoToEntity;

    @Override
    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    @Override
    public Page<Product> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);

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
        Optional<Product> productToUpdate =  repository.findById(id);
        if (productToUpdate.isEmpty()) {
            throw new ValidationException("the product not exist");
        }

        productToUpdate.get().setName(itemRequestDto.getName());
        productToUpdate.get().setValue(itemRequestDto.getValue());
        productToUpdate.get().setQuantity(itemRequestDto.getQuantity());

        return repository.save(productToUpdate.get());
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return this.repository.saveAll(products);
    }
}
