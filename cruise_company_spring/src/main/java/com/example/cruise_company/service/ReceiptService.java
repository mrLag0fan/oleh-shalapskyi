package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.ReceiptDto;
import java.util.List;

public interface ReceiptService {

  ReceiptDto getReceipt(Integer id);

  List<ReceiptDto> getAllReceipts();

  boolean deleteReceipt(Integer id);

  ReceiptDto createReceipt(ReceiptDto receiptDto);

  ReceiptDto updateReceipt(Integer id, ReceiptDto receiptDto);
}
