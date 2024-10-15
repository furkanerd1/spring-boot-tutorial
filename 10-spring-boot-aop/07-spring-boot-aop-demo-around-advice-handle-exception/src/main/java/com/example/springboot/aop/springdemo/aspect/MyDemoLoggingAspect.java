package com.example.springboot.aop.springdemo.aspect;

import com.example.springboot.aop.springdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @Around("execution(* com.example.springboot.aop.springdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theJoinPoint) throws Throwable {
        // print out method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // now, let's execute the method
        Object result = null;

        try {
            result = theJoinPoint.proceed();
        }
        catch (Exception exc) {
            // log the exception
            System.out.println(exc.getMessage());

            // give user a custom message
            result = "Major accident! But no worries, your private AOP helicopter is on the way!";
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n=====> Duration: " + duration / 1000.0 + " seconds");

        return result;

    }



    @After("execution(* com.example.springboot.aop.springdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After on method: " + method);
    }



    @AfterThrowing(
            pointcut = "execution(* com.example.springboot.aop.springdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theException"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theException ) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // print out the results of the method call
        System.out.println("\n=====>>> result is: " + theException);

    }




    @AfterReturning(
            pointcut = "execution(* com.example.springboot.aop.springdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result ) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n=====>>> result is: " + result);


        //we can modify the result before the show on main method
//        if(!result.isEmpty()){
//
//            Account account = result.get(1);
//            account.setName("Daffy Duck");
//
//        }
        convertAccountNamesToUpperCase(result);


    }


    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {

            String accountName = account.getName().toUpperCase();
           account.setName(accountName);

        }
    }



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
