package com.aracnideo.sbhibernate.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aracnideo.sbhibernate.entities.Category;
import com.aracnideo.sbhibernate.entities.Order;
import com.aracnideo.sbhibernate.entities.User;
import com.aracnideo.sbhibernate.entities.enums.OrderStatus;
import com.aracnideo.sbhibernate.repositories.CategoryRepository;
import com.aracnideo.sbhibernate.repositories.OrderRepository;
import com.aracnideo.sbhibernate.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		Category c1 = new Category(null, "Wood");
		Category c2 = new Category(null, "Steel");
		Category c3 = new Category(null, "Medicine");
		Category c4 = new Category(null, "Plastic");

		User u1 = new User(null, "Abraao", "abraao@gmail.com", "46999999998", "123");
		User u2 = new User(null, "Braulio", "brauliao@gmail.com", "46999999997", "1234");
		User u3 = new User(null, "Carlos", "carlote@gmail.com", "46999999996", "senha1");

		Order o1 = new Order(null, Instant.parse("2026-02-03T11:00:00Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2026-03-03T09:30:00Z"), OrderStatus.SHIPPED, u1);
		Order o3 = new Order(null, Instant.parse("2026-02-03T10:50:00Z"), OrderStatus.PAID, u2);
		Order o4 = new Order(null, Instant.parse("2026-02-03T14:15:00Z"), OrderStatus.PAID, u3);
		Order o5 = new Order(null, Instant.parse("2026-03-03T19:02:00Z"), OrderStatus.WAITING_PAYMENT, u3);

		categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5));

	}

}
