package com.example.cruise_company_spring.service;

import com.example.cruise_company_spring.controller.dto.ReceiptStatusDto;

import java.util.List;

public interface ReceiptStatusService {

    ReceiptStatusDto getReceiptStatus(Integer id);
    List<ReceiptStatusDto> getAllReceiptStatuses();
    boolean deleteReceiptStatus(Integer id);
    ReceiptStatusDto createReceiptStatus(ReceiptStatusDto receiptStatusDto);
    ReceiptStatusDto updateReceiptStatus(Integer id, ReceiptStatusDto receiptStatusDto);

}
