package com.example.springboot.aop.springdemo;

import com.example.springboot.aop.springdemo.dao.AccountDAO;
import com.example.springboot.aop.springdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
           demoTheBeforeTheAdvice(accountDAO,membershipDAO);

		};
	}

	public void demoTheBeforeTheAdvice(AccountDAO accountDAO,MembershipDAO membershipDAO) {
		Account account = new Account();
		accountDAO.addAccount(account,true);
		System.out.println("----");
		membershipDAO.addSillyMember();
		System.out.println("----");
		accountDAO.doWork();
		System.out.println("----");
		membershipDAO.goToSleep();
		//System.out.println("Lets call again ");

		//accountDAO.addAccount();
	}


}
