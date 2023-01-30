package com.talentZone.shopping.car.Utils;

import com.talentZone.shopping.car.dto.ProductDto;
import com.talentZone.shopping.car.entity.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ProductDtoToEntity implements Converter<ProductDto, Product> {

    @Override
    public Product convert(ProductDto dto) {
        Product item = new Product();
        if (!StringUtils.isEmpty(dto.getId())) {
            item.setId(dto.getId());
        }
        item.setName(dto.getName());
        item.setValue(dto.getValue());
        item.setQuantity(dto.getQuantity());
        item.setImage(dto.getImage());
        return item;
    }
}
