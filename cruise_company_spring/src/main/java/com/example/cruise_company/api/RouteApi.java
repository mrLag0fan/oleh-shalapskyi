package com.example.cruise_company.api;

import com.example.cruise_company.controller.dto.RouteDto;
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

@Api(tags = "Routes API")
@RequestMapping("/api/v1/routes")
public interface RouteApi {

  @ApiOperation("Get all routes")
  @ResponseStatus(HttpStatus.OK)
  @ApiImplicitParams({
    @ApiImplicitParam(name = "offset", paramType = "query", value = "Offset", required = true),
    @ApiImplicitParam(name = "limit", paramType = "query", value = "Limit", required = true),
    @ApiImplicitParam(
        name = "field",
        paramType = "query",
        value = "Sort By",
        allowableValues = "id, from, to"),
    @ApiImplicitParam(
        name = "sortType",
        paramType = "query",
        value = "Sort By",
        allowableValues = "ASC, DESC")
  })
  @GetMapping
  List<RouteDto> getAllRoutes(
      @RequestParam Integer offset,
      @RequestParam Integer limit,
      @RequestParam String field,
      @RequestParam String sortType);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "Route id")
  @ApiOperation("Get route")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  RouteDto getRoute(@PathVariable Integer id);

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
  ResponseEntity<Void> deleteRoute(@PathVariable Integer id);
}
