package kir.tm.v_1.service;

import java.util.List;
import kir.tm.v_1.entity.TaskTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kir.tm.v_1.repo.TaskTypeRepo;

/**
 *
 * @author june
 */
@Service
public class TaskTypeService {
    
    @Autowired
    private TaskTypeRepo taskTypesRepo;
    
    public List<TaskTypeEntity> getAll() throws Exception {
        List<TaskTypeEntity> taskTypes = (List<TaskTypeEntity>) taskTypesRepo.findAll();
        
        if (taskTypes == null ) {
            throw new Exception("taskTypes do not get from db");
        }
        return taskTypes;
    }
}
