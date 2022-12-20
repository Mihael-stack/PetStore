package com.mihael.petstore.dao;

import com.mihael.petstore.entity.Pets;

import java.util.List;

public interface PetsDao {
    void savePet(Pets pet);

    List<Pets> findAllPets();

    List<Pets> findAllPetsWithoutOwners();
}
