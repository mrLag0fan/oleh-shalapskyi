package com.example.cruise_company_spring.service;

import com.example.cruise_company_spring.controller.dto.ReceiptDto;
import com.example.cruise_company_spring.service.model.Receipt;
import java.util.List;

public interface ReceiptService {

    ReceiptDto getReceipt(Integer id);

    List<ReceiptDto> getAllReceipts();

    boolean deleteReceipt(Integer id);

    ReceiptDto createReceipt(Receipt receipt);

    ReceiptDto updateReceipt(Integer id, ReceiptDto receiptDto);
}
