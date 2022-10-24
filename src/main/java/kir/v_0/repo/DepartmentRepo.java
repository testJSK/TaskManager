/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package kir.v_0.repo;

import kir.v_0.entity.DepartmentEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author june
 */
public interface DepartmentRepo extends CrudRepository<DepartmentEntity, Long>{
    
    DepartmentEntity findByFullname(String fullname);
}
