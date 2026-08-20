package com.pro.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.model.Client;
import com.pro.repository.ClientRepository;

import net.datafaker.Faker;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findTop10ByOrderByIdAsc() {
		return clientRepository.findTop10ByOrderByIdAsc();
	}

	public List<Client> addSeed(int quantity) {
		List<Client> seedClientList = new ArrayList<Client>();

		for (int i = 0; i < quantity; i++) {
			@SuppressWarnings("deprecation")
			Faker faker = new Faker(new Locale("pt-BR"));

			Client client = new Client();

			client.setFullName(faker.name().fullName());
			client.setEmailAddress(faker.internet().emailAddress(client.getFullName()));
			client.setCellPhone(faker.phoneNumber().cellPhone());
			client.setCreatedAt(LocalDate.now());
			client.setAvailable(true);

			clientRepository.save(client);
			seedClientList.add(client);
		}

		return seedClientList;
	}
}