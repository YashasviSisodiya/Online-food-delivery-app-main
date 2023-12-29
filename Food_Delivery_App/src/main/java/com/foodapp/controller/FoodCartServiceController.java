package com.foodapp.controller;

import com.foodapp.exceptions.CustomerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.authexceptions.AuthorizationException;
import com.foodapp.authservice.UserSessionService;
import com.foodapp.exceptions.CartException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.Cart;
import com.foodapp.service.FoodCartService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/cart")
public class FoodCartServiceController {
	
	@Autowired
	FoodCartService cartService;
	
	@Autowired
	UserSessionService userSessionService;
	

	
	
	@PutMapping("/add/{customerId}/{itemId}/{quantity}")
	public ResponseEntity<Cart> addItemToCart(@PathVariable("customerId") Integer customerId,
											  @PathVariable("itemId") Integer itemId,
											  @PathVariable("quantity") Integer quantity) throws CartException, ItemException, CustomerException {
		Cart updatedCart = cartService.addItem(customerId, itemId, quantity);
		return new ResponseEntity<Cart>(updatedCart, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/remove/{cartId}")
	public ResponseEntity<Cart> removeCart(@PathVariable("cartId") Integer cartId) throws CartException{
		Cart removedCart = cartService.clearCart(cartId);
		return new ResponseEntity<>(removedCart, HttpStatus.OK);
	}
	
	
	@GetMapping("/view/{cartId}")
	public Cart getCartByCartId(@PathVariable ("cartId") Integer cartId,@RequestParam String key) throws AuthorizationException, CartException{
		
		Integer sessionId = userSessionService.getUserSessionId(key);
		if(sessionId != null)
			return cartService.viewCart(cartId);
		else
			 throw new CartException();
			
	}

}
