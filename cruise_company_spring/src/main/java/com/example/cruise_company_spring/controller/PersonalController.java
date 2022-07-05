package com.example.cruise_company_spring.controller;

import com.example.cruise_company_spring.controller.dto.PersonalDto;
import com.example.cruise_company_spring.service.PersonalService;
import com.example.cruise_company_spring.service.model.Personal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class PersonalController {

    private final PersonalService personalService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/personal")
    public List<PersonalDto> getAllPersonals(){
        log.info(this.getClass().getSimpleName() +" getting all personal....");
        return personalService.getAllPersonals();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/personal/{id}")
    public PersonalDto getPersonal(@PathVariable Integer id){
        log.info(this.getClass().getSimpleName() +" getting personal by id....");
        return personalService.getPersonal(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/personal")
    public PersonalDto createPersonal(@RequestBody Personal personal){
        log.info(this.getClass().getSimpleName() +" creating personal....");
        return personalService.createPersonal(personal);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/personal/{id}")
    public PersonalDto updatePersonal(@PathVariable Integer id, @RequestBody PersonalDto personalDto){
        log.info(this.getClass().getSimpleName() +" updating personal....");
        return personalService.updatePersonal(id, personalDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/personal/{id}")
    public ResponseEntity<Void> deletePersonal(@PathVariable Integer id){
        log.info(this.getClass().getSimpleName() +" deleting personal....");
        personalService.deletePersonal(id);
        return ResponseEntity.noContent().build();
    }

}
