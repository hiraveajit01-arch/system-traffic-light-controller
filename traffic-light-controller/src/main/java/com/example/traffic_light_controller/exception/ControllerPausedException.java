package com.example.traffic_light_controller.exception;

public class ControllerPausedException extends RuntimeException {
    public ControllerPausedException() {
        super("Controller is paused");
    }
}

