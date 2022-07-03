package com.example.cruise_company_spring.service.repository;

import com.example.cruise_company_spring.controller.dto.PortDto;
import com.example.cruise_company_spring.service.model.Port;
import com.example.cruise_company_spring.service.model.User;

import java.util.List;

public interface PortRepository {

    Port getPort(Integer id);
    List<Port> getAllPorts();
    boolean deletePort(Integer id);
    Port createPort(Port port);
    Port updatePort(Integer id, Port port);

}
