package com.example1.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example1.demo.repository.ExpenseRepository;
import com.example1.demo.repository.IncomeRepository;

@Controller
public class SummaryController {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/summary")
    public String showSummary(Model model) {
        Double totalIncome = incomeRepository.findAll()
                .stream()
                .mapToDouble(income -> income.getAmount())
                .sum();

        Double totalExpense = expenseRepository.findAll()
                .stream()
                .mapToDouble(expense -> expense.getAmount())
                .sum();

        Double balance = totalIncome - totalExpense;

        model.addAttribute("totalIncome", totalIncome);
        model.addAttribute("totalExpense", totalExpense);
        model.addAttribute("balance", balance);

        return "summary"; // Create summary.html page for display
    }
}
