package com.foodapp.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.io.File;
import java.nio.file.Files;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.foodapp.exceptions.ItemException;
import com.foodapp.model.Item;
import com.foodapp.repository.ItemDAO;

@Service
public interface ItemService {

	@Autowired 
	
	/*ItemDAO itemDAO;
	
	/*private final String PATH = "C:\\workspace\\";
	
	public Item uploadImage(MultipartFile file) throws IOException {
		String fullPath = PATH+file.getOriginalFilename();
		Item pImage = new Item();
		pImage.setItemName(file.getOriginalFilename());
		pImage.seCost(file.getContentType());
		pImage.setImagePath(fullPath);
		
		file.transferTo(new File(fullPath));
		return ItemDAO.save(pImage);
	}
	
	public byte[] downloadImage(String fileName) throws IOException{
        Optional<Item> imageObject = itemDAO.findByName(fileName);
        String fullPath = imageObject.get().getImagePath();
        return Files.readAllBytes(new File(fullPath).toPath());
    }*/

	
	public Item addItem(Item item)throws ItemException;
	
	public Item updateItem(Item item)throws ItemException;
	
	public Item viewItem(Integer itemId)throws ItemException;
	
	public Item removeItem(Integer itemId)throws ItemException;
	
	public List<Item> viewAllItems()throws ItemException;

}
