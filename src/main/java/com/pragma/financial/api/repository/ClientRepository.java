package com.pragma.financial.api.repository;

import com.pragma.financial.api.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByIdAndEmailNot(UUID id, String email);
}