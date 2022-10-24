/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package kir.v_0.repo;

import kir.v_0.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author june
 */
public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Long>{
    
    EmployeeEntity findByFirstname(String firstname);
    EmployeeEntity findByEmail(String email);
    
}
