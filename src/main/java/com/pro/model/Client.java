package com.pro.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {

	private Integer id;
	private String fullName;
	private String emailAddress;
	private String cellPhone;
	private LocalDate createdAt;
	private LocalDate updatedAt;
	private Boolean available;
}