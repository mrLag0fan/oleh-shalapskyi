package com.example.cruise_company_spring.service;

import com.example.cruise_company_spring.controller.dto.LinerDto;
import com.example.cruise_company_spring.service.model.Liner;
import java.util.List;

public interface LinerService {

    LinerDto getLiner(Integer id);

    List<LinerDto> getAllLiners();

    boolean deleteLiner(Integer id);

    LinerDto createLiner(Liner liner);

    LinerDto updateLiner(Integer id, LinerDto linerDto);
}
