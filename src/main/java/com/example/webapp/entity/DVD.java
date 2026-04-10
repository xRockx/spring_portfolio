package com.example.webapp.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DVD {
	private Integer id;
	private String dvdname;
	private String genre;
	private Integer rental_days;
	private Integer stock;
	private List<Rental> rentals;
}
