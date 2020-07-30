package com.santhosh.demo.expense.tracker.controller;

import com.santhosh.demo.expense.tracker.model.Expense;
import com.santhosh.demo.expense.tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseRepository repository;

    @GetMapping(path = {"/{expenseId}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Expense handleGet(@PathVariable Integer expenseId) {
        Optional<Expense> expense = repository.findById(expenseId);
        return expense.get();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Expense> handleGet(@RequestParam String userId) {
        return repository.findAllByUserId(userId);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Expense handlePut(Expense expense) {
        return repository.saveAndFlush(expense);
    }

    @PostMapping(path={"/{expenseId}"}, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Expense handleUpdate(@PathVariable Integer expenseId, Expense expense) {
        Optional<Expense> op = repository.findById(expenseId);
        Expense toUpdate = op.get();
        toUpdate.setCategory(expense.getCategory());
        toUpdate.setExpenseAmount(expense.getExpenseAmount());
        toUpdate.setDescription(expense.getDescription());
        toUpdate.setExpenseDate(expense.getExpenseDate().toString());
        return repository.saveAndFlush(toUpdate);
    }

    @DeleteMapping(path = {"/{expenseId}"}, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> handleDelete(@PathVariable Integer expenseId) {
        if (repository.existsById(expenseId)) {
            repository.deleteById(expenseId);
            return new ResponseEntity<String>("expense : "+expenseId+ " successfully deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("expense : "+expenseId+ " doesn't exists ", HttpStatus.OK);
        }
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<String> handleNotFoundException(NoSuchElementException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<String> handleException(RuntimeException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
