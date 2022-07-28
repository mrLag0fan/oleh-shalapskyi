package com.example.cruise_company.service.repository.impl;

import com.example.cruise_company.exception.entity_not_found.PortNotFoundException;
import com.example.cruise_company.service.model.Port;
import com.example.cruise_company.service.repository.PortRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PortRepositoryListImpl implements PortRepository {

  private final List<Port> list = new ArrayList<Port>();

  @Override
  public Port getPort(Integer id) {
    return list.stream()
        .filter(port -> port.getId().equals(id))
        .findFirst()
        .orElseThrow(PortNotFoundException::new);
  }

  @Override
  public List<Port> getAllPorts() {
    return new ArrayList<>(list);
  }

  @Override
  public boolean deletePort(Integer id) {
    return list.removeIf(port -> port.getId().equals(id));
  }

  @Override
  public Port createPort(Port port) {
    list.add(port);
    return port;
  }

  @Override
  public Port updatePort(Integer id, Port port) {
    if (list.removeIf(port1 -> port1.getId().equals(id))) {
      list.add(port);
    } else {
      throw new PortNotFoundException();
    }
    return port;
  }
}
