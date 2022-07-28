package com.example.cruise_company.controller;

import com.example.cruise_company.api.ReceiptStatusApi;
import com.example.cruise_company.controller.dto.ReceiptStatusDto;
import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.ReceiptStatusService;
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
public class ReceiptStatusController implements ReceiptStatusApi {

  private final ReceiptStatusService receiptStatusService;

  @Override
  public List<ReceiptStatusDto> getAllReceiptStatuses() {
    log.info(this.getClass().getSimpleName() + " getting all receipt statuses....");
    return receiptStatusService.getAllReceiptStatuses();
  }

  @Override
  public ReceiptStatusDto getReceiptStatus(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " getting receipt status by id....");
    return receiptStatusService.getReceiptStatus(id);
  }

  @Override
  public ReceiptStatusDto createReceiptStatus(
      @RequestBody @Validated(OnCreate.class) ReceiptStatusDto receiptStatusDto) {
    log.info(this.getClass().getSimpleName() + " creating receipt status....");
    return receiptStatusService.createReceiptStatus(receiptStatusDto);
  }

  @Override
  public ReceiptStatusDto updateReceiptStatus(
      @PathVariable Integer id,
      @RequestBody @Validated(OnUpdate.class) ReceiptStatusDto receiptStatusDto) {
    log.info(this.getClass().getSimpleName() + " updating receipt status....");
    return receiptStatusService.updateReceiptStatus(id, receiptStatusDto);
  }

  @Override
  public ResponseEntity<Void> deleteReceiptStatus(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting receipt status....");
    receiptStatusService.deleteReceiptStatus(id);
    return ResponseEntity.noContent().build();
  }
}
