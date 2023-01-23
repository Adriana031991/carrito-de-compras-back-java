package com.talentZone.shopping.car.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ProductDto extends BaseRequestDto {

    private String name;
    private Integer value;
    private Integer quantity;
    private String image;

    public ProductDto() {
        this.quantity = 1;
    }
}
