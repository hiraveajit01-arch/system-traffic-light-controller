package com.example.traffic_light_controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConflictDirectionException.class)
    public ResponseEntity<String> handleConflict() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Conflicting direction cannot be GREEN simultaneously");
    }

    @ExceptionHandler(ControllerPausedException.class)
    public ResponseEntity<String> handlePaused() {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Controller is currently paused");
    }
}

