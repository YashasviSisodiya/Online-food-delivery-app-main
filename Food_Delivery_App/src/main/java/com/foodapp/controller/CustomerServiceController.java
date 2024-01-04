package com.foodapp.controller;

import com.foodapp.authmodels.LogInModel;
import com.foodapp.exceptions.CartException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.Cart;
import com.foodapp.model.custom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodapp.exceptions.CustomerException;
import com.foodapp.model.Customer;
import com.foodapp.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerServiceController {
	
	@Autowired
	CustomerService customerService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer( @RequestBody Customer customer) throws CustomerException{
		 Customer newCustomer = customerService.addCustomer(customer);
		 return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws CustomerException{
		 Customer updatedCustomer = customerService.updateCustomer(customer);
		 return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.ACCEPTED);
	}


	@PutMapping("/login")
	public ResponseEntity<Customer> loginCustomer(@RequestBody LogInModel logInModel) throws CustomerException {
		Customer loginCustomer = customerService.login(logInModel.getUserName(), logInModel.getPassword());
		return new ResponseEntity<Customer>(loginCustomer, HttpStatus.ACCEPTED);
	}

	@PutMapping("/logout")
	public ResponseEntity<Customer> logoutCustomer(@RequestBody custom uu) throws CustomerException {
		Customer logoutCustomer = customerService.logout(uu.getUuid());
		return new ResponseEntity<Customer>(logoutCustomer, HttpStatus.ACCEPTED);
	}


	
	
	@DeleteMapping("/remove/{customerId}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("customerId") Integer customerId) throws CustomerException{
		 Customer removedCustomer = customerService.removeCustomerById(customerId);
		 return new ResponseEntity<Customer>(removedCustomer, HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId") Integer customerId) throws CustomerException{
		 Customer customer = customerService.viewCustomer(customerId);
		 return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
