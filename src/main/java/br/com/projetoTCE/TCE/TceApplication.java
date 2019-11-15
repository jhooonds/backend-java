package br.com.projetoTCE.TCE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TceApplication.class, args);
	}

}
