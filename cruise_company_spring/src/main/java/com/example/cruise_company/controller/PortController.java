package com.example.cruise_company.controller;

import com.example.cruise_company.controller.dto.PortDto;
import com.example.cruise_company.service.PortService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/port")
public class PortController {

  private final PortService portService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  public List<PortDto> getAllPorts() {
    log.info(this.getClass().getSimpleName() + " getting all port....");
    return portService.getAllPorts();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  public PortDto getPort(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " getting port by id....");
    return portService.getPortById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public PortDto createPort(@RequestBody PortDto portDto) {
    log.info(this.getClass().getSimpleName() + " creating port....");
    return portService.createPort(portDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  public PortDto updatePort(@PathVariable Integer id, @RequestBody PortDto portDto) {
    log.info(this.getClass().getSimpleName() + " updating port....");
    return portService.updatePort(id, portDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deletePort(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting port....");
    portService.deletePort(id);
    return ResponseEntity.noContent().build();
  }
}
