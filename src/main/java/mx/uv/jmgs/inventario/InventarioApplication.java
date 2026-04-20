package mx.uv.jmgs.inventario;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import mx.uv.jmgs.inventario.entity.Producto;
import mx.uv.jmgs.inventario.repository.ProductRepository;

@SpringBootApplication
public class InventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventarioApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ProductRepository repository) {
		return args -> {
			repository.save(new Producto(null, "Laptop", "Laptop de alta gama", 1500.00, 10, "Electrónica", LocalDateTime.now()));
			repository.save(new Producto(null, "Smartphone", "Smartphone con buena cámara", 800.00, 20, "Electrónica", LocalDateTime.now()));
			repository.save(new Producto(null, "Cámara", "Cámara profesional para fotografía", 1200.00, 5, "Fotografía", LocalDateTime.now()));
		};
	}
}
