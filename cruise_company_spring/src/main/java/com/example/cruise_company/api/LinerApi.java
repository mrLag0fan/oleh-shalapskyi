package com.example.cruise_company.api;

import com.example.cruise_company.controller.dto.LinerDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
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
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(tags = "Liner API")
@RequestMapping("/api/v1/liners")
public interface LinerApi {

  @ApiOperation("Get all liners")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  List<LinerDto> getAllLiners();

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Liner id")
  @ApiOperation("Get liner")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  LinerDto getLiner(@PathVariable Integer id);

  @ApiOperation("Create liner")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  LinerDto createLiner(@RequestBody LinerDto linerDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Liner id")
  @ApiOperation("Update liner")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  LinerDto updateLiner(@PathVariable Integer id, @RequestBody LinerDto linerDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Liner id")
  @ApiOperation("Delete liner")
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  ResponseEntity<Void> deleteLiner(@PathVariable Integer id);
}
