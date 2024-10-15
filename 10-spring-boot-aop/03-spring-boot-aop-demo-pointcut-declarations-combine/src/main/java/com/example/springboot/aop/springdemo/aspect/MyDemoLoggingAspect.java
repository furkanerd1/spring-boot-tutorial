package com.example.springboot.aop.springdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //let's do combine

    @Pointcut("execution(* com.example.springboot.aop.springdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.example.springboot.aop.springdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.example.springboot.aop.springdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n ->>  Executing Before advice on  addAccount method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n ->> performing api analytics  ");
    }
}
