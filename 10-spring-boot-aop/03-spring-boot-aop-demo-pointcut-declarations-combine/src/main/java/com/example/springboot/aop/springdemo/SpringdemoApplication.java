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
			demoTheBeforeTheAdvice(accountDAO, membershipDAO);

		};
	}

	public void demoTheBeforeTheAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {


		// call the business method
		Account myAccount = new Account();
		accountDAO.addAccount(myAccount, true);
		accountDAO.doWork();

		// call the accountdao getter/setter methods
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		// call the membership business method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();


	}

}
