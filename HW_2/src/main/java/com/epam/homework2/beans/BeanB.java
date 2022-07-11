package com.epam.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanB implements Bean {

    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private Integer value;

    @Override
    public String toString() {
        return "BeanB{" + "name='" + name + '\'' + ", value=" + value + '}';
    }

    public BeanB() {
        System.out.println(this.getClass().getSimpleName() + " created");
    }

    public void beanBInitMethod() {
        System.out.println(this.getClass().getSimpleName() + " init method");
    }

    public void otherBInitMethod() {
        System.out.println(this.getClass().getSimpleName()
            + " other init method");
    }

    private void beanBDestroyMethod() {
        System.out.println(this.getClass().getSimpleName() + " destroy method");
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }
}
