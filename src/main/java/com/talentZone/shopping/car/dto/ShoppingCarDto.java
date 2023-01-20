package com.talentZone.shopping.car.dto;

import com.talentZone.shopping.car.entity.ItemCar;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@NoArgsConstructor
@Getter
@Setter
public class ShoppingCarDto extends BaseRequestDto{
    private List<ItemCar> itemCars;


}
