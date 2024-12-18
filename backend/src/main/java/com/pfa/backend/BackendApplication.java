package com.pfa.backend;

import com.security.entities.AppRole;
import com.security.entities.AppUser;
import com.security.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}



@Bean
CommandLineRunner start(AccountService accountService) {
	return args -> {
		accountService.addNewRole(new AppRole(null, "USER"));
		accountService.addNewRole(new AppRole(null, "ADMIN"));
		accountService.addNewRole(new AppRole(null, "CUSTOMER_MANAGER"));
		accountService.addNewRole(new AppRole(null, "PRODUCT_MANAGER"));
		accountService.addNewRole(new AppRole(null, "BILLS_MANAGER"));

		accountService.addNewUser(new AppUser(null, "user1", "1234", new ArrayList<>()));
		accountService.addNewUser(new AppUser(null, "user2", "1234", new ArrayList<>()));
		accountService.addNewUser(new AppUser(null, "user3", "1234", new ArrayList<>()));
		accountService.addNewUser(new AppUser(null, "admin", "1234", new ArrayList<>()));
		accountService.addNewUser(new AppUser(null, "user4", "1234", new ArrayList<>()));

		accountService.addRoleToUser("user1", "USER");
		accountService.addRoleToUser("user2", "USER");
		accountService.addRoleToUser("user3", "USER");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("user1", "CUSTOMER_MANAGER");
		accountService.addRoleToUser("user2", "PRODUCT_MANAGER");
		accountService.addRoleToUser("user3", "BILLS_MANAGER");
		accountService.addRoleToUser("user4", "BILLS_MANAGER");
	};
}
}