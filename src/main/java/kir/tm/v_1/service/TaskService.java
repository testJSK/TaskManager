/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kir.tm.v_1.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import kir.tm.v_1.entity.TaskEntity;
import kir.tm.v_1.exception.NotFoundException;
import kir.tm.v_1.exception.UpdateException;
import kir.tm.v_1.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author june
 */
@Service
public class TaskService {
    
    @Autowired
    private TaskRepo taskRepo;
    
    public List<TaskEntity> getAll() throws Exception {
        List<TaskEntity> tasks = (List<TaskEntity>) taskRepo.findAll();
        
        if (tasks == null ) {
            throw new Exception("tasks do not get from db");
        }
        return tasks;
    }
    
    public Optional<TaskEntity> getOne(Long id) throws NotFoundException{
        Optional<TaskEntity> task = taskRepo.findById(id);
        
        if(task != null) {
            return task;
        }
        throw new NotFoundException("task by id");
    }
    
    public TaskEntity add(TaskEntity task) {
        if(task.getDateStart() == null) {
            task.setDateStart(new Date());
        }
        return taskRepo.save(task);
    }
    
    public TaskEntity update(Long id, TaskEntity newTask) throws UpdateException {
        System.out.println(id);
        
        TaskEntity task = taskRepo.findById(id).get();
        
        task = newTask;
        task.setId(id);
        
        if(task == null ) {
            throw new UpdateException("error update task " );
        }
       
        return taskRepo.save( task );        

    }
}
