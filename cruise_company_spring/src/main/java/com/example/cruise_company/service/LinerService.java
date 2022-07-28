package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.LinerDto;
import java.util.List;

public interface LinerService {

  LinerDto getLiner(Integer id);

  List<LinerDto> getAllLiners();

  boolean deleteLiner(Integer id);

  LinerDto createLiner(LinerDto linerDto);

  LinerDto updateLiner(Integer id, LinerDto linerDto);
}
