package com.example.cruise_company_spring.controller;

import com.example.cruise_company_spring.controller.dto.ReceiptStatusDto;
import com.example.cruise_company_spring.service.ReceiptStatusService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReceiptStatusController {

    private final ReceiptStatusService receiptStatusService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/receiptStatus")
    public List<ReceiptStatusDto> getAllReceiptStatuss(){
        log.info(this.getClass().getSimpleName() +" getting all receipt statuses....");
        return receiptStatusService.getAllReceiptStatuses();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/receiptStatus/{id}")
    public ReceiptStatusDto getReceiptStatus(@PathVariable Integer id){
        log.info(this.getClass().getSimpleName() +" getting receipt status by id....");
        return receiptStatusService.getReceiptStatus(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/receiptStatus")
    public ReceiptStatusDto createReceiptStatus(@RequestBody ReceiptStatusDto receiptStatusDto){
        log.info(this.getClass().getSimpleName() +" creating receipt status....");
        return receiptStatusService.createReceiptStatus(receiptStatusDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/receiptStatus/{id}")
    public ReceiptStatusDto updateReceiptStatus(@PathVariable Integer id, @RequestBody ReceiptStatusDto receiptStatusDto){
        log.info(this.getClass().getSimpleName() +" updating receipt status....");
        return receiptStatusService.updateReceiptStatus(id, receiptStatusDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/receiptStatus/{id}")
    public ResponseEntity<Void> deleteReceiptStatus(@PathVariable Integer id){
        log.info(this.getClass().getSimpleName() +" deleting receipt status....");
        receiptStatusService.deleteReceiptStatus(id);
        return ResponseEntity.noContent().build();
    }


}
