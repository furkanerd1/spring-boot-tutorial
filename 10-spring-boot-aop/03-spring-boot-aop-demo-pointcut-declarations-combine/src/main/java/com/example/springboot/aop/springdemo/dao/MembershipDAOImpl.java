package com.example.springboot.aop.springdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + " doing my db works....");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " going to sleep");
    }
}
