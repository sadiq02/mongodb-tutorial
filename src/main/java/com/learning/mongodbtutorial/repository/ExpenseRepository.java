package com.learning.mongodbtutorial.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.learning.mongodbtutorial.model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

  @Query("{'expenseName' : ?0}")
  Optional<Expense> findByName(String expenseName);
}
