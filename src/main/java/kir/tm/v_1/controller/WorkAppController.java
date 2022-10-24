/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kir.tm.v_1.controller;

import kir.tm.v_1.service.WorkAppService;
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
@RequestMapping("/api/v1/workapps")
public class WorkAppController {
    
    @Autowired
    private WorkAppService workAppService;
    
    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(workAppService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(" error get all work app controller");
        }
    }
}
