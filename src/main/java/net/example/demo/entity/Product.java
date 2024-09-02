package net.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;   // Mô tả sản phẩm
    private double price;         // Giá
    private String size;          // (S, M, L, XL, ...)
    private String color;         // Màu sắc
    private int quantity;         // Số lượng tồn kho
    private boolean active;       // Trạng thái kích hoạt


    // Constructors, Getters, and Setters
    public Product() {}

    public Product(String name, double price, String description, String size, String color, int quantity, boolean active  ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
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


    public String GetDescription() {
        return description;
    }

    public void SetDescription(String description) {
        this.description = description;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }


    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }


    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }


    public boolean isActive() { return active; }

    public void setActive(boolean active) { this.active = active; }

 }
