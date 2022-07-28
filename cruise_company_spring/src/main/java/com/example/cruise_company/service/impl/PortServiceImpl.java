package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.PortDto;
import com.example.cruise_company.service.PortService;
import com.example.cruise_company.service.mapper.PortMapper;
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
  public PortDto getPort(Integer id) {
    log.info("get Port by id {}", id);
    Port port = portRepository.getPort(id);
    return PortMapper.INSTANCE.toDto(port);
  }

  @Override
  public List<PortDto> getAllPorts() {
    log.info("get all ports");
    return portRepository.getAllPorts().stream()
        .map(PortMapper.INSTANCE::toDto)
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
    Port port = PortMapper.INSTANCE.toEntity(portDto);
    port = portRepository.createPort(port);
    return PortMapper.INSTANCE.toDto(port);
  }

  @Override
  public PortDto updatePort(Integer id, PortDto portDto) {
    log.info("update Port with id {}", id);
    Port port = PortMapper.INSTANCE.toEntity(portDto);
    port.setId(id);
    port = portRepository.updatePort(id, port);
    return PortMapper.INSTANCE.toDto(port);
  }
}
