package com.frankson.app.service;

import com.frankson.app.error.exception.ObjectNotFoundException;
import com.frankson.app.model.Client;
import com.frankson.app.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findClient(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException(String.format("Object not found! id: %s, type: %s", id, Client.class.getName())));
    }
}
