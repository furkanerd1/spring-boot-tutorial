package com.example.springboot.aop.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


    // this is where we add all of our related advices for logging

    // let's start with a @Before advice

    // let's do reusable execution
    //For dao package
    @Pointcut("execution(* com.example.springboot.aop.springdemo.dao.*.*(..))")
    public void forDaoPackage() {}


    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ->>  Executing Before advice on  addAccount method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n ->> performing api analytics  ");
    }
}
