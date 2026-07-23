package com.pro.datafaker;

import java.util.Locale;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.model.Client;

import net.datafaker.Faker;

@RestController
@RequestMapping("/api/df")
public class DataFakerApi {

	@GetMapping({ "", "/" })
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("----- Data Faker | Data Faker Api | Index -----");
	}

	@GetMapping("/clients")
	public ResponseEntity<Client> getClients() {
		Faker faker = new Faker(new Locale("pt-BR"));

//		System.out.println(faker.name().fullName());
//		System.out.println(faker.internet().emailAddress());
//		System.out.println(faker.phoneNumber().cellPhone());

		Client client = new Client();

		client.setFullName(faker.name().fullName());
		client.setEmailAddress(faker.internet().emailAddress(client.getFullName()));
		client.setCellPhone(faker.phoneNumber().cellPhone());

		return ResponseEntity.ok(client);
	}
}