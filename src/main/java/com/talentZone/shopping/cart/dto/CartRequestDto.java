package com.talentZone.shopping.cart.dto;

import com.talentZone.shopping.cart.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequestDto extends BaseRequestDto {

    private String customerId;
    private List<Item> items;
}
