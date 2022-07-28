package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.ReceiptStatusDto;
import com.example.cruise_company.service.ReceiptStatusService;
import com.example.cruise_company.service.mapper.ReceiptStatusMapper;
import com.example.cruise_company.service.model.ReceiptStatus;
import com.example.cruise_company.service.repository.ReceiptStatusRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ReceiptStatusServiceImpl implements ReceiptStatusService {

  private final ReceiptStatusRepository receiptStatusRepository;

  @Override
  public ReceiptStatusDto getReceiptStatus(Integer id) {
    log.info("get ReceiptStatus by id {}", id);
    ReceiptStatus receiptStatus = receiptStatusRepository.getReceiptStatus(id);
    return ReceiptStatusMapper.INSTANCE.toDto(receiptStatus);
  }

  @Override
  public List<ReceiptStatusDto> getAllReceiptStatuses() {
    log.info("get all receiptStatuss");
    return receiptStatusRepository.getAllReceiptStatuses().stream()
        .map(ReceiptStatusMapper.INSTANCE::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public boolean deleteReceiptStatus(Integer id) {
    log.info("receiptStatus delete by id {}", id);
    return receiptStatusRepository.deleteReceiptStatus(id);
  }

  @Override
  public ReceiptStatusDto createReceiptStatus(ReceiptStatusDto receiptStatusDto) {
    log.info("create receiptStatus with id {}", receiptStatusDto.getId());
    ReceiptStatus receiptStatus = ReceiptStatusMapper.INSTANCE.toEntity(receiptStatusDto);
    receiptStatus = receiptStatusRepository.createReceiptStatus(receiptStatus);
    return ReceiptStatusMapper.INSTANCE.toDto(receiptStatus);
  }

  @Override
  public ReceiptStatusDto updateReceiptStatus(Integer id, ReceiptStatusDto receiptStatusDto) {
    log.info("update receiptStatus with id {}", id);
    ReceiptStatus receiptStatus = ReceiptStatusMapper.INSTANCE.toEntity(receiptStatusDto);
    receiptStatus.setId(id);
    receiptStatus = receiptStatusRepository.updateReceiptStatus(id, receiptStatus);
    return ReceiptStatusMapper.INSTANCE.toDto(receiptStatus);
  }
}
