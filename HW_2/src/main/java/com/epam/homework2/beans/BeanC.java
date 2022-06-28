package com.epam.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanC implements Bean{
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private Integer value;

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }

    public BeanC() {
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    public void beanCInitMethod(){
        System.out.println(this.getClass().getSimpleName() + " init method");
    }

    private void beanCDestroyMethod() {
        System.out.println(this.getClass().getSimpleName() + " destroy method");
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }
}
