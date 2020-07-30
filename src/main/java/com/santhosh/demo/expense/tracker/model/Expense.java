package com.santhosh.demo.expense.tracker.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

/**
 * This pojo / bean is used for both data access and for presentation
 */
@Entity
@Table(name = Expense.TABLE_NAME)
public class Expense implements Serializable {
    public static final String TABLE_NAME = "expense";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="expense_id")
    private Integer expenseId;

    @Column(name="expense_amount", nullable=false)
    private float expenseAmount;

    @Column(name="category", nullable=false)
    private String category;

    @Column(name="description", nullable=false)
    private String description;

    @Column(name="expense_date", nullable=false)
    private String expenseDate;

    @JsonIgnore
    @Column(name="created_date", insertable=false, updatable=false)
    private Instant createdDate;

    @JsonIgnore
    @Column(name="last_modified_date", insertable=false, updatable=false)
    private Instant lastModifiedDate;

    @JsonIgnore
    @Column(name="user_id", nullable=false)
    private String userId;

    public Expense() {}

    public Expense(int expenseId, String userId) {
        this.expenseId = expenseId;
        this.userId = userId;
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public float getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(float expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonGetter
    public LocalDate getExpenseDate() {
        return LocalDate.parse(expenseDate);
    }

    @JsonSetter
    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
