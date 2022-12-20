package com.mihael.petstore.services;

import com.mihael.petstore.entity.Pets;
import com.mihael.petstore.entity.Users;
import com.mihael.petstore.exceptions.InsufficientFundsException;

import java.util.List;

public interface PetsAndUsersService {
    void createUsers();
    void createPets();
    List<Users> findAllUsers();

    List<Pets> findAllPets();

    void buy() throws InsufficientFundsException;
}
