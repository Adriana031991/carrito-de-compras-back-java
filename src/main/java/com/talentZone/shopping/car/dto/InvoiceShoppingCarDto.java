package com.talentZone.shopping.car.dto;

import com.talentZone.shopping.car.entity.ItemCar;
import com.talentZone.shopping.car.entity.ShoppingCar;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceShoppingCarDto extends BaseRequestDto {

    private Integer total;
    private ShoppingCar shoppingCar;


}
