package com.mihael.petstore.entity;

import com.mihael.petstore.exceptions.InsufficientFundsException;

import javax.persistence.*;

import java.math.BigDecimal;

@Entity
public class Users {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private BigDecimal budget; // BigDecimal because has better accuracy, than double or float; When dealing with money always use BigDecimal.

    public Users() {
    }

    public Users(String firstName, String lastName, String emailAddress, BigDecimal budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.budget = budget;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void subtractBudget(BigDecimal price) throws InsufficientFundsException {
        if (this.budget.compareTo(price) >= 0) {
            this.budget = this.budget.subtract(price);
        }else {
            throw new InsufficientFundsException("Insufficient Funds");
        }
    }
}
