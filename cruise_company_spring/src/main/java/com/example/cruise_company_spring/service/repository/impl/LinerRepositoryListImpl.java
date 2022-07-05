package com.example.cruise_company_spring.service.repository.impl;

import com.example.cruise_company_spring.service.model.Liner;
import com.example.cruise_company_spring.service.repository.LinerRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LinerRepositoryListImpl implements LinerRepository {

    private final List<Liner> list = new ArrayList<Liner>();

    @Override
    public Liner getLiner(Integer id) {
        return list.stream().
                filter(liner -> liner.getId().equals(id)).
                findFirst()
                .orElseThrow(() -> new RuntimeException("Liner not found")) ;
    }

    @Override
    public List<Liner> getAllLiners() {
        return new ArrayList<>(list);
    }

    @Override
    public boolean deleteLiner(Integer id) {
        return list.removeIf(liner -> liner.getId().equals(id));
    }

    @Override
    public Liner createLiner(Liner liner) {
        list.add(liner);
        return liner;
    }

    @Override
    public Liner updateLiner(Integer id, Liner liner) {
        if (list.removeIf(liner1 -> liner1.getId().equals(id))){
            list.add(liner);
        }else {
            throw new RuntimeException("Liner not found");
        }
        return liner;
    }

}
