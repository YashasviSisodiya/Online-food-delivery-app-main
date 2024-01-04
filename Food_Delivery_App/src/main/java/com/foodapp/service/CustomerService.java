package com.foodapp.service;

import com.foodapp.exceptions.CustomerException;
import com.foodapp.model.Customer;

import java.util.UUID;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer)throws CustomerException;


	Customer login(String userName, String password) throws CustomerException;

	Customer logout(UUID uuid) throws CustomerException;

	public Customer updateCustomer(Customer customer)throws CustomerException;
	
	public Customer removeCustomerById(Integer customerId)throws CustomerException;
	
	public Customer viewCustomer(Integer customerId)throws CustomerException;

}
