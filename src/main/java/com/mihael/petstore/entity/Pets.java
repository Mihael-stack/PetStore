package com.mihael.petstore.entity;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Pets {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDate dateOfBirth;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    @ManyToOne()
    private Users owner;

    public Pets() {
    }

    public Pets(String name, String description, LocalDate dateOfBirth) {
        this.name = name;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.owner = null;
    }
    public abstract BigDecimal priceCalculation();

    public BigDecimal getPrice() {
        return price;
    }

    protected void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Users getOwner() {
        return owner;
    }

    public TypeEnum getType() {
        return type;
    }

    protected void setType(TypeEnum type) {
        this.type = type;
    }

    public void setOwner(Users user) {
        this.owner = user;
    }
}
