package com.example.cruise_company_spring.service;

import com.example.cruise_company_spring.controller.dto.PortDto;
import java.util.List;

public interface PortService {

    PortDto getPort(Integer id);

    List<PortDto> getAllPorts();

    boolean deletePort(Integer id);

    PortDto createPort(PortDto portDto);

    PortDto updatePort(Integer id, PortDto portDto);
}
