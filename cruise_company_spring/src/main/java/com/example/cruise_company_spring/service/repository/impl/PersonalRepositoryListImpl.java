package com.example.cruise_company_spring.service.repository.impl;

import com.example.cruise_company_spring.service.model.Personal;
import com.example.cruise_company_spring.service.repository.PersonalRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PersonalRepositoryListImpl implements PersonalRepository {

    private final List<Personal> list = new ArrayList<Personal>();

    @Override
    public Personal getPersonal(Integer id) {
        return list.stream()
            .filter(personal -> personal.getId().equals(id)).
            findFirst()
            .orElseThrow(() -> new RuntimeException("Personal not found"));
    }

    @Override
    public List<Personal> getAllPersonals() {
        return new ArrayList<>(list);
    }

    @Override
    public boolean deletePersonal(Integer id) {
        return list.removeIf(personal -> personal.getId().equals(id));
    }

    @Override
    public Personal createPersonal(Personal personal) {
        list.add(personal);
        return personal;
    }

    @Override
    public Personal updatePersonal(Integer id, Personal personal) {
        if (list.removeIf(personal1 -> personal1.getId().equals(id))) {
            list.add(personal);
        } else {
            throw new RuntimeException("Personal not found");
        }
        return personal;
    }
}
