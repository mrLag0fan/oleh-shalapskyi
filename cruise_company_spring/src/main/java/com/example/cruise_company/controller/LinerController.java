package com.example.cruise_company.controller;

import com.example.cruise_company.controller.dto.LinerDto;
import com.example.cruise_company.service.LinerService;
import com.example.cruise_company.service.model.Liner;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/liner")
public class LinerController {

  private final LinerService linerService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  public List<LinerDto> getAllLiners() {
    log.info(this.getClass().getSimpleName() + " getting all liners....");
    return linerService.getAllLiners();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  public LinerDto getLiner(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " getting liner by id....");
    return linerService.getLinerById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public LinerDto createLiner(@RequestBody Liner liner) {
    log.info(this.getClass().getSimpleName() + " creating liner....");
    return linerService.createLiner(liner);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  public LinerDto updateLiner(@PathVariable Integer id, @RequestBody LinerDto linerDto) {
    log.info(this.getClass().getSimpleName() + " updating liner....");
    return linerService.updateLiner(id, linerDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deleteLiner(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting liner....");
    linerService.deleteLiner(id);
    return ResponseEntity.noContent().build();
  }
}
