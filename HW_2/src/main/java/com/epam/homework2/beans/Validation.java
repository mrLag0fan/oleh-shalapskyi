package com.epam.homework2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class Validation implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
        throws BeansException {
        if (bean instanceof Bean bean1) {
            if (bean1.getName() == null) {
                System.out.println("name must not be null");
            }
            if (bean1.getValue() == null) {
                System.out.println("value must not be NULL");
            } else if (bean1.getValue() < 0) {
                System.out.println("value must be bigger than 0");
            }
        }
        return bean;
    }
}
