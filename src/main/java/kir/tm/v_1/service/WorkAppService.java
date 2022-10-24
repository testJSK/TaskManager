/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kir.tm.v_1.service;

import java.util.List;
import kir.tm.v_1.entity.WorkAppEntity;
import kir.tm.v_1.repo.WorkAppRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author june
 */
@Service
public class WorkAppService {
    
    @Autowired
    private WorkAppRepo workAppRepo;
    
    public List<WorkAppEntity> getAll() throws Exception {
        List<WorkAppEntity> workApps = (List<WorkAppEntity>) workAppRepo.findAll();
        
        if (workApps == null ) {
            throw new Exception("work app do not get from db ");
        } 
        return workApps;
    }
}
