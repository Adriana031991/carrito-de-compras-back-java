package com.talentZone.shopping.car.service;

import com.talentZone.shopping.car.dto.InvoiceDto;
import com.talentZone.shopping.car.dto.ShoppingCarDto;
import com.talentZone.shopping.car.entity.Invoice;

import java.util.List;
import java.util.Map;

public interface InvoiceService {
    Map<String,String> createIdInvoice();

    List<Invoice> findAllInvoices();

    InvoiceDto invoiceShoppingCar(String id);
}
