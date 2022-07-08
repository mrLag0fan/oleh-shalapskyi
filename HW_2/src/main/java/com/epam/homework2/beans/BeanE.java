package com.epam.homework2.beans;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE implements Bean {

    private String name;
    private Integer value;

    @Override
    public String toString() {
        return "BeanE{" + "name='" + name + '\'' + ", value=" + value + '}';
    }

    public BeanE() {
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println(this.getClass().getSimpleName() + " @PostConstruct");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println(this.getClass().getSimpleName() + " @PreDestroy");
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }
}
