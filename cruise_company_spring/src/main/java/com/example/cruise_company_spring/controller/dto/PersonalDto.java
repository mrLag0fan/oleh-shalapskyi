package com.example.cruise_company_spring.controller.dto;

import com.example.cruise_company_spring.service.model.Liner;
import com.example.cruise_company_spring.service.model.PersonalRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalDto {

    private Integer id;
    private String fullName;
    private Integer experience;
    private Liner liner;
    private PersonalRole personalRole;
}
