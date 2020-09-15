package com.tts2.expensetracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tts2.expensetracker.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
