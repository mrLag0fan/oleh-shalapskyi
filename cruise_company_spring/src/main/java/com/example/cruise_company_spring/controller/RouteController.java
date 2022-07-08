package com.example.cruise_company_spring.controller;

import com.example.cruise_company_spring.controller.dto.RouteDto;
import com.example.cruise_company_spring.service.RouteService;
import com.example.cruise_company_spring.service.model.Route;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/route")
    public List<RouteDto> getAllRoutes() {
        log.info(this.getClass().getSimpleName() + " getting all routes....");
        return routeService.getAllRoutes();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/route/{id}")
    public RouteDto getRoute(@PathVariable Integer id) {
        log.info(this.getClass().getSimpleName() + " getting route by id....");
        return routeService.getRoute(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/route")
    public RouteDto createRoute(@RequestBody Route route) {
        log.info(this.getClass().getSimpleName() + " creating route....");
        return routeService.createRoute(route);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/route/{id}")
    public RouteDto updateRoute(
        @PathVariable Integer id, @RequestBody RouteDto routeDto) {
        log.info(this.getClass().getSimpleName() + " updating route....");
        return routeService.updateRoute(id, routeDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/route/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Integer id) {
        log.info(this.getClass().getSimpleName() + " deleting route....");
        routeService.deleteRoute(id);
        return ResponseEntity.noContent().build();
    }
}
