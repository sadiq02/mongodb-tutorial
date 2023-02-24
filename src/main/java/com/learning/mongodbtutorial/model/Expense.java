package com.learning.mongodbtutorial.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Document("expense")
public class Expense {

  @Id
  private String id;
  @Field(name = "expense")
  @Indexed(unique = true)
  private String expenseName;
  @Field(name = "category")
  private ExpenseCategory expenseCategory;
  @Field(name = "amount")
  private BigDecimal expenseAmount;
}
