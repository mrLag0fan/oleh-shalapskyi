package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.LinerDto;
import com.example.cruise_company.service.model.Liner;
import java.util.List;

public interface LinerService {

  LinerDto getLiner(Integer id);

  List<LinerDto> getAllLiners();

  boolean deleteLiner(Integer id);

  LinerDto createLiner(Liner liner);

  LinerDto updateLiner(Integer id, LinerDto linerDto);
}
