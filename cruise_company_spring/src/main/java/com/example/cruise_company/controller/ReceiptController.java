package com.example.cruise_company.controller;

import com.example.cruise_company.api.ReceiptApi;
import com.example.cruise_company.controller.dto.ReceiptDto;
import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.ReceiptService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReceiptController implements ReceiptApi {

  private final ReceiptService receiptService;

  @Override
  public List<ReceiptDto> getAllReceipts() {
    log.info(this.getClass().getSimpleName() + " getting all receipts....");
    return receiptService.getAllReceipts();
  }

  @Override
  public ReceiptDto getReceipt(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " getting receipt by id....");
    return receiptService.getReceipt(id);
  }

  @Override
  public ReceiptDto createReceipt(@RequestBody @Validated(OnCreate.class) ReceiptDto receiptDto) {
    log.info(this.getClass().getSimpleName() + " creating receipt....");
    return receiptService.createReceipt(receiptDto);
  }

  @Override
  public ReceiptDto updateReceipt(
      @PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) ReceiptDto receiptDto) {
    log.info(this.getClass().getSimpleName() + " updating receipt....");
    return receiptService.updateReceipt(id, receiptDto);
  }

  @Override
  public ResponseEntity<Void> deleteReceipt(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting receipt....");
    receiptService.deleteReceipt(id);
    return ResponseEntity.noContent().build();
  }
}
