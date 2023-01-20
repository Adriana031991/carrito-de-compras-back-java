package com.talentZone.shopping.car.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "itemCar")
public class ItemCar {

    @Id
    private String id;
    private int quantity;
    private Product product;

    public int getImport() {
        return quantity *product.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCar itemCar = (ItemCar) o;
        return Objects.equals(product.getId(), itemCar.product.getId())
                && Objects.equals(product.getName(), itemCar.product.getName());
    }


}
