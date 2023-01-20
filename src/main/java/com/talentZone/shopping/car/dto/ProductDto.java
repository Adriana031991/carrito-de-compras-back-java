package com.talentZone.shopping.car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ProductDto extends BaseRequestDto {

    private String name;
    private Integer value;
    private Integer quantity;

    public ProductDto() {
        this.quantity = 1;
    }
}
