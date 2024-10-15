package com.example.springboot.aop.springdemo;

import com.example.springboot.aop.springdemo.dao.AccountDAO;
import com.example.springboot.aop.springdemo.dao.MembershipDAO;
import com.example.springboot.aop.springdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO,TrafficFortuneService trafficFortuneService) {
		return runner -> {
			//demoTheBeforeTheAdvice(accountDAO, membershipDAO);
            // demoTheAfterReturningAdvice(accountDAO);
			//demoTheAfterThrowingAdvice(accountDAO);
			//demoTheAfterAdvice(accountDAO);
			demoTheAroundAdvice(trafficFortuneService);

		};
	}


	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		// call method to find the accounts
		try{
			boolean tripWire=true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception e){
			System.out.println("\n\nMain Program: caught exception...." + e.getMessage());
		}


		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}
	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = null;
		// call method to find the accounts
		try{
			boolean tripWire=false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch (Exception e){
			System.out.println("\n\nMain Program: caught exception...." + e.getMessage());
		}


		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}
	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");

		System.out.println(theAccounts);

		System.out.println("\n");
	}
	private void demoTheBeforeTheAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {


		// call the business method
		Account myAccount = new Account("furkan","diamond");
		accountDAO.addAccount(myAccount, true);
		accountDAO.doWork();

		// call the account dao getter/setter methods
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		// call the membership business method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();


	}

}
