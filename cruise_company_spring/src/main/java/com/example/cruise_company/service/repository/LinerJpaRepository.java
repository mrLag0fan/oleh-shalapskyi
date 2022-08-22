package com.example.cruise_company.service.repository;

import com.example.cruise_company.service.model.Liner;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LinerJpaRepository extends JpaRepository<Liner, Integer> {

  @Query("select l from Liner l where l.startDate > ?1 and l.endDate < ?2")
  Page<Liner> getAllByStartDateAndEndDate(Date start, Date end, Pageable page);
}
