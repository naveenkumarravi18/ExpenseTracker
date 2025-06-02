package com.example1.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example1.demo.Entity.Income;
import com.example1.demo.repository.IncomeRepository;

@Controller
public class IncomeController {

    @Autowired
    private IncomeRepository incomeRepository;

    // Show form to add income
    @GetMapping("/income/add")
    public String showAddIncomeForm(Model model) {
        model.addAttribute("income", new Income());
        return "income_edit";
    }

  
    @PostMapping("/income/save")
    public String saveIncome(@ModelAttribute Income income) {
        incomeRepository.save(income);
        return "redirect:/incomes";
    }
    @PostMapping("/income/update/{id}")
    public String updateIncome(@PathVariable Long id, @ModelAttribute Income income) {
        Income existingIncome = incomeRepository.findById(id).orElseThrow(() -> new RuntimeException("Income not found"));
        existingIncome.setSource(income.getSource());
        existingIncome.setAmount(income.getAmount());
        incomeRepository.save(existingIncome);
        return "redirect:/incomes";
    }

    @GetMapping("/incomes")
    public String listIncomes(Model model) {
        List<Income> incomes = incomeRepository.findAll();
        model.addAttribute("incomes", incomes);

       
        Double totalIncome = incomes.stream()
                .mapToDouble(Income::getAmount)
                .sum();
        model.addAttribute("totalIncome", totalIncome);

        return "income_list";
    }
}
