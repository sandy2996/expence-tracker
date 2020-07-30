package com.santhosh.demo.expense.tracker.repository;

import com.santhosh.demo.expense.tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    //the default methods are sufficient for us now
    //see spring data to learn more about repositories
    List<Expense> findAllByUserId(String userId);
}
