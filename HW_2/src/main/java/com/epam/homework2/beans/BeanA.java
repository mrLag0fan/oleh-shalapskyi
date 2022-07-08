package com.epam.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA implements InitializingBean, DisposableBean, Bean {

    private String name;
    private Integer value;

    @Override
    public String toString() {
        return "BeanA{" + "name='" + name + '\'' + ", value=" + value + '}';
    }

    public BeanA() {
        System.out.println(this.getClass().getSimpleName()
                + " created");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName()
                + " InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName()
                + " DisposableBean.destroy()");
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }
}
