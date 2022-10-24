/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package kir.tm.v_1.repo;

import kir.tm.v_1.entity.PersonEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author june
 */
public interface PersonRepo extends CrudRepository<PersonEntity, Long>{
    PersonEntity findByEmail(String email);
}
