package com.example.cruise_company.controller;

import com.example.cruise_company.api.PersonalApi;
import com.example.cruise_company.controller.dto.PersonalDto;
import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.PersonalService;
import com.example.cruise_company.service.model.Personal;
import java.util.List;
import javax.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PersonalController implements PersonalApi {

  private final PersonalService personalService;

  @Override
  public List<PersonalDto> getAllPersonals(
      @PathVariable @Min(value = 0) Integer offset,
      @PathVariable @Min(value = 0) Integer limit,
      @RequestHeader String field,
      @RequestHeader String sortType) {
    log.info(this.getClass().getSimpleName() + " getting all personal....");
    return personalService.getAllPersonals(offset, limit, field, sortType);
  }

  @Override
  public PersonalDto getPersonalById(@PathVariable @Min(value = 1) Integer id) {
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
      @PathVariable @Min(value = 1) Integer id,
      @RequestBody @Validated(OnUpdate.class) PersonalDto personalDto) {
    log.info(this.getClass().getSimpleName() + " updating personal....");
    return personalService.updatePersonal(id, personalDto);
  }

  @Override
  public HttpStatus deletePersonal(@PathVariable @Min(value = 1) Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting personal....");
    return personalService.deletePersonal(id) ? HttpStatus.OK : HttpStatus.NO_CONTENT;
  }
}
