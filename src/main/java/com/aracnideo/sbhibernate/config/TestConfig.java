package com.aracnideo.sbhibernate.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aracnideo.sbhibernate.entities.User;
import com.aracnideo.sbhibernate.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Abraao", "abraao@gmail.com", "46999999998", "123");
		User u2 = new User(null, "Braulio", "brauliao@gmail.com", "46999999997", "1234");
		User u3 = new User(null, "Carlos", "carlote@gmail.com", "46999999996", "senha1");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}

}
