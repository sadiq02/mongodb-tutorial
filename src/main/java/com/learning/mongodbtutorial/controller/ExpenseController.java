package com.learning.mongodbtutorial.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learning.mongodbtutorial.dto.ExpensePatch;
import com.learning.mongodbtutorial.dto.ExpenseRequest;
import com.learning.mongodbtutorial.model.Expense;
import com.learning.mongodbtutorial.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
public class ExpenseController {

  private final ExpenseService expenseService;

  @PostMapping
  public ResponseEntity addExpense(@RequestBody ExpenseRequest expenseRequest) {
    return ResponseEntity.ok(expenseService.addExpense(expenseRequest));
  }

  @PutMapping
  public ResponseEntity updateExpense(@RequestBody ExpensePatch expensePatch) {
    expenseService.updateExpense(expensePatch);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Expense> getAllExpenses() {
    return expenseService.getAllExpenses();
  }

  @GetMapping("/{expenseName}")
  public ResponseEntity<Expense> getExpenseByName(@PathVariable String expenseName) {
    return ResponseEntity.ok(expenseService.getExpenseByName(expenseName));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteExpense(@PathVariable String id) {
    expenseService.deleteExpense(id);
    return ResponseEntity.noContent().build();
  }

}
