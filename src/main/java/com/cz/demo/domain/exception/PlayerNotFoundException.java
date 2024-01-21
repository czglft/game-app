package com.cz.demo.domain.exception;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException(String id) {
        super(String.format("Player with id %s not found", id));
    }
}
