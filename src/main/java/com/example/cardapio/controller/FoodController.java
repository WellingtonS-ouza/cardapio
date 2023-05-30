package com.example.cardapio.controller;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.cardapio.DTO.FoodDTO;
import com.example.cardapio.entities.Food;
import com.example.cardapio.service.FoodService;


@RestController
@RequestMapping(value ="/food")
public class FoodController {
	
	@Autowired
	private FoodService service;
	
	/*@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void saveFood(@RequestBody FoodDTO data) {
		Food foodData = new Food(data);	
		service.save(foodData);
		return;
		
	}
	*/

	@CrossOrigin(origins = "*", allowedHeaders = "*")	
    @GetMapping
    public ResponseEntity<List<FoodDTO>>findAll(){
    	
    	List<Food> foodList = service.findAll();
    	List<FoodDTO> dto = foodList.stream().map(x-> new FoodDTO(x)).toList();
    	return ResponseEntity.ok().body(dto) ;

    }

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody FoodDTO objDTO) {
		Food obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
		
	
	}
}
