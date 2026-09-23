package com.pragma.financial.api.service;

import com.pragma.financial.api.model.dto.ClientRequest;
import com.pragma.financial.api.model.dto.ClientResponse;
import com.pragma.financial.api.repository.ClientRepository;
import com.pragma.financial.api.model.entity.Client;
import com.pragma.financial.api.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        Client client = new Client();
        BeanUtils.copyProperties(clientRequest, client);
        client.setRegistrationDate(java.time.LocalDate.now());
        client = clientRepository.save(client);
        return convertToClientResponse(client);
    }

    @Override
    public ClientResponse getClientById(UUID clientId) {
        Client client = clientRepository.findById(clientId)
               .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + clientId));
        return convertToClientResponse(client);
    }

    @Override
    public List<ClientResponse> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(this::convertToClientResponse).collect(Collectors.toList());
    }

    @Override
    public ClientResponse updateClient(UUID clientId, ClientRequest clientRequest) {
        Client client = clientRepository.findById(clientId)
               .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + clientId));
        BeanUtils.copyProperties(clientRequest, client, "id", "registrationDate");
        client = clientRepository.save(client);
        return convertToClientResponse(client);
    }

    @Override
    public void deleteClient(UUID clientId) {
        Client client = clientRepository.findById(clientId)
               .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + clientId));
        clientRepository.delete(client);
    }

    private ClientResponse convertToClientResponse(Client client) {
        ClientResponse clientResponse = new ClientResponse();
        BeanUtils.copyProperties(client, clientResponse);
        return clientResponse;
    }
}