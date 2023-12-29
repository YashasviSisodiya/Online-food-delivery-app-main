package com.foodapp.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.model.Cart;


@Repository
public interface CartDAO extends JpaRepository<Cart, Integer>{
    Optional<Cart> findAllByCustomerIdAndPaidFalse(Integer customerId);

    List<Cart> findAllByCustomerIdAndPaidTrue(Integer customerId);
}
