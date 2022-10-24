/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kir.tm.v_1.service;

import java.util.List;
import java.util.Optional;
import kir.tm.v_1.entity.PersonEntity;
import kir.tm.v_1.exception.AlreadyExistException;
import kir.tm.v_1.exception.NotFoundException;
import kir.tm.v_1.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author june
 */
@Service
public class PersonService {
    
    @Autowired
    private PersonRepo personRepo;
    
    public List<PersonEntity> getAll() throws Exception {
        List<PersonEntity> persons = (List<PersonEntity>) personRepo.findAll();
        
        if( persons == null ) {
            throw new Exception("persons do not get from db");
        }
        return persons;
    }
    
    public PersonEntity add(PersonEntity person) throws AlreadyExistException {
        if(personRepo.findByEmail(person.getEmail()) != null ) {
            throw new AlreadyExistException(person.getEmail());
        }
        return personRepo.save(person);
    }
    
    public Optional<PersonEntity> getOne(Long id) throws NotFoundException {
        Optional<PersonEntity> person = personRepo.findById(id);
        
        if( person != null ) {
            return person;
        }
        throw new NotFoundException("person by id");
    }
}
