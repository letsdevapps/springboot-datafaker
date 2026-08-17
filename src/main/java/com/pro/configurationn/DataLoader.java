package com.pro.configurationn;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pro.model.Client;
import com.pro.repository.ClientRepository;

import net.datafaker.Faker;

@Configuration
public class DataLoader {

	// @Bean
	CommandLineRunner loadClients(ClientRepository repository) {
		return args -> {
			for (int i = 0; i < 1; i++) {
				@SuppressWarnings("deprecation")
				Faker faker = new Faker(new Locale("pt-BR"));

				Client client = new Client();

				client.setFullName(faker.name().fullName());
				client.setEmailAddress(faker.internet().emailAddress(client.getFullName()));
				client.setCellPhone(faker.phoneNumber().cellPhone());
				client.setCreatedAt(LocalDate.now());
				client.setAvailable(true);

				repository.save(client);
			}
		};
	}
}