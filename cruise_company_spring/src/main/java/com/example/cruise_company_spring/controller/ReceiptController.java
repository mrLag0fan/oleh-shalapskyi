package com.example.cruise_company_spring.controller;

import com.example.cruise_company_spring.controller.dto.ReceiptDto;
import com.example.cruise_company_spring.service.ReceiptService;
import com.example.cruise_company_spring.service.model.Receipt;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReceiptController {

    private final ReceiptService receiptService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/receipt")
    public List<ReceiptDto> getAllReceipts() {
        log.info(this.getClass().getSimpleName() + " getting all receipts....");
        return receiptService.getAllReceipts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/receipt/{id}")
    public ReceiptDto getReceipt(@PathVariable Integer id) {
        log.info(this.getClass().getSimpleName()
            + " getting receipt by id....");
        return receiptService.getReceipt(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/receipt")
    public ReceiptDto createReceipt(@RequestBody Receipt receipt) {
        log.info(this.getClass().getSimpleName() + " creating receipt....");
        return receiptService.createReceipt(receipt);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/receipt/{id}")
    public ReceiptDto updateReceipt(
        @PathVariable Integer id, @RequestBody ReceiptDto receiptDto) {
        log.info(this.getClass().getSimpleName() + " updating receipt....");
        return receiptService.updateReceipt(id, receiptDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/receipt/{id}")
    public ResponseEntity<Void> deleteReceipt(@PathVariable Integer id) {
        log.info(this.getClass().getSimpleName() + " deleting receipt....");
        receiptService.deleteReceipt(id);
        return ResponseEntity.noContent().build();
    }
}
