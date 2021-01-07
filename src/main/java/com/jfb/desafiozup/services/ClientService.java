package com.jfb.desafiozup.services;

import java.util.Optional;

import com.jfb.desafiozup.dto.ClientDTO;
import com.jfb.desafiozup.entities.Client;
import com.jfb.desafiozup.repositories.ClientRepository;
import com.jfb.desafiozup.services.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

  @Autowired
  private ClientRepository repository;

  @Transactional
  public ClientDTO insert(ClientDTO dto) {

    Client entity = new Client();
    entity.setName(dto.getName());
    entity.setEmail(dto.getEmail());
    entity.setCpf(dto.getCpf());
    entity.setBirthday(dto.getBirthday());
    entity = repository.save(entity);

    return new ClientDTO(entity);
  }

  @Transactional(readOnly = true)
  public ClientDTO findById(Long id) {
    Optional<Client> obj = repository.findById(id);
    Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
    return new ClientDTO(entity);
  }
}
