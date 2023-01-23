package com.talentZone.shopping.car.Utils;

import com.talentZone.shopping.car.dto.InvoiceDto;
import com.talentZone.shopping.car.entity.Invoice;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class InvoiceDtoToEntity implements Converter<InvoiceDto, Invoice>{


        @Override
        public Invoice convert(InvoiceDto dto){
                Invoice invoice=new Invoice();
                if(!StringUtils.isEmpty(dto.getId())){
                    invoice.setId(dto.getId());
                }
            invoice.setDate(dto.getDate());
            invoice.setProducts(dto.getProducts());
            invoice.setTotal(dto.getTotal());
                return invoice;
        }


}