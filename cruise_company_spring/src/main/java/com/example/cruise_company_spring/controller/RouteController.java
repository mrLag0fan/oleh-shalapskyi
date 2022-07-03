package com.example.cruise_company_spring.controller;

import com.example.cruise_company_spring.controller.dto.RouteDto;
import com.example.cruise_company_spring.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RouteController {


    private final RouteService routeService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/route")
    public List<RouteDto> getAllRoutes(){
        return routeService.getAllRoutes();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/route/{from}/{to}")
    public RouteDto getRoute(@PathVariable Integer from, @PathVariable Integer to){
        return routeService.getRoute(from, to);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/route")
    public RouteDto createRoute(@RequestBody RouteDto routeDto){
        return routeService.createRoute(routeDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/route/{from}/{to}")
    public RouteDto updateRoute(@PathVariable Integer from, @PathVariable Integer to, @RequestBody RouteDto routeDto){
        return routeService.updateRoute(from, to, routeDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/route/{from}/{to}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Integer from, @PathVariable Integer to){
        routeService.deleteRoute(from, to);
        return ResponseEntity.noContent().build();
    }

}
