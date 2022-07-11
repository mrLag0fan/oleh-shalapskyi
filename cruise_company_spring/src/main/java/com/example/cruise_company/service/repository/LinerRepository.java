package com.example.cruise_company.service.repository;

import com.example.cruise_company.service.model.Liner;
import java.util.List;

public interface LinerRepository {

  Liner getLiner(Integer id);

  List<Liner> getAllLiners();

  boolean deleteLiner(Integer id);

  Liner createLiner(Liner liner);

  Liner updateLiner(Integer id, Liner liner);
}
