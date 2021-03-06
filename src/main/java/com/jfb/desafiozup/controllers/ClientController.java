package com.jfb.desafiozup.controllers;

import java.net.URI;

import javax.validation.Valid;

import com.jfb.desafiozup.dto.ClientDTO;
import com.jfb.desafiozup.services.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

  @Autowired
  private ClientService service;

  @PostMapping
  public ResponseEntity<ClientDTO> insert(@RequestBody @Valid ClientDTO dto) {

    dto = service.insert(dto);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
      .buildAndExpand(dto.getId()).toUri();
    return ResponseEntity.created(uri).body(dto);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<ClientDTO> findById(@PathVariable("id") Long id) {
    ClientDTO dto = service.findById(id);
    return ResponseEntity.ok().body(dto);
  }
}
