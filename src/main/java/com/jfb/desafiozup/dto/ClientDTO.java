package com.jfb.desafiozup.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jfb.desafiozup.entities.Client;
import com.jfb.desafiozup.services.validation.ClientInsertValid;

import org.hibernate.validator.constraints.br.CPF;

@ClientInsertValid
public class ClientDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;

  @Size(min = 5, max = 60, message = "Deve ter entre 3 e 40 caracteres")
  @NotBlank(message = "O campo nome não pode está em branco")
  private String name;

  @NotBlank(message = "O campo E-mail não pode está em branco")
  @Email(message = "Por favor entrar com um email válido")
  private String email;

  @NotBlank(message = "O campo CPF não pode está em branco")
  @CPF(message = "Por favor entre com um CPF válido")
  private String cpf;

  @NotNull(message = "Campo requerido")
  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date birthday;

  public ClientDTO() {
  }

  public ClientDTO(Long id, String name, String email, String cpf, Date birthday) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.cpf = cpf;
    this.birthday = birthday;
  }

  public ClientDTO(Client entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.email = entity.getEmail();
    this.cpf = entity.getCpf();
    this.birthday = entity.getBirthday();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Date getBirthday() {
    return this.birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

}
