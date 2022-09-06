package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.ReceiptDto;
import com.example.cruise_company.exception.entity_not_found.ReceiptNotFoundException;
import com.example.cruise_company.service.ReceiptService;
import com.example.cruise_company.service.mapper.ReceiptMapper;
import com.example.cruise_company.service.model.Receipt;
import com.example.cruise_company.service.other.GetAllService;
import com.example.cruise_company.service.repository.LinerJpaRepository;
import com.example.cruise_company.service.repository.ReceiptJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class ReceiptServiceImpl implements ReceiptService {

  private final ReceiptJpaRepository receiptRepository;
  private final LinerJpaRepository linerRepository;
  private final ReceiptMapper receiptMapper;

  @Override
  public ReceiptDto getReceipt(Integer id) {
    log.info("get Receipt with id {}", id);
    Receipt receipt = receiptRepository.findById(id).orElseThrow(ReceiptNotFoundException::new);
    return receiptMapper.toDto(receipt);
  }

  @Override
  public List<ReceiptDto> getAllReceipts(
      Integer offset, Integer limit, String field, String sortType) {
    log.info("get all receipts");
    Pageable page = GetAllService.getSortedPage(offset, limit, field, sortType);
    return receiptRepository.findAll(page).stream()
        .map(receiptMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public void deleteReceipt(Integer id) {
    log.info("Receipt delete by  id {}", id);
    receiptRepository.findById(id).orElseThrow(ReceiptNotFoundException::new);
    receiptRepository.deleteById(id);
  }

  @Override
  public ReceiptDto createReceipt(ReceiptDto receiptDto) {
    log.info("create Receipt with id {}", receiptDto.getId());
    Receipt receipt = receiptMapper.toEntity(receiptDto);
    receipt.setPrice(linerRepository.getById(receiptDto.getLinerId()).getPrice());
    receipt = receiptRepository.save(receipt);
    return receiptMapper.toDto(receipt);
  }

  @Override
  public ReceiptDto updateReceipt(Integer id, ReceiptDto receiptDto) {
    log.info("update Receipt with id {}", id);
    Receipt persisted = receiptRepository.findById(id).orElseThrow(ReceiptNotFoundException::new);
    receiptMapper.update(persisted, receiptDto);
    return receiptMapper.toDto(persisted);
  }
}
