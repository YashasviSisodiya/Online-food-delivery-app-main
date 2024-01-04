package com.foodapp.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String fullName;
	private Integer age;
	private String gender;
	private String mobileNumber;
	private String email;

	@Column(unique=true)
	private String userName;
	private String password;

	private UUID uuid;
	
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	private Address address;
}

