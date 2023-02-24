package com.learning.mongodbtutorial.dto;

import java.math.BigDecimal;

import com.learning.mongodbtutorial.model.ExpenseCategory;

import lombok.Data;

@Data
public class ExpensePatch {

  private String id;
  private String expenseName;
  private ExpenseCategory expenseCategory;
  private BigDecimal expenseAmount;
}
