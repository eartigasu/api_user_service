package com.example.userservice.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO representando la respuesta de creacion de usuario")
public class UserResponseDTO {

  @Schema(description = "Identificador de usuario")
  private UUID id;

  @Schema(description = "Nombre de usuario")
  private String name;

  @Schema(description = "Email de usuario")
  private String email;

  @Schema(description = "Fecha de creación de usuario")
  private LocalDateTime created;

  @Schema(description = "Fecha de modificación de usuario")
  private LocalDateTime modified;

  @Schema(description = "Fecha de último acceso de usuario")
  private LocalDateTime lastLogin;

  @Schema(description = "Token generado para el usuario")
  private String token;

  @Schema(description = "Identifica si el usuario esta activo o no")
  private boolean isActive;

  @Schema(description = "Listado de telefonos registrados para el usuario")
  private List<PhoneDTO> phones;
}
