package com.example.cruise_company_spring.service.impl;

import com.example.cruise_company_spring.controller.dto.LinerDto;
import com.example.cruise_company_spring.service.LinerService;
import com.example.cruise_company_spring.service.model.Liner;
import com.example.cruise_company_spring.service.repository.LinerRepository;
import com.example.cruise_company_spring.service.repository.PortRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LinerServiceImpl implements LinerService {

    private final LinerRepository linerRepository;
    private final PortRepository portRepository;

    @Override
    public LinerDto getLiner(Integer id) {
        log.info("get Liner by id {}", id);
        Liner liner = linerRepository.getLiner(id);
        return mapLinerToLinerDto(liner);
    }

    @Override
    public List<LinerDto> getAllLiners() {
        log.info("get all liners");
        return linerRepository.getAllLiners()
            .stream()
            .map(this::mapLinerToLinerDto)
            .collect(Collectors.toList());
    }

    @Override
    public boolean deleteLiner(Integer id) {
        log.info("liner delete by id {}", id);
        return linerRepository.deleteLiner(id);
    }

    @Override
    public LinerDto createLiner(Liner liner) {
        log.info("create liner with id {}", liner.getId());
        linerRepository.createLiner(liner);
        return mapLinerToLinerDto(liner);
    }


    @Override
    public LinerDto updateLiner(Integer id, LinerDto linerDto) {
        log.info("update liner with id {}", id);
        Liner liner = mapLinerDtoToLiner(linerDto);
        liner = linerRepository.updateLiner(id, liner);
        return mapLinerToLinerDto(liner);
    }

    private LinerDto mapLinerToLinerDto(Liner liner) {
        return LinerDto.builder()
            .id(liner.getId())
            .startDate(liner.getStartDate())
            .endDate(liner.getEndDate())
            .passengerCapacity(liner.getPassengerCapacity())
            .price(liner.getPrice())
            .startPort(portRepository.getPort(liner.getStartPortId()))
            .endPort(portRepository.getPort(liner.getEndPortId()))
            .routes(liner.getRoutes())
            .build();
    }

    private Liner mapLinerDtoToLiner(LinerDto linerDto) {
        return Liner.builder()
            .id(linerDto.getId())
            .startDate(linerDto.getStartDate())
            .endDate(linerDto.getEndDate())
            .passengerCapacity(linerDto.getPassengerCapacity())
            .price(linerDto.getPrice())
            .startPortId(linerDto.getStartPort().getId())
            .endPortId(linerDto.getEndPort().getId())
            .routes(linerDto.getRoutes())
            .build();
    }

}
