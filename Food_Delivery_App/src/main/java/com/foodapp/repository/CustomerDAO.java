package com.foodapp.repository;

import com.foodapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import com.foodapp.model.Customer;


@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

    Optional<Customer> findByUserName(String userName);

    Optional<Customer> findByUuid(UUID uuid);



}
