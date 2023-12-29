package com.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.model.Cart;


@Repository
public interface CartDAO extends JpaRepository<Cart, Integer>{

}
