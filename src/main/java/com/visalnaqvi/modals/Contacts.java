package com.visalnaqvi.modals;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contacts {

        private String name;

        private String address;

        @Id
        @Column(unique = true , nullable = false)
        private String phoneNumber;

        private String email;

        // Default constructor
        public Contacts() {
        }

        public Contacts(String name, String address, String phoneNumber, String email) {
                this.name = name;
                this.address = address;
                this.phoneNumber = phoneNumber;
                this.email = email;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }
}
