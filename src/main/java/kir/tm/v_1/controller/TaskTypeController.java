package kir.tm.v_1.controller;

import kir.tm.v_1.service.TaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author june
 */
@RestController
@RequestMapping("/api/v1/tasktypes")
public class TaskTypeController {
    
    @Autowired
    private TaskTypeService taskTypesService;
    
    @GetMapping()
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(taskTypesService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error get all task types controller " +e);
        }
    }
}
