/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kir.tm.v_1.entity;

import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "persons")
public class PersonEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;       
    
    @NotNull
    @Column(name = "first_name_base")
    private String firstNameBase;
    @Column(name = "first_name_who")
    private String firstNameWho;
    @Column(name = "first_name_to")
    private String firstNameTo;
    @Column(name = "first_name_from")
    private String firstNameFrom;
    
    @NotNull
    @Column(name = "last_name_base")
    private String lastNameBase;
    @Column(name = "last_name_who")
    private String lastNameWho;
    @Column(name = "last_name_To")
    private String lastNameTo;
    @Column(name = "last_name_from")
    private String lastNameFrom;
    
    @Column(name = "middle_name_base")
    private String middleNameBase;
    @Column(name = "middle_name_Who")
    private String middleNameWho;
    @Column(name = "middle_name_to")
    private String middleNameTo;
    @Column(name = "middle_name_from")
    private String middleNameFrom;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "job_position")
    private String jobPosition;
    
    @Column(name = "job_department")
    private String jobDepartment;   

    public PersonEntity() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstNameBase() {
        return firstNameBase;
    }

    public void setFirstNameBase(String firstNameBase) {
        this.firstNameBase = firstNameBase;
    }

    public String getFirstNameWho() {
        return firstNameWho;
    }

    public void setFirstNameWho(String firstNameWho) {
        this.firstNameWho = firstNameWho;
    }

    public String getFirstNameTo() {
        return firstNameTo;
    }

    public void setFirstNameTo(String firstNameTo) {
        this.firstNameTo = firstNameTo;
    }

    public String getFirstNameFrom() {
        return firstNameFrom;
    }

    public void setFirstNameFrom(String firstNameFrom) {
        this.firstNameFrom = firstNameFrom;
    }

    public String getLastNameBase() {
        return lastNameBase;
    }

    public void setLastNameBase(String lastNameBase) {
        this.lastNameBase = lastNameBase;
    }

    public String getLastNameWho() {
        return lastNameWho;
    }

    public void setLastNameWho(String lastNameWho) {
        this.lastNameWho = lastNameWho;
    }

    public String getLastNameTo() {
        return lastNameTo;
    }

    public void setLastNameTo(String lastNameTo) {
        this.lastNameTo = lastNameTo;
    }

    public String getLastNameFrom() {
        return lastNameFrom;
    }

    public void setLastNameFrom(String lastNameFrom) {
        this.lastNameFrom = lastNameFrom;
    }

    public String getMiddleNameBase() {
        return middleNameBase;
    }

    public void setMiddleNameBase(String middleNameBase) {
        this.middleNameBase = middleNameBase;
    }

    public String getMiddleNameWho() {
        return middleNameWho;
    }

    public void setMiddleNameWho(String middleNameWho) {
        this.middleNameWho = middleNameWho;
    }

    public String getMiddleNameTo() {
        return middleNameTo;
    }

    public void setMiddleNameTo(String middleNameTo) {
        this.middleNameTo = middleNameTo;
    }

    public String getMiddleNameFrom() {
        return middleNameFrom;
    }

    public void setMiddleNameFrom(String middleNameFrom) {
        this.middleNameFrom = middleNameFrom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getJobDepartment() {
        return jobDepartment;
    }

    public void setJobDepartment(String jobDepartment) {
        this.jobDepartment = jobDepartment;
    }

    @Override
    public String toString() {
        return "PersonEntity{" + "id=" + id + ", firstNameBase=" + firstNameBase + ", firstNameWho=" + firstNameWho + ", firstNameTo=" + firstNameTo + ", firstNameFrom=" + firstNameFrom + ", lastNameBase=" + lastNameBase + ", lastNameWho=" + lastNameWho + ", lastNameTo=" + lastNameTo + ", lastNameFrom=" + lastNameFrom + ", middleNameBase=" + middleNameBase + ", middleNameWho=" + middleNameWho + ", middleNameTo=" + middleNameTo + ", middleNameFrom=" + middleNameFrom + ", email=" + email + ", jobPosition=" + jobPosition + ", jobDepartment=" + jobDepartment + '}';
    }
    
    
    
}
