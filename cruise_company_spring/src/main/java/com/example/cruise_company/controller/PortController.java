package com.example.cruise_company.controller;

import com.example.cruise_company.api.PortApi;
import com.example.cruise_company.controller.dto.PortDto;
import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.PortService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PortController implements PortApi {

  private final PortService portService;

  @Override
  public List<PortDto> getAllPorts() {
    log.info(this.getClass().getSimpleName() + " getting all port....");
    return portService.getAllPorts();
  }

  @Override
  public PortDto getPort(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " getting port by id....");
    return portService.getPort(id);
  }

  @Override
  public PortDto createPort(@RequestBody @Validated(OnCreate.class) PortDto portDto) {
    log.info(this.getClass().getSimpleName() + " creating port....");
    return portService.createPort(portDto);
  }

  @Override
  public PortDto updatePort(
      @PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) PortDto portDto) {
    log.info(this.getClass().getSimpleName() + " updating port....");
    return portService.updatePort(id, portDto);
  }

  @Override
  public ResponseEntity<Void> deletePort(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting port....");
    portService.deletePort(id);
    return ResponseEntity.noContent().build();
  }
}
