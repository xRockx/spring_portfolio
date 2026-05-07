package com.example.webapp.entity;

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
	private Integer rentalDays;
	private Integer userId;
	
}
