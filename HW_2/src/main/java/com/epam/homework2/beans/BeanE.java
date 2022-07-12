package com.epam.homework2.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class BeanE implements Bean {

  private String name;
  private Integer value;

  public BeanE() {
    System.out.println(this.getClass().getSimpleName() + " created");
  }

  @Override
  public String toString() {
    return "BeanE{" + "name='" + name + '\'' + ", value=" + value + '}';
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
