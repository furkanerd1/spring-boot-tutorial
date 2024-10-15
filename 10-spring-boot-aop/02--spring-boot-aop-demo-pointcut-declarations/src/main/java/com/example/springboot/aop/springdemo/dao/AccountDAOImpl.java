package com.example.springboot.aop.springdemo.dao;

import com.example.springboot.aop.springdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass() + "doing my db works....");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + "doWork()....");
        return false;
    }
}
