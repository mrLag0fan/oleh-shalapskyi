package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.ReceiptStatusDto;
import java.util.List;

public interface ReceiptStatusService {

  ReceiptStatusDto getReceiptStatusById(Integer id);

  List<ReceiptStatusDto> getAllReceiptStatuses();

  boolean deleteReceiptStatus(Integer id);

  ReceiptStatusDto createReceiptStatus(ReceiptStatusDto receiptStatusDto);

  ReceiptStatusDto updateReceiptStatus(Integer id, ReceiptStatusDto receiptStatusDto);
}
