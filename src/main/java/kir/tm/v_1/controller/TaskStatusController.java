package kir.tm.v_1.controller;

import kir.tm.v_1.service.TaskStatusService;
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
@RequestMapping("/api/v1/taskstatus")
public class TaskStatusController {
    
    @Autowired
    private TaskStatusService taskStatusService;
    
    @GetMapping()
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(taskStatusService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error get all task status controller " +e);
        }
    }
}
