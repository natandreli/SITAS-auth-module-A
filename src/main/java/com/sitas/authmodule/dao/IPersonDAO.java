package com.sitas.authmodule.dao;

import com.sitas.authmodule.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPersonDAO extends CrudRepository<Person, Integer> {
    @Query("SELECT COUNT(*) FROM Person p WHERE p.mail = ?1 OR p.identificationNumber = ?2")
    int existsByMailOrIdentificationNumber(String mail, String identificationNumber);

//    @Query("SELECT COUNT(*) FROM Person p WHERE p.mail = ?1 AND p.accessKey = ?2")
//    boolean existsByMailAndAccessKey(String mail, String accessKey);
}
