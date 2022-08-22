package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.LinerDto;
import java.util.Date;
import java.util.List;

public interface LinerService {

  LinerDto getLiner(Integer id);

  List<LinerDto> getAllLiners(
      Integer offset, Integer limit, String field, String sortType, Date start, Date end);

  void deleteLiner(Integer id);

  LinerDto createLiner(LinerDto linerDto);

  LinerDto updateLiner(Integer id, LinerDto linerDto);
}
