package com.pragma.financial.api.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@Schema(description = "DTO para la creación y actualización de clientes")
public class ClientRequest {
    @Schema(description = "Nombre completo del cliente", example = "Juan Pérez")
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String name;

    @Schema(description = "Correo electrónico del cliente", example = "juan.perez@example.com")
    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe ser válido")
    @Size(max = 100, message = "El email no puede exceder los 100 caracteres")
    private String email;

    @Schema(description = "Número de teléfono del cliente", example = "5551234567")
    @Size(max = 20, message = "El teléfono no puede exceder los 20 caracteres")
    private String phone;

    @Schema(description = "Fecha de nacimiento del cliente", example = "1990-01-01")
    private LocalDate birthDate;

    @Schema(description = "Saldo inicial del cliente", example = "1000.00")
    private BigDecimal initialBalance;
}