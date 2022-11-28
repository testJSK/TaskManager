package kir.tm.v_1.controller;

import kir.tm.v_1.entity.PersonEntity;
import kir.tm.v_1.exception.AlreadyExistException;
import kir.tm.v_1.exception.NotFoundException;
import kir.tm.v_1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
    
    @Autowired
    private PersonService personService;
    
    @GetMapping()
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(personService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error getAll in controller " + e.getMessage());

        }
    }
    // @CrossOrigin(origins = "http://localhost:8080/api/v1/persons/add" 
    
    @PostMapping
    @CrossOrigin(origins = "/**")
    public ResponseEntity add(@RequestBody PersonEntity person) {

        try {
            PersonEntity newPerson = personService.add(person);
            return ResponseEntity.ok("person was added " + newPerson.getId());
        } catch (AlreadyExistException e) {
            return ResponseEntity.badRequest().body("ERROR IN PERSON CONTROLLER ADD() " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERROR IN PERSON CONTROLLER ADD()");
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(personService.getOne(id));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error id "+ id);
        }
    }
    
    @PostMapping("/{id}")
    // @PostMapping("/{id}") wtf CORS
    @CrossOrigin(origins = "/**")
    public ResponseEntity update(@PathVariable Long id, @RequestBody PersonEntity person) {
        try {
            return ResponseEntity.ok(personService.update(id, person));
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body("ERROR IN PERSON CONTROLLER UPDATE() " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ERROR IN PERSON CONTROLLER UPDATE() ");
        }       
    }
}
