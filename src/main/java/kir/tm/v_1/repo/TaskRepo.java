/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package kir.tm.v_1.repo;

import java.util.Optional;
import kir.tm.v_1.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author june
 */
public interface TaskRepo extends CrudRepository<TaskEntity, Long>{

    public TaskEntity save(Optional<TaskEntity> task);
    
}
