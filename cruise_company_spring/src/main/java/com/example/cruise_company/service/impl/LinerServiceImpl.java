package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.LinerDto;
import com.example.cruise_company.service.LinerService;
import com.example.cruise_company.service.mapper.LinerMapper;
import com.example.cruise_company.service.model.Liner;
import com.example.cruise_company.service.repository.LinerRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinerServiceImpl implements LinerService {

  private final LinerRepository linerRepository;
  private final LinerMapper linerMapper;

  @Override
  public LinerDto getLiner(Integer id) {
    log.info("get Liner by id {}", id);
    Liner liner = linerRepository.getLiner(id);
    return linerMapper.toDto(liner);
  }

  @Override
  public List<LinerDto> getAllLiners() {
    log.info("get all liners");
    return linerRepository.getAllLiners().stream()
        .map(linerMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public boolean deleteLiner(Integer id) {
    log.info("liner delete by id {}", id);
    return linerRepository.deleteLiner(id);
  }

  @Override
  public LinerDto createLiner(LinerDto linerDto) {
    log.info("create liner with id {}", linerDto.getId());
    Liner liner = linerMapper.toEntity(linerDto);
    liner = linerRepository.createLiner(liner);
    return linerMapper.toDto(liner);
  }

  @Override
  public LinerDto updateLiner(Integer id, LinerDto linerDto) {
    log.info("update liner with id {}", id);
    Liner liner = linerMapper.toEntity(linerDto);
    liner.setId(id);
    liner = linerRepository.updateLiner(id, liner);
    return linerMapper.toDto(liner);
  }
}
