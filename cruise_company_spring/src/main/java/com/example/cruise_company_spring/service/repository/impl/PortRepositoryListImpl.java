package com.example.cruise_company_spring.service.repository.impl;

import com.example.cruise_company_spring.service.model.Port;
import com.example.cruise_company_spring.service.model.User;
import com.example.cruise_company_spring.service.repository.PortRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PortRepositoryListImpl implements PortRepository {

    private final List<Port> list = new ArrayList<Port>();

    @Override
    public Port getPort(Integer id) {
        return list.stream()
                .filter(port -> port.getId().equals(id)).
                findFirst()
                .orElseThrow(() -> new RuntimeException("Port not found")) ;
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
        if (list.removeIf(port1 -> port1.getId().equals(id))){
            list.add(port);
        }else {
            throw new RuntimeException("Port not found");
        }
        return port;
    }
}
