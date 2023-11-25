package com.foodapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.model.Item;


@Repository
public interface ItemDAO extends JpaRepository<Item, Integer>{

}
