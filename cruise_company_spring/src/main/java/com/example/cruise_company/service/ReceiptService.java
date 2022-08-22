package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.ReceiptDto;
import java.util.List;

public interface ReceiptService {

  ReceiptDto getReceipt(Integer id);

  List<ReceiptDto> getAllReceipts(Integer offset, Integer limit, String field, String sortType);

  void deleteReceipt(Integer id);

  ReceiptDto createReceipt(ReceiptDto receiptDto);

  ReceiptDto updateReceipt(Integer id, ReceiptDto receiptDto);
}
