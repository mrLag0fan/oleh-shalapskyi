package com.example.cruise_company.controller;

import com.example.cruise_company.controller.dto.ReceiptStatusDto;
import com.example.cruise_company.service.ReceiptStatusService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/receiptStatus")
public class ReceiptStatusController {

  private final ReceiptStatusService receiptStatusService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  public List<ReceiptStatusDto> getAllReceiptStatuss() {
    log.info(this.getClass().getSimpleName() + " getting all receipt statuses....");
    return receiptStatusService.getAllReceiptStatuses();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  public ReceiptStatusDto getReceiptStatus(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " getting receipt status by id....");
    return receiptStatusService.getReceiptStatusById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public ReceiptStatusDto createReceiptStatus(@RequestBody ReceiptStatusDto receiptStatusDto) {
    log.info(this.getClass().getSimpleName() + " creating receipt status....");
    return receiptStatusService.createReceiptStatus(receiptStatusDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  public ReceiptStatusDto updateReceiptStatus(
      @PathVariable Integer id, @RequestBody ReceiptStatusDto receiptStatusDto) {
    log.info(this.getClass().getSimpleName() + " updating receipt status....");
    return receiptStatusService.updateReceiptStatus(id, receiptStatusDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deleteReceiptStatus(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting receipt status....");
    receiptStatusService.deleteReceiptStatus(id);
    return ResponseEntity.noContent().build();
  }
}
