package br.com.thedomeit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.thedomeit.util.BuilderData;

@SpringBootApplication
public class ExpensesApplication implements CommandLineRunner{

	@Autowired
	BuilderData builderClient;
	
	public static void main(String[] args) {
		SpringApplication.run(ExpensesApplication.class, args);
	}

	public void run(String... args) throws Exception {
		builderClient.builderAll();
	}
}
