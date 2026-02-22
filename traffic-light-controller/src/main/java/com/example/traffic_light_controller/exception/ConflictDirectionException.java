package com.example.traffic_light_controller.exception;
public class ConflictDirectionException extends RuntimeException {
    public ConflictDirectionException() {
        super("Conflicting green signal detected");
    }
}

