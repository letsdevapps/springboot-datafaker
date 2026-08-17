package com.pro.datafaker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/df")
public class DataFakerApi {

	@GetMapping({ "", "/" })
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("----- Data Faker | Data Faker Api | Index -----");
	}
}