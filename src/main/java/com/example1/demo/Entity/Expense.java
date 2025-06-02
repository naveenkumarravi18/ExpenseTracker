package com.example1.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double amount;
    private String category;

    public Long getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public Double getAmount() {
		return amount;
	}
	public String getCategory() {
		return category;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
    // Getters and Setters
    // (can use Lombok if you want)
}
