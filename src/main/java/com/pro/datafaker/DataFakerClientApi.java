package com.pro.datafaker;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.model.Client;
import com.pro.service.ClientService;

import net.datafaker.Faker;

@RestController
@RequestMapping("/api/df/client")
public class DataFakerClientApi {

	@Autowired
	private ClientService clientService;

	@GetMapping("/top10")
	public ResponseEntity<List<Client>> top10() {
		return ResponseEntity.ok(clientService.findTop10ByOrderByIdAsc());
	}

	@GetMapping({ "", "/" })
	public ResponseEntity<Client> getClients() {
		@SuppressWarnings("deprecation")
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

	@GetMapping("/add-seed")
	public ResponseEntity<List<Client>> addSeed(@RequestParam(defaultValue = "0", value = "quantity") int quantity) {
		return ResponseEntity.ok(clientService.addSeed(quantity));
	}
}