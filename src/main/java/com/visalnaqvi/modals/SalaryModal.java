package com.visalnaqvi.modals;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "salary")
public class SalaryModal {

    @Id
    private Integer id; // Assuming a unique identifier for salary records

    private Integer userId; // Assuming userId is a foreign key relating to UserModal

    private double salary; // Assuming salary is stored as a double

    public SalaryModal() {
        // Default constructor
    }

    public SalaryModal(Integer id, Integer userId, double salary) {
        this.id = id;
        this.userId = userId;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
