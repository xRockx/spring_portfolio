package com.example.webapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DVDs {
	private Integer id;
	private String dvdname;
	private String genre;
	private Integer rental_days;
	private Integer stock;
}
