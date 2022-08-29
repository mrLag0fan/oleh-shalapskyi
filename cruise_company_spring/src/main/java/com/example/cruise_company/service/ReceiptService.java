package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.ReceiptDto;
import com.example.cruise_company.service.model.Receipt;
import java.util.List;

public interface ReceiptService {

  ReceiptDto getReceiptById(Integer id);

  List<ReceiptDto> getAllReceipts();

  boolean deleteReceipt(Integer id);

  ReceiptDto createReceipt(Receipt receipt);

  ReceiptDto updateReceipt(Integer id, ReceiptDto receiptDto);
}
