package com.epam.homework2.context;

import com.epam.homework2.beans.BeanB;
import com.epam.homework2.beans.BeanF;
import com.epam.homework2.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;


public class Context {

    public static void main(String[] args) throws Throwable {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        for (String name: context.getBeanDefinitionNames()){
            System.out.println(context.getBean(name));
        }
        context.close();
    }
}
