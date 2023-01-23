package com.talentZone.shopping.car.Utils;

import com.talentZone.shopping.car.dto.InvoiceDto;
import com.talentZone.shopping.car.entity.Invoice;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceEntityToDto implements Converter<Invoice, InvoiceDto> {


    @Override
    public InvoiceDto convert(Invoice invoice) {
        InvoiceDto invoiceDto = new InvoiceDto();
        if (!StringUtils.isEmpty(invoice.getId())) {
            invoice.setId(invoice.getId());
        }
        invoiceDto.setDate(invoice.getDate());
        invoiceDto.setProducts(invoice.getProducts());
        invoiceDto.setTotal(invoice.getTotal());
        return invoiceDto;
    }



}