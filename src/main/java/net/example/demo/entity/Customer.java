package net.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private double email;
        private double phone;
        private double address;
        private boolean active;


        // Constructors, Getters, and Setters
        public Customer() {}

        public Customer(String name, double email, double phone, double address, boolean active ) {
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.address = address;
            this.active = active;
        }

        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public double getEmail() {
            return email;
        }
        public void setEmail(double email) {
            this.email = email;
        }

        public double getPhone(){return phone;}
        public void setPhone(double phone) { this.phone = phone; }

        public double getAddress(){return address;}
        public void setAddress(double address) { this.address = address; }

        public boolean isActive() { return active; }
        public void setActive(boolean active) { this.active = active; }

}
