package com.talentZone.shopping.car.dto;

import com.talentZone.shopping.car.entity.Product;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto extends BaseRequestDto {

    private Integer total;
    private LocalDate date;
    private List<Product> products;


}
