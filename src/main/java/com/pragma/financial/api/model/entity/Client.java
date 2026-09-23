package com.pragma.financial.api.model.entity;

import com.pragma.financial.api.model.dto.ClientRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(max = 15)
    private String phone;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    @DecimalMin("0.00")
    private BigDecimal initialBalance;

    @NotNull
    private LocalDate registrationDate;

    public Client() {}

    public Client(ClientRequest request) {
        this.name = request.getName();
        this.email = request.getEmail();
        this.phone = request.getPhone();
        this.birthDate = request.getBirthDate();
        this.initialBalance = request.getInitialBalance();
        this.registrationDate = LocalDate.now();
    }

    // Getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public BigDecimal getInitialBalance() { return initialBalance; }
    public void setInitialBalance(BigDecimal initialBalance) { this.initialBalance = initialBalance; }
    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }
}