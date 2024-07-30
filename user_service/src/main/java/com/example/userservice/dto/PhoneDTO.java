package com.example.userservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO representando la solicitud de creación de usuario")
public class PhoneDTO {

  @Schema(description = "Número de teléfono")
  private String number;

  @Schema(description = "Código de ciudad")
  private String citycode;

  @Schema(description = "Código de país")
  private String contrycode;
}
