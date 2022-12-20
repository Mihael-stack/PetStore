package com.mihael.petstore.dao;

import com.mihael.petstore.entity.Pets;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class PetsDaoProduction implements PetsDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void savePet(Pets pet) {
        this.em.persist(pet);
    }

    @Override
    public List<Pets> findAllPets() {
        return this.em.createQuery("SELECT pets FROM Pets as pets").getResultList();
    }

    @Override
    public List<Pets> findAllPetsWithoutOwners() {
        return this.em.createQuery("SELECT pets FROM Pets as pets WHERE pets.owner IS NULL ORDER BY pets.price DESC").getResultList();
    }
}
