package com.visalnaqvi.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class UserSalaryModal {
    private String fullName;

    private Integer salary;

    @Id
    private Integer id;

    public UserSalaryModal() {
    }

    public UserSalaryModal(String fullName, Integer salary, Integer id) {
        this.fullName = fullName;
        this.salary = salary;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String firstName) {
        this.fullName = firstName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

