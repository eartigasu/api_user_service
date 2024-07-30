package com.example.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.userservice.dto.UserRequestDTO;
import com.example.userservice.dto.UserResponseDTO;
import com.example.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User API", description = "API para la gestión de usuarios")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  @Operation(summary = "Crear un nuevo usuario")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Usuario creado satisfactoriamente", content = @Content(mediaType = "application/json")),
      @ApiResponse(responseCode = "400", description = "Datos de entrada no válidos"),
      @ApiResponse(responseCode = "409", description = "Correo ya existe"),
      @ApiResponse(responseCode = "500", description = "Error interno creando usuario")})
  public ResponseEntity<?> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
    UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
  }
}
