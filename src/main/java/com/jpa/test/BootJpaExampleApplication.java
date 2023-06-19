package com.jpa.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepo;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(BootJpaExampleApplication.class, args);
		UserRepo userRepo = context.getBean(UserRepo.class);
		
		
//		User  user = new User();
//		
//		user.setName("s");
//		user.setCity("yavatmal");
//		
		/*
		 * User user1 = new User(); user1.setName("golem"); user1.setCity("yavatmal");
		 * 
		 * User user2 = new User(); user2.setName("giant"); user2.setCity("yavatmal");
		 * 
		 * List<User> users = new ArrayList<>(); users.add(user); users.add(user1);
		 * users.add(user2);
		 */
		
		//userRepo.save(user);
		
		
		
		//update
		
//		Optional<User> optional = userRepo.findById(1);
//		
//		User user = optional.get();
//		
//		user.setName("diksha landole");
//		user.setCity("yavatmal");
//		userRepo.save(user);
//		
		
		Iterable<User> itr = userRepo.findAll();
		Iterator<User> iterator = itr.iterator();
		
		for(User u : itr) {
			System.out.println(u);
		}
		
		while(iterator.hasNext()) {
			User u = iterator.next();
			System.out.println(u);
		}
		
		itr.forEach(new Consumer<User>() {

			@Override
			public void accept(User t) {
				System.out.println(t);
				
			}
		});
		
		itr.forEach(user -> 
		{
			System.out.println(user);
		
		});
		
		
		userRepo.deleteById(1);
		
		
	}
	

}
