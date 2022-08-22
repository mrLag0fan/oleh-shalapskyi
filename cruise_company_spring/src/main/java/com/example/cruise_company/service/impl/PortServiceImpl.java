package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.PortDto;
import com.example.cruise_company.exception.entity_not_found.PortNotFoundException;
import com.example.cruise_company.service.PortService;
import com.example.cruise_company.service.mapper.PortMapper;
import com.example.cruise_company.service.model.Port;
import com.example.cruise_company.service.other.GetAllService;
import com.example.cruise_company.service.repository.PortJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PortServiceImpl implements PortService {

  private final PortJpaRepository portRepository;

  @Override
  public PortDto getPort(Integer id) {
    log.info("get Port by id {}", id);
    Port port = portRepository.findById(id).orElseThrow(PortNotFoundException::new);
    return PortMapper.INSTANCE.toDto(port);
  }

  @Override
  public List<PortDto> getAllPorts(Integer offset, Integer limit, String field, String sortType) {
    log.info("get all ports");
    Pageable page = GetAllService.getSortedPage(offset, limit, field, sortType);
    return portRepository.findAll(page).stream()
        .map(PortMapper.INSTANCE::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public void deletePort(Integer id) {
    log.info("Port delete by id {}", id);
    portRepository.findById(id).orElseThrow(PortNotFoundException::new);
    portRepository.deleteById(id);
  }

  @Override
  public PortDto createPort(PortDto portDto) {
    log.info("create Port with id {}", portDto.getName());
    Port port = PortMapper.INSTANCE.toEntity(portDto);
    port = portRepository.save(port);
    return PortMapper.INSTANCE.toDto(port);
  }

  @Override
  public PortDto updatePort(Integer id, PortDto portDto) {
    log.info("update Port with id {}", id);
    Port persisted = portRepository.findById(id).orElseThrow(PortNotFoundException::new);
    PortMapper.INSTANCE.update(persisted, portDto);
    return PortMapper.INSTANCE.toDto(persisted);
  }
}
