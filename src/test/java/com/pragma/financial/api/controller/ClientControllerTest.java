package com.pragma.financial.api.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.pragma.financial.api.service.ClientService;
import com.pragma.financial.api.model.dto.ClientResponse;

@WebMvcTest(ClientController.class)
class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetClientById() throws Exception {
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setId(UUID.randomUUID());
        clientResponse.setName("John Doe");
        clientResponse.setEmail("john.doe@example.com");
        clientResponse.setPhone("1234567890");
        clientResponse.setBirthDate(LocalDate.of(1990, 1, 1));
        clientResponse.setBalance(BigDecimal.valueOf(1000));
        clientResponse.setRegistrationDate(LocalDate.now());

        when(clientService.getClientById(clientResponse.getId())).thenReturn(clientResponse);

        mockMvc.perform(get("/api/clients/" + clientResponse.getId()))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString(clientResponse.getName())));
    }
}