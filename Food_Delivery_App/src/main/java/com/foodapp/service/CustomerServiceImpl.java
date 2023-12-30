package com.foodapp.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.exceptions.CustomerException;
import com.foodapp.model.Cart;
import com.foodapp.model.Customer;
import com.foodapp.repository.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;

//	@Override
//	public Customer addCustomer(Customer customer) throws CustomerException {
//			Customer newCustomer = new Customer();
//			newCustomer.setAge(20);
//			newCustomer.setEmail("abc@gmail.com");
//			newCustomer.setFullName("yashasvi");
//			newCustomer.setMobileNumber("123456789");
//			newCustomer.setGender("female");
//			newCustomer.setAddress(null);
//
//			// Save the new customer to the database
//			return customerDAO.save(newCustomer);
//
//	}

	 @Override
	 public Customer addCustomer(Customer customer) throws CustomerException {
	 //Optional<Customer> opt = customerDAO.findById(customer.getId());
	 if(customer.getId()==null) {
	 return customerDAO.save(customer);
	 }else{
		 throw new CustomerException("Customer already exists");
	 }
	 }

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = customerDAO.findById(customer.getId());
		if (opt.isPresent()) {
			return customerDAO.save(customer);
		} else {
			throw new CustomerException("No such customer exists..");
		}
	}

	@Override
	public Customer removeCustomerById(Integer customerId) throws CustomerException {
		Optional<Customer> opt = customerDAO.findById(customerId);
		if (opt.isPresent()) {
			Customer customer = opt.get();
			customerDAO.delete(customer);
			return customer;
		} else {
			throw new CustomerException("No Customer found with ID: " + customerId);
		}
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		Optional<Customer> opt = customerDAO.findById(customerId);
		if (opt.isPresent()) {
			Customer customer = opt.get();
			return customer;
		} else {
			throw new CustomerException("No Customer found with ID: " + customerId);
		}
	}

}
