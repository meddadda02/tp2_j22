package org.example.TP2_JEE;





import org.example.TP2_JEE.entities.Product;
import org.example.TP2_JEE.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp2JeeApplicationTests implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(Tp2JeeApplicationTests.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null,"Computer",4500,3));
		productRepository.save(new Product(null,"Printer",1200,4));
		productRepository.save(new Product(null,"Phone",3300,32));
		List<Product> products = productRepository.findAll();
		products.forEach(p -> {
			System.out.println(p.toString());
		});
		List<Product> productList = productRepository.findByNameContains("C");

	}
}