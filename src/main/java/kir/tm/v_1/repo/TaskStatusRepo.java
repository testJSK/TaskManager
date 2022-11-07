package kir.tm.v_1.repo;

import kir.tm.v_1.entity.TaskStatusEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author june
 */
public interface TaskStatusRepo extends CrudRepository<TaskStatusEntity, Long>{
    
}
