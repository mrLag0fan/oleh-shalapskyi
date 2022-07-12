package com.epam.homework2.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class BeanF {

  private String name;
  private Integer value;

  public BeanF() {
    System.out.println(this.getClass().getSimpleName() + " created");
  }

  @Override
  public String toString() {
    return "BeanF{" + "name='" + name + '\'' + ", value=" + value + '}';
  }

  public String getName() {
    return name;
  }

  public Integer getValue() {
    return value;
  }
}
