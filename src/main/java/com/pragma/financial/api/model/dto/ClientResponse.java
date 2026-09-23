package com.pragma.financial.api.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@Schema(description = "DTO para la respuesta de clientes")
public class ClientResponse {
    @Schema(description = "Identificador único del cliente", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(description = "Nombre completo del cliente", example = "Juan Pérez")
    private String name;

    @Schema(description = "Correo electrónico del cliente", example = "juan.perez@example.com")
    private String email;

    @Schema(description = "Número de teléfono del cliente", example = "5551234567")
    private String phone;

    @Schema(description = "Fecha de nacimiento del cliente", example = "1990-01-01")
    private LocalDate birthDate;

    @Schema(description = "Saldo actual del cliente", example = "1500.00")
    private BigDecimal balance;

    @Schema(description = "Fecha de registro del cliente", example = "2023-01-01")
    private LocalDate registrationDate;
}