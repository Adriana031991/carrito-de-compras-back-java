package com.talentZone.shopping.car.service;

import com.talentZone.shopping.car.Utils.ShoppingCarDtoToEntity;
import com.talentZone.shopping.car.dto.ShoppingCarDto;
import com.talentZone.shopping.car.entity.Product;
import com.talentZone.shopping.car.entity.ShoppingCar;
import com.talentZone.shopping.car.repository.ShoppingCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ShoppingCarServiceImpl implements ShoppingCarService {

    private ShoppingCarRepository repository;

    private ShoppingCarDtoToEntity dtoToEntity;


    @Override
    public ShoppingCar addToCar(ShoppingCarDto shoppingCarDto) {


        return repository.insert(dtoToEntity.convert(shoppingCarDto));
    }

    @Override
    public List<ShoppingCar> findAllCarts() {


        return repository.findAll();
    }
}
