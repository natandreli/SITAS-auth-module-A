package com.sitas.authmodule.service;

import com.sitas.authmodule.dao.IPersonDAO;
import com.sitas.authmodule.dto.AuthResponseDTO;
import com.sitas.authmodule.dto.LoginRequestDTO;
import com.sitas.authmodule.dto.RegisterRequestDTO;
import com.sitas.authmodule.exception.InvalidPersonException;
import com.sitas.authmodule.exception.PersonAlreadyExistsException;
import com.sitas.authmodule.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private IPersonDAO personDAO;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private Person convertToPerson(RegisterRequestDTO dto) {
        Person person = new Person();
        person.setIdIdentificationType(dto.getIdIdentificationType());
        person.setIdentificationNumber(dto.getIdentificationNumber());
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setGenre(dto.getGenre());
        person.setBirthDate(dto.getBirthDate());
        person.setPhoneNumber(dto.getPhoneNumber());
        person.setCountry(dto.getCountry());
        person.setProvince(dto.getProvince());
        person.setCity(dto.getCity());
        person.setResidence(dto.getResidence());
        person.setMail(dto.getMail());
        person.setAccessKey(dto.getAccessKey());
        return person;
    }

    public Person register(RegisterRequestDTO dto) throws RuntimeException {
        if (!dto.getIdentificationNumber().matches("^\\d+$")) {
            throw new InvalidPersonException("Identification number must only contain digits.");
        }

        if (dto.getPhoneNumber() != null && !dto.getPhoneNumber().matches("^\\d+$")) {
            throw new InvalidPersonException("Phone number must only contain digits.");
        }

        if (!dto.getGenre().matches("^[MF]$")) {
            throw new InvalidPersonException("Genre must be 'M' or 'F'.");
        }

        if (dto.getMail().matches("[#='\"$;%]")) {
            throw new InvalidPersonException("Email must not contain '#', '=', ''', '\"', '$', ';', '%'");
        }

        if (!dto.getMail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidPersonException("Email must be a valid email address");
        }

        if (dto.getAccessKey().matches("[#='\"$;%]")) {
            throw new InvalidPersonException("Password must not contain '#', '=', ''', '\"', '$', ';', '%'");
        }

        if (personDAO.existsByMailOrIdentificationNumber(dto.getMail(), dto.getIdentificationNumber()) >= 1)
        {
            throw new PersonAlreadyExistsException("The person already exists.");
        }

        dto.setAccessKey(passwordEncoder.encode(dto.getAccessKey()));

        return personDAO.save(convertToPerson(dto));
    }

    public AuthResponseDTO login(LoginRequestDTO dto) {
        return null;
    }
}
