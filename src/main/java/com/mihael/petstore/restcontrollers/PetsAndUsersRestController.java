package com.mihael.petstore.restcontrollers;

import com.mihael.petstore.exceptions.InsufficientFundsException;
import com.mihael.petstore.representations.PetsCollectionRepresentation;
import com.mihael.petstore.representations.UsersCollectionRepresentation;
import com.mihael.petstore.services.PetsAndUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PetsAndUsersRestController {

    private final PetsAndUsersService service;

    @Autowired
    public PetsAndUsersRestController(PetsAndUsersService service) {
        this.service = service;
    }

    @GetMapping("/create-users")
    public void createUsers(){
        this.service.createUsers();
    }

    @GetMapping("/create-pets")
    public void createPets(){
        this.service.createPets();
    }

    @GetMapping("/list-users")
    public UsersCollectionRepresentation listUsers(){
        return new UsersCollectionRepresentation(this.service.findAllUsers());
    }
    @GetMapping("/list-pets")
    public PetsCollectionRepresentation listPets(){
        return new PetsCollectionRepresentation(this.service.findAllPets());
    }
    @GetMapping("/buy")
    public void buy() throws InsufficientFundsException {
        this.service.buy();
    }

}
