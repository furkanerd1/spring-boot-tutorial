package com.example.springboot.cruddemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.example.springboot.cruddemo.controller.*.*(..))")
    public void forControllerPackage() {}

    @Pointcut("execution(* com.example.springboot.cruddemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.example.springboot.cruddemo.service.*.*(..))")
    public void forServicePackage() {}

    @Pointcut(" forControllerPackage() || forDaoPackage() ||forServicePackage()")
    public void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        //display method which we are calling
        String method=joinPoint.getSignature().toShortString();
        myLogger.info(" ====> in @Before calling method "+method);

        //display the arguments to the method

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            myLogger.info(" ====> in @Before arg "+arg);
        }

    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result)
    {
        String method=joinPoint.getSignature().toShortString();
        myLogger.info(" ====> in @AfterReturning calling method "+method);

        //show result
        myLogger.info(" ====> in @AfterReturning result "+result);
    }


}
