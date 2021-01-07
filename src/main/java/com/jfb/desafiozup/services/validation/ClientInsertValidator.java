package com.jfb.desafiozup.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.jfb.desafiozup.controllers.exceptions.FieldMessage;
import com.jfb.desafiozup.dto.ClientDTO;
import com.jfb.desafiozup.entities.Client;
import com.jfb.desafiozup.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientInsertValidator implements ConstraintValidator<ClientInsertValid, ClientDTO> {

    @Autowired
    private ClientRepository repository;

    @Override
    public void initialize(ClientInsertValid ann) {
    }

    @Override
    public boolean isValid(ClientDTO dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        Client email = repository.findByEmail(dto.getEmail());
        Client cpf = repository.findByCpf(dto.getCpf());

        if (email != null) {
            list.add(new FieldMessage("email", "Email já existente!"));
        }

        if (cpf != null) {
            list.add(new FieldMessage("cpf", "CPF já existente!"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}