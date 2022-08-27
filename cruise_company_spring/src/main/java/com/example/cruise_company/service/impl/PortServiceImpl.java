package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.PortDto;
import com.example.cruise_company.service.PortService;
import com.example.cruise_company.service.model.Port;
import com.example.cruise_company.service.repository.PortRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PortServiceImpl implements PortService {

  private final PortRepository portRepository;

  @Override
  public PortDto getPortById(Integer id) {
    log.info("get Port by id {}", id);
    Port port = portRepository.getPort(id);
    return mapPortToPortDto(port);
  }

  @Override
  public List<PortDto> getAllPorts() {
    log.info("get all ports");
    return portRepository.getAllPorts().stream()
        .map(this::mapPortToPortDto)
        .collect(Collectors.toList());
  }

  @Override
  public boolean deletePort(Integer id) {
    log.info("Port delete by id {}", id);
    return portRepository.deletePort(id);
  }

  @Override
  public PortDto createPort(PortDto portDto) {
    log.info("create Port with id {}", portDto.getName());
    Port port = mapPortDtoToPort(portDto);
    port = portRepository.createPort(port);
    return mapPortToPortDto(port);
  }

  @Override
  public PortDto updatePort(Integer id, PortDto portDto) {
    log.info("update Port with id {}", id);
    Port port = mapPortDtoToPort(portDto);
    port = portRepository.updatePort(id, port);
    return mapPortToPortDto(port);
  }

  private PortDto mapPortToPortDto(Port port) {
    return PortDto.builder().id(port.getId()).name(port.getName()).build();
  }

  private Port mapPortDtoToPort(PortDto portDto) {
    return Port.builder().id(portDto.getId()).name(portDto.getName()).build();
  }
}
