package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.ReceiptDto;
import com.example.cruise_company.service.ReceiptService;
import com.example.cruise_company.service.model.Receipt;
import com.example.cruise_company.service.repository.LinerRepository;
import com.example.cruise_company.service.repository.ReceiptRepository;
import com.example.cruise_company.service.repository.ReceiptStatusRepository;
import com.example.cruise_company.service.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {

  private final ReceiptRepository receiptRepository;
  private final ReceiptStatusRepository receiptStatusRepository;
  private final LinerRepository linerRepository;
  private final UserRepository userRepository;

  @Override
  public ReceiptDto getReceipt(Integer id) {
    log.info("get Receipt with id {}", id);
    Receipt receipt = receiptRepository.getReceipt(id);
    return mapReceiptToReceiptDto(receipt);
  }

  @Override
  public List<ReceiptDto> getAllReceipts() {
    log.info("get all receipts");
    return receiptRepository.getAllReceipts().stream()
        .map(this::mapReceiptToReceiptDto)
        .collect(Collectors.toList());
  }

  @Override
  public boolean deleteReceipt(Integer id) {
    log.info("Receipt delete by  id {}", id);
    return receiptRepository.deleteReceipt(id);
  }

  @Override
  public ReceiptDto createReceipt(Receipt receipt) {
    log.info("create Receipt with id {}", receipt.getId());
    receiptRepository.createReceipt(receipt);
    return mapReceiptToReceiptDto(receipt);
  }

  @Override
  public ReceiptDto updateReceipt(Integer id, ReceiptDto receiptDto) {
    log.info("update Receipt with id {}", id);
    Receipt receiptStatus = mapReceiptDtoToReceipt(receiptDto);
    receiptStatus = receiptRepository.updateReceipt(id, receiptStatus);
    return mapReceiptToReceiptDto(receiptStatus);
  }

  private ReceiptDto mapReceiptToReceiptDto(Receipt receipt) {
    return ReceiptDto.builder()
        .id(receipt.getId())
        .documentsPath(receipt.getDocumentsPath())
        .price(receipt.getPrice())
        .liner(linerRepository.getLiner(receipt.getLinerId()))
        .receiptStatus(receiptStatusRepository.getReceiptStatus(receipt.getReceiptStatusId()))
        .user(userRepository.getUser(receipt.getUserEmail()))
        .build();
  }

  private Receipt mapReceiptDtoToReceipt(ReceiptDto receiptDto) {
    return Receipt.builder()
        .id(receiptDto.getId())
        .documentsPath(receiptDto.getDocumentsPath())
        .price(receiptDto.getPrice())
        .receiptStatusId(receiptDto.getReceiptStatus().getId())
        .linerId(receiptDto.getLiner().getId())
        .userEmail(receiptDto.getUser().getEmail())
        .build();
  }
}
