/*
 * 
 * Copyright 2015 - Talentica Software (India) Private Limited. All Rights Reserved. 
 * This software is the proprietary information of Talentica Software (India) Private Limited. 
 * Use is subject to license terms. *
 *  
 * Created on Nov 4, 2016
 *
 */
package com.doengine.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * @author SumeetS
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.doengine"})
@EnableAspectJAutoProxy
@SpringBootApplication
public class DoEngineApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(DoEngineApplication.class, args);
    } 
}
