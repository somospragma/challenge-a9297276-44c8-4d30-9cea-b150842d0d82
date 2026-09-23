package com.pragma.financial.api.service;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.financial.api.repository.ClientRepository;
import com.pragma.financial.api.model.dto.ClientRequest;
import com.pragma.financial.api.model.dto.ClientResponse;
import com.pragma.financial.api.model.entity.Client;

@SpringBootTest
class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateClient() {
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.setName("John Doe");
        clientRequest.setEmail("john.doe@example.com");
        clientRequest.setPhone("1234567890");
        clientRequest.setBirthDate(LocalDate.of(1990, 1, 1));
        clientRequest.setInitialBalance(BigDecimal.valueOf(1000));

        Client client = new Client();
        client.setName(clientRequest.getName());
        client.setEmail(clientRequest.getEmail());
        client.setPhone(clientRequest.getPhone());
        client.setBirthDate(clientRequest.getBirthDate());
        client.setBalance(clientRequest.getInitialBalance());
        client.setRegistrationDate(LocalDate.now());

        when(clientRepository.save(client)).thenReturn(client);

        ClientResponse clientResponse = clientService.createClient(clientRequest);

        verify(clientRepository).save(client);

        assert clientResponse!= null;
        assert clientResponse.getName().equals(clientRequest.getName());
        assert clientResponse.getEmail().equals(clientRequest.getEmail());
    }
}