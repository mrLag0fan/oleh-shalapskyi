package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.ReceiptStatusDto;
import com.example.cruise_company.service.model.ReceiptStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceiptStatusMapper {

  ReceiptStatusMapper INSTANCE = Mappers.getMapper(ReceiptStatusMapper.class);

  ReceiptStatusDto toDto(ReceiptStatus receiptStatus);

  ReceiptStatus toEntity(ReceiptStatusDto receiptStatusDto);
}
