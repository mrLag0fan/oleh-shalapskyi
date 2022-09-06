package com.example.cruise_company.api;

import com.example.cruise_company.controller.dto.PortDto;
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

@Api(tags = "Port API")
@RequestMapping("/api/v1/ports")
public interface PortApi {

  @ApiOperation("Get all ports")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  List<PortDto> getAllPorts();

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Port id")
  @ApiOperation("Get port")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  PortDto getPortById(@PathVariable Integer id);

  @ApiOperation("Create port")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  PortDto createPort(@RequestBody PortDto portDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Port id")
  @ApiOperation("Update port")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  PortDto updatePort(@PathVariable Integer id, @RequestBody PortDto portDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Port id")
  @ApiOperation("Delete port")
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  HttpStatus deletePort(@PathVariable Integer id);
}
