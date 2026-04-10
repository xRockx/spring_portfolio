package com.example.webapp.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
	private Integer id;
	private LocalDate rentalDate;
	private LocalDate returnDate;
	private User user;
	private DVD dvd;
}


