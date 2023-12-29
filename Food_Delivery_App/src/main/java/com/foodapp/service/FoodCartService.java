package com.foodapp.service;

import com.foodapp.exceptions.CartException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.Cart;

public interface FoodCartService {
	
	public Cart saveCart(Cart cart)throws CartException;
	
	public Cart addItem(Integer cartId, Integer itemId)throws CartException,ItemException;
	
	public Cart clearCart(Integer cartId)throws CartException;
	
	public Cart viewCart(Integer cartId)throws CartException;

}
