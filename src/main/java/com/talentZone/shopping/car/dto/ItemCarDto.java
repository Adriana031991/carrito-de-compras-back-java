package com.talentZone.shopping.car.dto;

import com.talentZone.shopping.car.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ItemCarDto extends BaseRequestDto {

    private int quantity;
    private Product product;
}
