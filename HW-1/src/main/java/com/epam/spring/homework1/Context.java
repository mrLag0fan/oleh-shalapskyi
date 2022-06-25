package com.epam.spring.homework1;

import com.epam.spring.homework1.config.BeansConfig;
import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Context {

    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(BeansConfig.class);
        context.getBean(Pet.class).printPet();

        System.out.println("Primary " +  context.getBean(Cheetah.class));
        System.out.println(context.getBean("cheetah1"));
        System.out.println(context.getBean("cheetah"));

    }
}
