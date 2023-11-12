package prg.sid.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import prg.sid.inventoryservice.entities.Product;
import prg.sid.inventoryservice.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Product.class);
			productRepository.saveAll(
					List.of(
							Product.builder()
									.name("computer")
									.quantity(12)
									.price(1200)
									.build(),
							Product.builder()
									.name("printer")
									.quantity(32)
									.price(120)
									.build(),
							Product.builder()
									.name("smartphone")
									.quantity(31)
									.price(900)
									.build()
					)
			);
		};
	}

}
