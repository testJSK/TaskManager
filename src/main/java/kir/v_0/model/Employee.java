/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kir.v_0.model;

import kir.v_0.entity.EmployeeEntity;

/**
 *
 * @author june
 */
public class Employee {
    private Long id;
    private String firstname;
    
    
    public static Employee toModel(EmployeeEntity entity){
        Employee model = new Employee();
        model.setId(entity.getId());
        model.setFirstname(entity.getFirstname());
        return model;
    }
    

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    
    
}
