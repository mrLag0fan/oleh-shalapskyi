package com.example.cruise_company.controller;

import com.example.cruise_company.api.LinerApi;
import com.example.cruise_company.controller.dto.LinerDto;
import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.LinerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LinerController implements LinerApi {

  private final LinerService linerService;

  @Override
  public List<LinerDto> getAllLiners() {
    log.info(this.getClass().getSimpleName() + " getting all liners....");
    return linerService.getAllLiners();
  }

  @Override
  public LinerDto getLiner(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " getting liner by id....");
    return linerService.getLiner(id);
  }

  @Override
  public LinerDto createLiner(@RequestBody @Validated(OnCreate.class) LinerDto linerDto) {
    log.info(this.getClass().getSimpleName() + " creating liner....");
    return linerService.createLiner(linerDto);
  }

  @Override
  public LinerDto updateLiner(
      @PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) LinerDto linerDto) {
    log.info(this.getClass().getSimpleName() + " updating liner....");
    return linerService.updateLiner(id, linerDto);
  }

  @Override
  public ResponseEntity<Void> deleteLiner(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting liner....");
    linerService.deleteLiner(id);
    return ResponseEntity.noContent().build();
  }
}
