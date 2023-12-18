package com.visalnaqvi.modals;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserModal {

        private String fullName;

        @Id
        private Integer id;

        // Default constructor
        public UserModal() {
        }

        // Parameterized constructor
        public UserModal(String fullName, Integer id) {
                this.fullName = fullName;
                this.id = id;
        }

        // Getters and setters
        public String getFullName() {
                return fullName;
        }

        public void setFullName(String fullName) {
                this.fullName = fullName;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        // Optional: Override toString(), equals(), and hashCode() methods if needed
}
