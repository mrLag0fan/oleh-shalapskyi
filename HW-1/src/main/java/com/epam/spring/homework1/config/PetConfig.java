package com.epam.spring.homework1.config;

import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Spider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(
        basePackages = "com.epam.spring.homework1.pet",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Spider.class))

public class PetConfig {

    @Bean
    @Primary
    public Cheetah cheetah(){
        Cheetah res = new Cheetah();
        System.out.println(res + " primary");
        return res;
    }

    @Bean
    @Qualifier
    public Cheetah cheetah1(){
        Cheetah res = new Cheetah();
        System.out.println(res + " qualifier");
        return res;
    }
}
