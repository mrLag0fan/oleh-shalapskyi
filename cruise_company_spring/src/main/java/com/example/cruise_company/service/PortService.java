package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.PortDto;
import java.util.List;

public interface PortService {

  PortDto getPort(Integer id);

  List<PortDto> getAllPorts(Integer offset, Integer limit, String field, String sortType);

  void deletePort(Integer id);

  PortDto createPort(PortDto portDto);

  PortDto updatePort(Integer id, PortDto portDto);
}
