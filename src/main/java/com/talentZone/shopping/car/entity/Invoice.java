package com.talentZone.shopping.car.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "invoice")
public class Invoice {

    @Id
    private String id;
    private Integer total;
    private LocalDate date;
    private List<Product> products;
}
