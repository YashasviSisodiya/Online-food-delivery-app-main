package com.foodapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Item{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemId;
	private String itemName;
	private Double cost;
	private String imagePath;

	/*public Integer getId() {
		return itemId;
	}
	public void setId(Long id) {
		this.itemId = itemId;
	}
	public String getitemName() {
		return itemName;
	}
	public void setName(String name) {
		this.itemName = itemName;
	}
	public Double getCost() {
		return cost;
	}
	public void setType(String type) {
		this.cost = cost;
	}

	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	
//	@Embedded
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;

	public static void uploadImage(MultipartFile file) {
	}*/

}