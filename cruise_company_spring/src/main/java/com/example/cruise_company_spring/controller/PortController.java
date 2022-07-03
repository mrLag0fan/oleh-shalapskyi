package com.example.cruise_company_spring.controller;

import com.example.cruise_company_spring.controller.dto.PortDto;
import com.example.cruise_company_spring.service.PortService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PortController{

    private final PortService portService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/port")
    public List<PortDto> getAllPorts(){
        return portService.getAllPorts();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/port/{id}")
    public PortDto getPort(@PathVariable Integer id){
        return portService.getPort(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/port")
    public PortDto createPort(@RequestBody PortDto portDto){
        return portService.createPort(portDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/port/{id}")
    public PortDto updatePort(@PathVariable Integer id, @RequestBody PortDto portDto){
        return portService.updatePort(id, portDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/port/{id}")
    public ResponseEntity<Void> deletePort(@PathVariable Integer id){
        portService.deletePort(id);
        return ResponseEntity.noContent().build();
    }

}
