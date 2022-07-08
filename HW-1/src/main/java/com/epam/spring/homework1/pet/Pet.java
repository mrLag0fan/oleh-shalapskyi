package com.epam.spring.homework1.pet;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Pet {

    private List<Animal> list;

    public Pet(List<Animal> list) {
        this.list = list;
    }

    public void printPet() {
        list.forEach(animal ->
            System.out.println(animal.getClass().getSimpleName()));
    }
}
