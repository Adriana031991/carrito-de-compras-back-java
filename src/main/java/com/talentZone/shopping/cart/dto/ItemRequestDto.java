package com.talentZone.shopping.cart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequestDto extends BaseRequestDto {

    private String name;
    private Double value;
    private Integer quantity;
}
