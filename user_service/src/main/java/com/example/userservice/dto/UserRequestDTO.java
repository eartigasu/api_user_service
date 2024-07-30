package com.example.userservice.dto;

import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "DTO representando la solicitud de creacion de usuario")
public class UserRequestDTO {

  @NotBlank(message = "El nombre no puede estar vacío.")
  @Schema(description = "Nombre de usuario a crear")
  private String name;

  @NotBlank(message = "El correo electrónico no puede estar vacío.")
  @Email(message = "Formato de correo electrónico inválido.")
  @Schema(description = "Email de usuario a crear")
  private String email;

  @NotBlank(message = "La contraseña no puede estar vacía.")
  @Schema(description = "Contraseña de usuario a crear")
  private String password;

  @Schema(description = "Listado de telefonos a agregar al usuario")
  private List<PhoneDTO> phones;

}
