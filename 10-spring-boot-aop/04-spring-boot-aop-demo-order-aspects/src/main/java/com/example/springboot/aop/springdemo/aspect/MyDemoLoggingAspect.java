package com.example.springboot.aop.springdemo.aspect;

import com.example.springboot.aop.springdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    //We separate the aspects for the order
    //We are using joinpoint to get metadata of method which we use.


    @Before("com.example.springboot.aop.springdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");


        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method : " + methodSignature);

        //get args

        Object[] args = joinPoint.getArgs();

        // loop the args
        for (Object tempArgs : args) {
            System.out.println(tempArgs);

            if (tempArgs instanceof Account) {
                Account theAccount = (Account) tempArgs;
                System.out.println("---");
                System.out.println(theAccount.getName());
                System.out.println(theAccount.getLevel());

            }
        }


    }
}
