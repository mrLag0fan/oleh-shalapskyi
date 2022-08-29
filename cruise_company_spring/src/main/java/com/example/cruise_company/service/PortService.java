package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.PortDto;
import java.util.List;

public interface PortService {

  PortDto getPortById(Integer id);

  List<PortDto> getAllPorts();

  boolean deletePort(Integer id);

  PortDto createPort(PortDto portDto);

  PortDto updatePort(Integer id, PortDto portDto);
}
