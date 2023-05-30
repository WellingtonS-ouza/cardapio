package com.example.cardapio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cardapio.DTO.FoodDTO;
import com.example.cardapio.entities.Food;
import com.example.cardapio.repositories.FoodRepository;
import com.example.cardapio.service.exception.ObjectNotFoundException;

@Service
public class FoodService {

	@Autowired
	private FoodRepository repo;

	public List<Food> findAll() {
		return repo.findAll();
	}

	public Food findById(Long id) {
	    Optional<Food> optionalFood = repo.findById(id);
	    if (optionalFood.isPresent()) {
	        return optionalFood.get();
	    } else {
	        throw new ObjectNotFoundException("Food not found with ID: " + id);
	    }
	}
	

	public Food insert(Food obj) {
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Food update(Food obj) {
	    Optional<Food> optionalFood = repo.findById(obj.getId());
	    if (optionalFood.isPresent()) {
	        Food newObj = optionalFood.get();
	        updateData(newObj, obj);
	        return repo.save(newObj);
	    } else {
	        
	        throw new ObjectNotFoundException("Object not found"); 
	    }
	}

	private void updateData(Food newObj, Food obj) {
		newObj.setImage(obj.getImage());
		newObj.setPrice(obj.getPrice());
		newObj.setTitle(obj.getTitle());
		
	}

	public Food fromDTO(FoodDTO objDTO) {
		return new Food(objDTO.getId(), objDTO.getTitle(), objDTO.getImage(), objDTO.getPrice());
	}

}
