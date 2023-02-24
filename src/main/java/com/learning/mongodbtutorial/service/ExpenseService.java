package com.learning.mongodbtutorial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.mongodbtutorial.dto.ExpensePatch;
import com.learning.mongodbtutorial.dto.ExpenseRequest;
import com.learning.mongodbtutorial.model.Expense;
import com.learning.mongodbtutorial.repository.ExpenseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {

  private final ExpenseRepository expenseRepository;

  public String addExpense(ExpenseRequest expenseRequest) {
    Expense expense = Expense.builder().expenseName(expenseRequest.getExpenseName())
        .expenseCategory(expenseRequest.getExpenseCategory())
        .expenseAmount(expenseRequest.getExpenseAmount()).build();
    return expenseRepository.insert(expense)
        .getId(); // while creating record for the first time use insert

  }

  public void updateExpense(ExpensePatch expensePatch) {
    Expense existingExpense =
        expenseRepository.findById(expensePatch.getId())
            .orElseThrow(
                () -> new RuntimeException("No expense found with id " + expensePatch.getId()));

    existingExpense.setExpenseAmount(expensePatch.getExpenseAmount());
    existingExpense.setExpenseCategory(expensePatch.getExpenseCategory());
    existingExpense.setExpenseName(expensePatch.getExpenseName());

    expenseRepository.save(existingExpense); //use save for updation
  }

  public List<Expense> getAllExpenses() {
    return expenseRepository.findAll();
  }

  public Expense getExpenseByName(String expenseName) {
    return expenseRepository.findByName(expenseName).orElseThrow(
        () -> new RuntimeException(String.format("Expense %s not found in the db", expenseName)));
  }

  public void deleteExpense(String id) {
    expenseRepository.deleteById(id);
  }
}
