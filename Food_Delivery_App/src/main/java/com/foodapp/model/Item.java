package com.foodapp.model;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Item{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemId;
	private String itemName;
	private Double cost;
	private String image;



	
//	@Embedded
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;

	

}