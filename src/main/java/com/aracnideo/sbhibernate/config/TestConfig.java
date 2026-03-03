package com.aracnideo.sbhibernate.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.aracnideo.sbhibernate.entities.Category;
import com.aracnideo.sbhibernate.entities.Order;
import com.aracnideo.sbhibernate.entities.Product;
import com.aracnideo.sbhibernate.entities.User;
import com.aracnideo.sbhibernate.entities.enums.OrderStatus;
import com.aracnideo.sbhibernate.repositories.CategoryRepository;
import com.aracnideo.sbhibernate.repositories.OrderRepository;
import com.aracnideo.sbhibernate.repositories.ProductRepository;
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

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		Category c1 = new Category(null, "Wood");
		Category c2 = new Category(null, "Steel");
		Category c3 = new Category(null, "Medicine");
		Category c4 = new Category(null, "Plastic");

		Product p1 = new Product(null, "Oak Wood Plank",
				"High-quality oak plank ideal for furniture and structural projects.", 49.90, "");

		Product p2 = new Product(null, "Pine Beam", "Treated pine beam suitable for roofing and outdoor constructions.",
				89.50, "");

		Product p3 = new Product(null, "Steel Hammer", "Heavy-duty steel hammer with ergonomic rubber grip.", 79.99,
				"");

		Product p4 = new Product(null, "Aluminum Sheet", "Lightweight aluminum sheet resistant to corrosion.", 120.00,
				"");

		Product p5 = new Product(null, "First Aid Kit", "Complete medical kit for emergencies and basic care.", 149.90,
				"");

		Product p6 = new Product(null, "Digital Thermometer", "Fast and accurate digital thermometer for medical use.",
				39.90, "");

		Product p7 = new Product(null, "PVC Pipe 1m", "Durable PVC pipe suitable for water systems.", 25.75, "");

		Product p8 = new Product(null, "Plastic Storage Box", "Transparent plastic box with secure locking lid.", 34.60,
				"");

		Product p9 = new Product(null, "Copper Wire Roll",
				"High-conductivity copper wire roll for electrical installations.", 199.99, "");

		Product p10 = new Product(null, "Surgical Gloves Pack", "Disposable latex surgical gloves pack with 100 units.",
				59.90, "");

		categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

		p1.getCategories().add(c1);
		p2.getCategories().add(c1);
		p3.getCategories().add(c2);
		p3.getCategories().add(c1);
		p4.getCategories().add(c2);
		p5.getCategories().add(c3);
		p5.getCategories().add(c4);
		p6.getCategories().add(c3);
		p6.getCategories().add(c4);
		p7.getCategories().add(c4);
		p7.getCategories().add(c2);
		p8.getCategories().add(c4);
		p9.getCategories().add(c2);
		p10.getCategories().add(c3);
		p10.getCategories().add(c4);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));

		User u1 = new User(null, "Abraao", "abraao@gmail.com", "46999999998", "123");
		User u2 = new User(null, "Braulio", "brauliao@gmail.com", "46999999997", "1234");
		User u3 = new User(null, "Carlos", "carlote@gmail.com", "46999999996", "senha1");

		Order o1 = new Order(null, Instant.parse("2026-02-03T11:00:00Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2026-03-03T09:30:00Z"), OrderStatus.SHIPPED, u1);
		Order o3 = new Order(null, Instant.parse("2026-02-03T10:50:00Z"), OrderStatus.PAID, u2);
		Order o4 = new Order(null, Instant.parse("2026-02-03T14:15:00Z"), OrderStatus.PAID, u3);
		Order o5 = new Order(null, Instant.parse("2026-03-03T19:02:00Z"), OrderStatus.WAITING_PAYMENT, u3);

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5));

	}

}
