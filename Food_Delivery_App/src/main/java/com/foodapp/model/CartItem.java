package com.foodapp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @ManyToOne(targetEntity = Cart.class,cascade = CascadeType.ALL)
	private Cart cart;

    @ManyToOne(targetEntity = Item.class,cascade = CascadeType.ALL)
	private Item item;

    private Integer quantity;
}
