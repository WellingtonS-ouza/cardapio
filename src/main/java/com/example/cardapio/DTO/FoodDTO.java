package com.example.cardapio.DTO;

import com.example.cardapio.entities.Food;

public class FoodDTO {

	private Long id;
	private String title;
	private String image;
	private Integer price;

	public FoodDTO() {

	}

	public FoodDTO(Food entity) {
		id = entity.getId();
		title = entity.getTitle();
		image = entity.getImage();
		price = entity.getPrice();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImage() {
		return image;
	}

	public Integer getPrice() {
		return price;
	}

	
}
