package com.example.Exam.Portal.Application;

import com.example.Exam.Portal.Application.entities.Role;
import com.example.Exam.Portal.Application.entities.User;
import com.example.Exam.Portal.Application.entities.UserRole;
import com.example.Exam.Portal.Application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamPortalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
//		User user=new User();
//		user.setFirstname("Sajib");
//		user.setLastname("Khan");
//		user.setUsername("zaman990");
//		user.setPassword("123456");
//		user.setEmail("abc@gmail.com");
//		user.setProfile("default.png");
//		user.setPhone("123456789");
//
//		Role role1=new Role();
//		role1.setRoleId(1001L);
//		role1.setRoleName("Admin");
//
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//
//		User user1=this.userService.createUser(user,userRoleSet);
//		System.out.println(user1.getUsername());
	}
}
