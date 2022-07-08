package com.epam.homework2.config;

import com.epam.homework2.beans.BeanB;
import com.epam.homework2.beans.BeanC;
import com.epam.homework2.beans.BeanD;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan("com.epam.homework2.beans")
@PropertySource("classpath:application.properties")
public class Config {

    @Bean(initMethod = "beanDInitMethod", destroyMethod = "beanDDestroyMethod")
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean(initMethod = "beanBInitMethod", destroyMethod = "beanBDestroyMethod")
    @DependsOn("beanD")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "beanCInitMethod", destroyMethod = "beanCDestroyMethod")
    @DependsOn("beanB")
    public BeanC beanC() {
        return new BeanC();
    }
}
