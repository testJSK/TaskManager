/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kir.v_0.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author june
 */
@Entity
@Table(name="employee")
public class EmployeeEntity implements Serializable {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long departmentid;
    private String firstname;
    private String lastname;
    private String middlename;
    private String email;
    private Boolean isactive;
    private String fullnameposition;
    private String shortnameposition;

    public EmployeeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Long departmentid) {
        this.departmentid = departmentid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    public String getFullnameposition() {
        return fullnameposition;
    }

    public void setFullnameposition(String fullnameposition) {
        this.fullnameposition = fullnameposition;
    }

    public String getShortnameposition() {
        return shortnameposition;
    }

    public void setShortnameposition(String shortnameposition) {
        this.shortnameposition = shortnameposition;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" + "id=" + id + ", departmentid=" + departmentid + ", firstname=" + firstname + ", lastname=" + lastname + ", middlename=" + middlename + ", email=" + email + ", isactive=" + isactive + ", fullnameposition=" + fullnameposition + ", shortnameposition=" + shortnameposition + '}';
    }

    
    
    
    
    
    
}
