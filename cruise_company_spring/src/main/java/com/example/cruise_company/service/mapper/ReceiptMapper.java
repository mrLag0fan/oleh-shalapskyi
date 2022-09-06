package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.ReceiptDto;
import com.example.cruise_company.service.model.Receipt;
import com.example.cruise_company.service.repository.LinerJpaRepository;
import com.example.cruise_company.service.repository.ReceiptStatusJpaRepository;
import com.example.cruise_company.service.repository.UserJpaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class ReceiptMapper {

  @Autowired protected ReceiptStatusJpaRepository receiptStatusRepository;

  @Autowired protected LinerJpaRepository linerRepository;

  @Autowired protected UserJpaRepository userRepository;

  @Mapping(target = "receiptStatusId", source = "receipt.receiptStatus.id")
  @Mapping(target = "linerId", source = "receipt.liner.id")
  @Mapping(target = "userEmail", source = "receipt.user.email")
  public abstract ReceiptDto toDto(Receipt receipt);

  @Mapping(
      target = "receiptStatus",
      expression = "java(receiptStatusRepository.findById(receiptDto.getReceiptStatusId()).get())")
  @Mapping(
      target = "liner",
      expression = "java(linerRepository.findById(receiptDto.getLinerId()).get())")
  @Mapping(
      target = "user",
      expression = "java(userRepository.findByEmail(receiptDto.getUserEmail()).get())")
  public abstract Receipt toEntity(ReceiptDto receiptDto);

  @Mapping(target = "id", ignore = true)
  public abstract void update(@MappingTarget Receipt receipt, ReceiptDto receiptDto);
}
