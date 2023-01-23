package com.talentZone.shopping.car.service;

import com.talentZone.shopping.car.dto.InvoiceDto;
import com.talentZone.shopping.car.dto.ShoppingCarDto;
import com.talentZone.shopping.car.entity.Invoice;

import java.util.List;

public interface InvoiceService {
    String createIdInvoice();

    List<InvoiceDto> findAllInvoices();

    InvoiceDto invoiceShoppingCar(String id);
}
