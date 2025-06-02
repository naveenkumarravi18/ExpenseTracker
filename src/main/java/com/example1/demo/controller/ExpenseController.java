package com.example1.demo.controller;
//ppackage com.example1.demo.controller;

import com.example1.demo.Entity.Expense;
import com.example1.demo.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    
    @PostMapping("/expense")
    public String addExpense(@ModelAttribute Expense expense) {
        expenseRepository.save(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses")
    public String listExpenses(Model model) {
        List<Expense> expenses = expenseRepository.findAll();
        model.addAttribute("expenses", expenses);

 
        Double totalExpenses = expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
        model.addAttribute("totalExpenses", totalExpenses);

        return "expense_list";  // your Thymeleaf page
    }


    @GetMapping("/expense/edit/{id}")
    public String editExpenseForm(@PathVariable Long id, Model model) {
        Expense expense = expenseRepository.findById(id).orElseThrow();
        model.addAttribute("expense", expense);
        return "expense_edit";
    }

//    @PostMapping("/expense/update/{id}")
//    public String updateExpense(@PathVariable Long id, @ModelAttribute Expense expense) {
//        expense.setId(id);
//        expenseRepository.save(expense);
//        return "redirect:/expenses";
//    }
//

    @GetMapping("/expense/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
        return "redirect:/expenses";
    }
}
