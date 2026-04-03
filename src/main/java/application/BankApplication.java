package application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import application.layer.service.contract.UserService;
import application.layer.service.contract.facade.BankFacade;

@SpringBootApplication
@EnableTransactionManagement
public class BankApplication implements CommandLineRunner {

	@SuppressWarnings("unused")
	private BankFacade bankFacade;
	@SuppressWarnings("unused")
	private UserService userService;
	
	@Autowired
	public BankApplication(BankFacade bankFacade, UserService userService) {
		this.bankFacade = bankFacade;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		PasswordEncoder pe = new BCryptPasswordEncoder();
//		userService.addUser(new User("manager", pe.encode("manager"), AuthRole.ADMIN.getRole()));
//		userService.addUser(new User("clerk", pe.encode("clerk"), AuthRole.USER.getRole()));
	}

}
