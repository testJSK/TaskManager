package kir.tm.v_1.repo;

import kir.tm.v_1.entity.TaskTypeEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author june
 */
public interface TaskTypeRepo extends CrudRepository<TaskTypeEntity, Long>{
    
}
