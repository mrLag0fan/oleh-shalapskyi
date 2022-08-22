package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.ReceiptStatusDto;
import java.util.List;

public interface ReceiptStatusService {

  ReceiptStatusDto getReceiptStatus(Integer id);

  List<ReceiptStatusDto> getAllReceiptStatuses(
      Integer offset, Integer limit, String field, String sortType);

  void deleteReceiptStatus(Integer id);

  ReceiptStatusDto createReceiptStatus(ReceiptStatusDto receiptStatusDto);

  ReceiptStatusDto updateReceiptStatus(Integer id, ReceiptStatusDto receiptStatusDto);
}
