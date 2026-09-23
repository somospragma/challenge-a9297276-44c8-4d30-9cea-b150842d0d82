package com.pragma.financial.api.controller;


import com.pragma.financial.api.model.entity.Client;
import com.pragma.financial.api.model.dto.ClientRequest;
import com.pragma.financial.api.model.dto.ClientResponse;
import com.pragma.financial.api.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
@Tag(name = "Clients", description = "API for managing clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    @Operation(summary = "Create a new client")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Client created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<ClientResponse> createClient(@Valid @RequestBody ClientRequest request) {
        ClientResponse response = clientService.createClient(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all clients")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of clients", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientResponse.class, type = "array"))),
        @ApiResponse(responseCode = "404", description = "No clients found")
    })
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        List<ClientResponse> clients = clientService.getAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get client by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Client found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientResponse.class))),
        @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<ClientResponse> getClientById(@PathVariable UUID id) {
        ClientResponse client = clientService.getClientById(id);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update client by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Client updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ClientResponse.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<ClientResponse> updateClient(@PathVariable UUID id, @Valid @RequestBody ClientRequest request) {
        ClientResponse client = clientService.updateClient(id, request);
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete client by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Client deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<Void> deleteClient(@PathVariable UUID id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}