package com.pragma.financial.api.service;

import com.pragma.financial.api.model.dto.ClientRequest;
import com.pragma.financial.api.model.dto.ClientResponse;
import java.util.List;
import java.util.UUID;

public interface ClientService {
    ClientResponse createClient(ClientRequest clientRequest);
    ClientResponse getClientById(UUID clientId);
    List<ClientResponse> getAllClients();
    ClientResponse updateClient(UUID clientId, ClientRequest clientRequest);
    void deleteClient(UUID clientId);
}