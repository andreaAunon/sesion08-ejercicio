package es.babel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "es.babel.demo")
public class Sesion08EjercicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sesion08EjercicioApplication.class, args);
	}

}
