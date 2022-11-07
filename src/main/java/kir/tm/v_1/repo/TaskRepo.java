package kir.tm.v_1.repo;

import java.util.List;
import java.util.Optional;
import kir.tm.v_1.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author june
 */
public interface TaskRepo extends CrudRepository<TaskEntity, Long>{

    public TaskEntity save(Optional<TaskEntity> task);

    public List <TaskEntity> findAllByParentId(Long parentId);
    
}
