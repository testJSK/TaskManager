package kir.tm.v_1.controller;

import kir.tm.v_1.entity.TaskEntity;
import kir.tm.v_1.exception.NotFoundException;
import kir.tm.v_1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity getAll(@RequestParam(required=false) String parentId) {     
        try {
            if(parentId == null) {
							// parentId == null  - get all 
							// parentId == ''    - get all with parentId == null
							// parentId == id    - get all with parentId == id
                return ResponseEntity.ok(taskService.getAll());
            } else if (parentId == "") {
							return ResponseEntity.ok(taskService.getAllByParentId(String.valueOf(parentId)));

						} else {
                return ResponseEntity.ok(taskService.getAllByParentId(String.valueOf(parentId)));
            }
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error get All ");
        }    
    }       
     
    @PostMapping
    public ResponseEntity add(@RequestBody TaskEntity task) {
        try {
            TaskEntity newTask = taskService.add(task);
            return ResponseEntity.ok("task was added " + newTask.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error added new task ");
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
    
    @PostMapping("/{id}")
    // @PutMapping("/{id}") cors wtf
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
