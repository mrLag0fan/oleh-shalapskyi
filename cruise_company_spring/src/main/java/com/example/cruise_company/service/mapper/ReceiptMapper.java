package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.ReceiptDto;
import com.example.cruise_company.service.model.Receipt;
import com.example.cruise_company.service.repository.LinerRepository;
import com.example.cruise_company.service.repository.ReceiptStatusRepository;
import com.example.cruise_company.service.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class ReceiptMapper {

  @Autowired protected ReceiptStatusRepository receiptStatusRepository;

  @Autowired protected LinerRepository linerRepository;

  @Autowired protected UserRepository userRepository;

  @Mapping(target = "receiptStatusId", source = "receipt.receiptStatus.id")
  @Mapping(target = "linerId", source = "receipt.liner.id")
  @Mapping(target = "userEmail", source = "receipt.user.email")
  public abstract ReceiptDto toDto(Receipt receipt);

  @Mapping(
      target = "receiptStatus",
      expression =
          "java(receiptStatusRepository.getReceiptStatus(receiptDto.getReceiptStatusId()))")
  @Mapping(target = "liner", expression = "java(linerRepository.getLiner(receiptDto.getLinerId()))")
  @Mapping(target = "user", expression = "java(userRepository.getUser(receiptDto.getUserEmail()))")
  public abstract Receipt toEntity(ReceiptDto receiptDto);
}
