package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.ReceiptDto;
import com.example.cruise_company.service.ReceiptService;
import com.example.cruise_company.service.mapper.ReceiptMapper;
import com.example.cruise_company.service.model.Receipt;
import com.example.cruise_company.service.repository.LinerRepository;
import com.example.cruise_company.service.repository.ReceiptRepository;
import com.example.cruise_company.service.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiptServiceImpl implements ReceiptService {

  private final ReceiptRepository receiptRepository;
  private final LinerRepository linerRepository;
  private final UserRepository userRepository;
  private final ReceiptMapper receiptMapper;

  @Override
  public ReceiptDto getReceipt(Integer id) {
    log.info("get Receipt with id {}", id);
    Receipt receipt = receiptRepository.getReceipt(id);
    return receiptMapper.toDto(receipt);
  }

  @Override
  public List<ReceiptDto> getAllReceipts() {
    log.info("get all receipts");
    return receiptRepository.getAllReceipts().stream()
        .map(receiptMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public boolean deleteReceipt(Integer id) {
    log.info("Receipt delete by  id {}", id);
    return receiptRepository.deleteReceipt(id);
  }

  @Override
  public ReceiptDto createReceipt(ReceiptDto receiptDto) {
    log.info("create Receipt with id {}", receiptDto.getId());
    Receipt receipt = receiptMapper.toEntity(receiptDto);
    receipt.setPrice(linerRepository.getLiner(receiptDto.getLinerId()).getPrice());
    receipt = receiptRepository.createReceipt(receipt);
    return receiptMapper.toDto(receipt);
  }

  @Override
  public ReceiptDto updateReceipt(Integer id, ReceiptDto receiptDto) {
    log.info("update Receipt with id {}", id);
    Receipt receipt = receiptMapper.toEntity(receiptDto);
    receipt.setId(id);
    receipt.setPrice(receiptDto.getPrice());
    receipt.setLiner(linerRepository.getLiner(receiptDto.getLinerId()));
    receipt.setUser(userRepository.getUser(receiptDto.getUserEmail()));
    receipt = receiptRepository.updateReceipt(id, receipt);
    return receiptMapper.toDto(receipt);
  }
}
