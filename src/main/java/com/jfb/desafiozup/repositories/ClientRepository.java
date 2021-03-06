package com.jfb.desafiozup.repositories;

import com.jfb.desafiozup.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

  Client findByEmail(String email);
  Client findByCpf(String cpf);

}
