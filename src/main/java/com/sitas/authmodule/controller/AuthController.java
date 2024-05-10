package com.sitas.authmodule.controller;

import com.sitas.authmodule.dto.LoginRequestDTO;
import com.sitas.authmodule.exception.InvalidCredentialsException;
import com.sitas.authmodule.exception.InvalidPersonException;
import com.sitas.authmodule.dto.RegisterRequestDTO;
import com.sitas.authmodule.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
@Tag(name = "Authentication and Authorization System",
        description = "Authentication and Authorization Operations")
public class AuthController {
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "Register a New Person", responses = {
            @ApiResponse(responseCode = "200", description = "Person registered successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid Person supplied"),
            @ApiResponse(responseCode = "500", description = "Server error"),
            @ApiResponse(responseCode = "403", description = "Access prohibited"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<?> save(
            @Parameter(description = "Person Object for Register", required = true)
            @Valid @RequestBody RegisterRequestDTO dto
            ) throws InvalidPersonException {
        try {
            return ResponseEntity.ok(authService.register(dto));
        } catch (InvalidPersonException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error processing request: " +
                    e.getMessage());
        }
    }

    @PostMapping("/login")
    @Operation(summary = "Login for a Person", responses = {
            @ApiResponse(responseCode = "200", description = "Person login successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid credentials supplied"),
            @ApiResponse(responseCode = "500", description = "Server error"),
            @ApiResponse(responseCode = "403", description = "Access prohibited"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<?> login(
            @Parameter(description = "Login Credentias")
            @Valid @RequestBody LoginRequestDTO dto
            ) throws InvalidCredentialsException {
        return ResponseEntity.ok(authService.login(dto));
    }
}
