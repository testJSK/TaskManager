/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kir.tm.v_1.controller;

import kir.tm.v_1.entity.TaskEntity;
import kir.tm.v_1.exception.NotFoundException;
import kir.tm.v_1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author june
 */
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(taskService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error get all tasks");
        }
    }
    
    @PostMapping
    public ResponseEntity add(@RequestBody TaskEntity task) {
        try {
            TaskEntity newTask = taskService.add(task);
            return ResponseEntity.ok("task was added" + newTask.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error added new task");
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(taskService.getOne(id));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error id "+ id);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity update(
            @PathVariable Long id,
            @RequestBody TaskEntity task) {
        try {
            return ResponseEntity.ok(taskService.update(id, task));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error update task controller " + e.getMessage());
        }
    }
}
