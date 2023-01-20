package com.talentZone.shopping.car.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "items")
public class Product {

    @Id
    private String id;
    private @NonNull String name;
    private @NonNull Integer value;
    private @NonNull Integer quantity;

}
