package com.example.cardapio.service;

import java.util.List;


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
		Food food = repo.findAllById(id);
		if(food == null) {
			throw new ObjectNotFoundException("Object not found");
		}
		return food;
	}

	public Food insert(Food obj) {
		return repo.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		repo.deleteById(id);
	}

	public Food fromDTO(FoodDTO objDTO) {
		return new Food(objDTO.getId(), objDTO.getTitle(), objDTO.getImage(), objDTO.getPrice());
	}

}
