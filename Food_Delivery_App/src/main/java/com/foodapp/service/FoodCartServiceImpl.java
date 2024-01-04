package com.foodapp.service;

import com.foodapp.exceptions.CustomerException;
import com.foodapp.model.CartItem;
import com.foodapp.model.Customer;
import com.foodapp.repository.CustomerDAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.exceptions.CartException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.Cart;
import com.foodapp.model.Item;
import com.foodapp.repository.CartDAO;
import com.foodapp.repository.CartItemDAO;
import com.foodapp.repository.ItemDAO;

@Service
public class FoodCartServiceImpl implements FoodCartService {

	@Autowired
	CartItemDAO cartItemDAO;

	@Autowired
	CartDAO cartDAO;

	@Autowired
	CustomerDAO customerDAO;

	@Autowired
	ItemDAO itemDAO;


	@Override
	public Cart clearCart(Integer cartId) throws CartException {
		Optional<Cart> opt = cartDAO.findById(cartId);
		if (opt.isPresent()) {
			Cart cart = opt.get();
			cartDAO.delete(cart);
			return cart;
		} else {
			throw new CartException("No Cart found with ID: " + cartId);
		}
	}


	@Override
	public Cart viewCart(Integer customerId) throws CartException {
		Optional<Cart> opt = cartDAO.findByCustomerIdAndPaidFalse(customerId);
		if (opt.isPresent()) {
			Cart cart = opt.get();
			return cart;
		} else {
			throw new CartException("No Cart found with ID: " + customerId);
		}
	}


	@Override
	public Cart checkOut(Integer customerId) throws CartException {
		Optional<Cart> opt = cartDAO.findByCustomerIdAndPaidFalse(customerId);
		if (opt.isPresent()) {
			Cart cart = opt.get();
			cart.setPaid(Boolean.TRUE);
			return cartDAO.save(cart);
		} else {
			throw new CartException("Oops! Your cart is empty");
		}
	}


	@Override
	public Double total(Integer customerId) throws CartException {

		Optional<Cart> opt = cartDAO.findByCustomerIdAndPaidFalse(customerId);
		if (opt.isPresent()){
			Cart cart= opt.get();
			List<CartItem> cartItems = cart.getCartItems();

			if (cartItems != null && !cartItems.isEmpty())
			{
				Double totalCartPrice = cartItems.stream()
						.mapToDouble(item -> item.getItem().getCost()* item.getQuantity())
						.sum();

				return totalCartPrice!= null ?totalCartPrice : 0.0;
			}
			else
			{
				throw new CartException("Oops! Your cart is empty");
			}
		}
		return 0.0;
	}







	@Override
	public Cart addItem(Integer customerId, Integer itemId, Integer quantity) throws CartException, ItemException, CustomerException {
		Customer customer = customerDAO.findById(customerId).orElseThrow(() ->  new CustomerException("No Customer found with ID: "+customerId));
		Optional<Cart> cartOptional = cartDAO.findByCustomerIdAndPaidFalse(customerId);
		Cart cart;
		if(!cartOptional.isPresent()){
			cart = new Cart();
			cart.setCustomer(customer);
			cart.setPaid(false);
			cart.setCartItems(new ArrayList<>());
			cartDAO.save(cart);
		} else {
			cart = cartOptional.get();
		}
		List<CartItem> items = cart.getCartItems();
		boolean productExists = false;
		for (CartItem item : items) {
			if ((item.getItem().getItemId()).equals(itemId)) {
				// If product already exists, update its quantity
				item.setQuantity(item.getQuantity() + quantity);
				productExists = true;
				break;
			}
		}
		if(!productExists) {
			Optional<Item> itemOptional = itemDAO.findById(itemId);
			if (itemOptional.isPresent()) {
				Item item = itemOptional.get();
				CartItem newCartItem = new CartItem();
				newCartItem.setItem(item);
				newCartItem.setQuantity(quantity);

				cartItemDAO.save(newCartItem);
				cart.getCartItems().add(newCartItem);
				cartDAO.save(cart);
				//cart.setCartItems(cartItemDAO.findAllByCartId(cart.getId()));
				return cart;

			} else {
				throw new ItemException("No Item found with ID: " + itemId);
			}
		}
        return cart;
    }
}
