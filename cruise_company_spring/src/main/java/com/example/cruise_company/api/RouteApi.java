package com.example.cruise_company.api;

import com.example.cruise_company.controller.dto.RouteDto;
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

@Api(tags = "Routes API")
@RequestMapping("/api/v1/routes")
public interface RouteApi {

  @ApiOperation("Get all routes")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  List<RouteDto> getAllRoutes();

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Route id")
  @ApiOperation("Get route")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  RouteDto getRouteById(@PathVariable Integer id);

  @ApiOperation("Create route")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  RouteDto createRoute(@RequestBody RouteDto routeDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Route id")
  @ApiOperation("Update route")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  RouteDto updateRoute(@PathVariable Integer id, @RequestBody RouteDto routeDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Route id")
  @ApiOperation("Delete route")
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  HttpStatus deleteRoute(@PathVariable Integer id);
}
