package kir.tm.v_1.service;

import java.util.List;
import kir.tm.v_1.entity.TaskStatusEntity;
import kir.tm.v_1.repo.TaskStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kir.tm.v_1.repo.TaskTypeRepo;

/**
 *
 * @author june
 */
@Service
public class TaskStatusService {
    
    @Autowired
    private TaskStatusRepo taskStatusRepo;
    
    public List<TaskStatusEntity> getAll() throws Exception {
        List<TaskStatusEntity> taskStatus = (List<TaskStatusEntity>) taskStatusRepo.findAll();
        
        if (taskStatus == null ) {
            throw new Exception("task status do not get from db");
        }
        return taskStatus;
    }
}
