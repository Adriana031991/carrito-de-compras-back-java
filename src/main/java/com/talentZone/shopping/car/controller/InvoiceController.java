package com.talentZone.shopping.car.controller;

import com.talentZone.shopping.car.dto.InvoiceDto;
import com.talentZone.shopping.car.entity.Invoice;
import com.talentZone.shopping.car.entity.ShoppingCar;
import com.talentZone.shopping.car.service.InvoiceService;
import com.talentZone.shopping.car.service.ShoppingCarService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/invoice")
public class InvoiceController {
    private InvoiceService invoiceService;

    @PostMapping("/car/{id}")
    public ResponseEntity createInvoiceShoppingCar(@PathVariable(value = "id") String carId) {
        try {
            InvoiceDto invoice = invoiceService.invoiceShoppingCar(carId);
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } catch (Exception e) {
            log.error("create invoice method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity getInvoices() {
        try {
            List<Invoice> invoice = invoiceService.findAllInvoices();
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Find invoices method error {}", e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create-invoice")
    public ResponseEntity<Map<String,String>> createIdInvoiceShoppingCar(){
        try {
            Map<String,String> idInvoice = invoiceService.createIdInvoice();
            return ResponseEntity.ok(idInvoice);
        } catch (Exception e) {
            log.error("Could'n create id invoice", e.getMessage(), e);
            return (ResponseEntity<Map<String, String>>) ResponseEntity.internalServerError();

        }

    }

}
