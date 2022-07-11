package com.example.cruise_company.service.repository;

import com.example.cruise_company.service.model.Port;
import java.util.List;

public interface PortRepository {

  Port getPort(Integer id);

  List<Port> getAllPorts();

  boolean deletePort(Integer id);

  Port createPort(Port port);

  Port updatePort(Integer id, Port port);
}
