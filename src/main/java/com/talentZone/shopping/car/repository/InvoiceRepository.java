package com.talentZone.shopping.car.repository;

import com.talentZone.shopping.car.entity.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceRepository extends MongoRepository<Invoice, String> {
}
