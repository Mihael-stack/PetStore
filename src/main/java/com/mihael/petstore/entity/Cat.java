package com.mihael.petstore.entity;

import javax.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
@Entity
public class Cat extends Pets{
    public Cat() {
    }

    public Cat(String name, String description, LocalDate dateOfBirth) {
        super(name, description, dateOfBirth);
        this.setPrice(priceCalculation());
        this.setType(TypeEnum.CAT);
    }

    @Override
    public BigDecimal priceCalculation() {
        LocalDate now = LocalDate.now();
        int years = Period.between(this.getDateOfBirth(),now).getYears();
        return new BigDecimal(years);
    }

    @Override
    public String toString() {
        return "Meow, cat " + super.getName() + " ";
    }

}
