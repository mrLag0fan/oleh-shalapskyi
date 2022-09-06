package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.LinerDto;
import com.example.cruise_company.exception.entity_not_found.LinerNotFoundException;
import com.example.cruise_company.service.LinerService;
import com.example.cruise_company.service.mapper.LinerMapper;
import com.example.cruise_company.service.model.Liner;
import com.example.cruise_company.service.other.GetAllService;
import com.example.cruise_company.service.repository.LinerJpaRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class LinerServiceImpl implements LinerService {

  private final LinerJpaRepository linerRepository;
  private final LinerMapper linerMapper;

  @Override
  public LinerDto getLiner(Integer id) {
    log.info("get Liner by id {}", id);
    Liner liner = linerRepository.findById(id).orElseThrow(LinerNotFoundException::new);
    return linerMapper.toDto(liner);
  }

  @Override
  public List<LinerDto> getAllLiners(
      Integer offset, Integer limit, String field, String sortType, Date startDate, Date endDate) {
    log.info("get all liners");
    Page<Liner> liners;
    Pageable page = GetAllService.getSortedPage(offset, limit, field, sortType);
    if (startDate != null && endDate != null) {
      liners = linerRepository.getAllByStartDateAndEndDate(startDate, endDate, page);
    } else {
      liners = linerRepository.findAll(page);
    }
    return liners.stream().map(linerMapper::toDto).collect(Collectors.toList());
  }

  @Override
  public void deleteLiner(Integer id) {
    log.info("liner delete by id {}", id);
    linerRepository.findById(id).orElseThrow(LinerNotFoundException::new);
    linerRepository.deleteById(id);
  }

  @Override
  public LinerDto createLiner(LinerDto linerDto) {
    log.info("create liner with id {}", linerDto.getId());
    Liner liner = linerMapper.toEntity(linerDto);
    liner = linerRepository.save(liner);
    return linerMapper.toDto(liner);
  }

  @Override
  public LinerDto updateLiner(Integer id, LinerDto linerDto) {
    log.info("update liner with id {}", id);
    Liner persisted = linerRepository.findById(id).orElseThrow(LinerNotFoundException::new);
    linerMapper.update(persisted, linerDto);
    return linerMapper.toDto(persisted);
  }
}
