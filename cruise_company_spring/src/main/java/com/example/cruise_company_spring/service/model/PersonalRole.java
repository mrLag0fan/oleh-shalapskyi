package com.example.cruise_company_spring.service.model;

import io.swagger.models.auth.In;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalRole {

    private Integer id;
    private String name;

}
