package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.ReceiptStatusDto;
import com.example.cruise_company.service.ReceiptStatusService;
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
public class ReceiptStatusServiceIMpl implements ReceiptStatusService {

  private final ReceiptStatusRepository receiptStatusRepository;

  @Override
  public ReceiptStatusDto getReceiptStatus(Integer id) {
    log.info("get ReceiptStatus by id {}", id);
    ReceiptStatus receiptStatus = receiptStatusRepository.getReceiptStatus(id);
    return mapReceiptStatusToReceiptStatusDto(receiptStatus);
  }

  @Override
  public List<ReceiptStatusDto> getAllReceiptStatuses() {
    log.info("get all receiptStatuss");
    return receiptStatusRepository.getAllReceiptStatuses().stream()
        .map(this::mapReceiptStatusToReceiptStatusDto)
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
    ReceiptStatus receiptStatus = mapReceiptStatusDtoToReceiptStatus(receiptStatusDto);
    receiptStatus = receiptStatusRepository.createReceiptStatus(receiptStatus);
    return mapReceiptStatusToReceiptStatusDto(receiptStatus);
  }

  @Override
  public ReceiptStatusDto updateReceiptStatus(Integer id, ReceiptStatusDto receiptStatusDto) {
    log.info("update receiptStatus with id {}", id);
    ReceiptStatus receiptStatus = mapReceiptStatusDtoToReceiptStatus(receiptStatusDto);
    receiptStatus = receiptStatusRepository.updateReceiptStatus(id, receiptStatus);
    return mapReceiptStatusToReceiptStatusDto(receiptStatus);
  }

  private ReceiptStatusDto mapReceiptStatusToReceiptStatusDto(ReceiptStatus receiptStatus) {
    return ReceiptStatusDto.builder()
        .id(receiptStatus.getId())
        .name(receiptStatus.getName())
        .build();
  }

  private ReceiptStatus mapReceiptStatusDtoToReceiptStatus(ReceiptStatusDto receiptStatusDto) {
    return ReceiptStatus.builder()
        .id(receiptStatusDto.getId())
        .name(receiptStatusDto.getName())
        .build();
  }
}
