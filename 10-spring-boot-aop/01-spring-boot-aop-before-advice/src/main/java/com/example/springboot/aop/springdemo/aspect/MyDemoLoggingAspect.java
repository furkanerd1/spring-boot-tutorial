package com.example.springboot.aop.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


    // this is where we add all of our related advices for logging

    // let's start with a @Before advice

    //@Before("execution(public void com.example.springboot.aop.springdemo.dao.AccountDAO.addAccount())") -> will match on only method(addAccount()) on AccountDAO
    //@Before("execution(public void addAccount())") --> will match  on every addAccount method in any class
    //@Before("execution(public void add*())") will match on every method which is starting with add....
    //return type is optional
    //@Before("execution(* add*())") will match  on every method which does not matter which return type  and start with add...
    //@Before("execution(public void addAccount(com.example.springboot.aop.springdemo.Account))") this will match on public void addAccount() methods but which have Account params
    //@Before("execution(public void addAccount(com.example.springboot.aop.springdemo.Account,..))") for additional --- for second parameter --> it can be any parameter(int,boolean,string...)
    //@Before("execution(* com.example..add*(..))") without package path it will throw exc on ultimate version of Intellij
    //@Before("execution(* com.example.springboot.aop.springdemo.dao.*.*(..))") it will match on package and --> in dao --> any class ->> any method --> any parameter
    @Before("execution(* com.example.springboot.aop.springdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ->>  Executing Before advice on  addAccount method");
    }
}
