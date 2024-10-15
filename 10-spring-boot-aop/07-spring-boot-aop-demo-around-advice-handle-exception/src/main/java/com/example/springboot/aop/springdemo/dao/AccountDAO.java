package com.example.springboot.aop.springdemo.dao;

import com.example.springboot.aop.springdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();

    String getName();

    void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);


}

