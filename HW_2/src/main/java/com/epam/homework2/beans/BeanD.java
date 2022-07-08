package com.epam.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class BeanD implements Bean {

    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private Integer value;

    @Override
    public String toString() {
        return "BeanD{" + "name='" + name + '\'' + ", value=" + value + '}';
    }

    public BeanD() {
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    public void beanDInitMethod() {
        System.out.println(this.getClass().getSimpleName() + " init method");
    }

    private void beanDDestroyMethod() {
        System.out.println(this.getClass().getSimpleName() + " destroy method");
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }
}
