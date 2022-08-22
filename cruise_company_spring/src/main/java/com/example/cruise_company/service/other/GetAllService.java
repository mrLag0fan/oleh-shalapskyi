package com.example.cruise_company.service.other;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class GetAllService {

  public static Pageable getSortedPage(
      Integer offset, Integer limit, String field, String sortType) {
    Sort.Direction sortTypeLocal = Sort.Direction.ASC;
    if (sortType != null && sortType.equals("DESC")) {
      sortTypeLocal = Sort.Direction.DESC;
    }
    Sort sort = Sort.by(sortTypeLocal, "id");
    if (field != null) {
      sort = Sort.by(sortTypeLocal, field);
    }
    return PageRequest.of(offset, limit, sort);
  }
}
