package com.example.cardapio.DTO;

import com.example.cardapio.entities.UserRole;

public record RegisterDTO(String login, String password, UserRole role ) {

}
