package com.mihael.petstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private int success;
    private int fail;

    public History() {
    }

    public History(LocalDate date, int success, int fail) {
        this.date = date;
        this.success = success;
        this.fail = fail;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getSuccess() {
        return success;
    }

    public int getFail() {
        return fail;
    }
}
