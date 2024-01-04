package com.foodapp.service;

import com.foodapp.exceptions.CartException;
import com.foodapp.exceptions.CustomerException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.Cart;

public interface FoodCartService {
	
	public Cart addItem(Integer customerId, Integer itemId, Integer quantity)throws CartException,ItemException, CustomerException;
	
	public Cart clearCart(Integer cartId)throws CartException;
	
	public Cart viewCart(Integer cartId)throws CartException;

	public Cart checkOut(Integer CustomerId)throws CartException;

	public Double total(Integer CustomerId)throws CartException;

}
