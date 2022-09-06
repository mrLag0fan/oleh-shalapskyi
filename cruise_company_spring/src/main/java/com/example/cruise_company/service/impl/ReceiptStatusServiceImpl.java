package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.ReceiptStatusDto;
import com.example.cruise_company.exception.entity_not_found.ReceiptStatusNotFoundException;
import com.example.cruise_company.service.ReceiptStatusService;
import com.example.cruise_company.service.mapper.ReceiptStatusMapper;
import com.example.cruise_company.service.model.ReceiptStatus;
import com.example.cruise_company.service.other.GetAllService;
import com.example.cruise_company.service.repository.ReceiptStatusJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReceiptStatusServiceImpl implements ReceiptStatusService {

  private final ReceiptStatusJpaRepository receiptStatusRepository;

  @Override
  public ReceiptStatusDto getReceiptStatus(Integer id) {
    log.info("get ReceiptStatus by id {}", id);
    ReceiptStatus receiptStatus =
        receiptStatusRepository.findById(id).orElseThrow(ReceiptStatusNotFoundException::new);
    return ReceiptStatusMapper.INSTANCE.toDto(receiptStatus);
  }

  @Override
  public List<ReceiptStatusDto> getAllReceiptStatuses(
      Integer offset, Integer limit, String field, String sortType) {
    log.info("get all receiptStatuss");
    Pageable page = GetAllService.getSortedPage(offset, limit, field, sortType);
    return receiptStatusRepository.findAll(page).stream()
        .map(ReceiptStatusMapper.INSTANCE::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public void deleteReceiptStatus(Integer id) {
    log.info("receiptStatus delete by id {}", id);
    receiptStatusRepository.findById(id).orElseThrow(ReceiptStatusNotFoundException::new);
    receiptStatusRepository.deleteById(id);
  }

  @Override
  public ReceiptStatusDto createReceiptStatus(ReceiptStatusDto receiptStatusDto) {
    log.info("create receiptStatus with id {}", receiptStatusDto.getId());
    ReceiptStatus receiptStatus = ReceiptStatusMapper.INSTANCE.toEntity(receiptStatusDto);
    receiptStatus = receiptStatusRepository.save(receiptStatus);
    return ReceiptStatusMapper.INSTANCE.toDto(receiptStatus);
  }

  @Override
  public ReceiptStatusDto updateReceiptStatus(Integer id, ReceiptStatusDto receiptStatusDto) {
    log.info("update receiptStatus with id {}", id);
    ReceiptStatus persisted =
        receiptStatusRepository.findById(id).orElseThrow(ReceiptStatusNotFoundException::new);
    ReceiptStatusMapper.INSTANCE.update(persisted, receiptStatusDto);
    return ReceiptStatusMapper.INSTANCE.toDto(persisted);
  }
}
