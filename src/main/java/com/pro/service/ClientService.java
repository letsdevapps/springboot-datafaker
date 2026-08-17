package com.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.model.Client;
import com.pro.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repo;

	public List<Client> findTop10ByOrderByIdAsc() {
		return repo.findTop10ByOrderByIdAsc();
	}
}