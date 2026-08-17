package com.pro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	// SELECT * FROM clients ORDER BY id ASC LIMIT 10; 
	List<Client> findTop10ByOrderByIdAsc();
}