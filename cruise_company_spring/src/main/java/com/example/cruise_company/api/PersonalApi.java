package com.example.cruise_company.api;

import com.example.cruise_company.controller.dto.PersonalDto;
import com.example.cruise_company.service.model.Personal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(tags = "Personal API")
@RequestMapping("/api/v1/personal")
public interface PersonalApi {

  @ApiOperation("Get all personal")
  @ResponseStatus(HttpStatus.OK)
  @ApiImplicitParams({
    @ApiImplicitParam(name = "offset", paramType = "query", value = "Offset", required = true),
    @ApiImplicitParam(name = "limit", paramType = "query", value = "Limit", required = true),
    @ApiImplicitParam(
        name = "field",
        paramType = "query",
        value = "Sort By",
        allowableValues = "id, experience, linerId, personalRoleId"),
    @ApiImplicitParam(
        name = "sortType",
        paramType = "query",
        value = "Sort By",
        allowableValues = "ASC, DESC")
  })
  @GetMapping
  List<PersonalDto> getAllPersonals(
      @RequestParam Integer offset,
      @RequestParam Integer limit,
      @RequestParam String field,
      @RequestParam String sortType);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Personal id")
  @ApiOperation("Get personal")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  PersonalDto getPersonalById(@PathVariable Integer id);

  @ApiOperation("Create personal")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  PersonalDto createPersonal(@RequestBody Personal personal);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Personal id")
  @ApiOperation("Update personal")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  PersonalDto updatePersonal(@PathVariable Integer id, @RequestBody PersonalDto personalDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Personal id")
  @ApiOperation("Delete personal")
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  HttpStatus deletePersonal(@PathVariable Integer id);
}
