package com.example1.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example1.demo.Entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
