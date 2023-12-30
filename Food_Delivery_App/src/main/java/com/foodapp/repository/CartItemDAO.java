package com.foodapp.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.model.Cart;
import com.foodapp.model.CartItem;


@Repository
public interface CartItemDAO extends JpaRepository<CartItem, Integer>{
    List<CartItem> findAll();
}
