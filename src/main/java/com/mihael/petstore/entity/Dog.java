package com.mihael.petstore.entity;

import javax.persistence.Entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
@Entity
public class Dog extends Pets{
    @Min(0)
    @Max(10)
    private int rating;

    public Dog() {
    }

    public Dog(String name, String description, LocalDate dateOfBirth, int rating) {
        super(name, description, dateOfBirth);
        this.rating = rating;
        this.setPrice(priceCalculation());
        this.setType(TypeEnum.DOG);
    }

    @Override
    public BigDecimal priceCalculation() {
        LocalDate now = LocalDate.now();
        int years = Period.between(this.getDateOfBirth(),now).getYears();
        BigDecimal yearsBigDecimal = new BigDecimal(years);
        BigDecimal ratingBigDecimal = new BigDecimal(rating);
        return yearsBigDecimal.add(ratingBigDecimal);
    }

    public int getRating() {
        return rating;
    }
}
