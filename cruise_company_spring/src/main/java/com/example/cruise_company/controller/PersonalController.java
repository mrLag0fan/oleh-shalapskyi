package com.example.cruise_company.controller;

import com.example.cruise_company.api.PersonalApi;
import com.example.cruise_company.controller.dto.PersonalDto;
import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.PersonalService;
import com.example.cruise_company.service.model.Personal;
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
public class PersonalController implements PersonalApi {

  private final PersonalService personalService;

  @Override
  public List<PersonalDto> getAllPersonals() {
    log.info(this.getClass().getSimpleName() + " getting all personal....");
    return personalService.getAllPersonals();
  }

  @Override
  public PersonalDto getPersonal(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " getting personal by id....");
    return personalService.getPersonal(id);
  }

  @Override
  public PersonalDto createPersonal(@RequestBody @Validated(OnCreate.class) Personal personal) {
    log.info(this.getClass().getSimpleName() + " creating personal....");
    return personalService.createPersonal(personal);
  }

  @Override
  public PersonalDto updatePersonal(
      @PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) PersonalDto personalDto) {
    log.info(this.getClass().getSimpleName() + " updating personal....");
    return personalService.updatePersonal(id, personalDto);
  }

  @Override
  public ResponseEntity<Void> deletePersonal(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting personal....");
    personalService.deletePersonal(id);
    return ResponseEntity.noContent().build();
  }
}
