package com.example.springboot.aop.springdemo.dao;

import com.example.springboot.aop.springdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass() + "doing my db works....");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + "doWork()....");
        return false;
    }

    @Override
    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

}
