package com.mihael.petstore.dao;

import com.mihael.petstore.entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class UsersDaoProduction implements UsersDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(Users user) {
        this.em.persist(user);
    }

    @Override
    public List<Users> findAllUsers() {
        return this.em.createQuery("SELECT users FROM Users as users",Users.class).getResultList();
    }

    @Override
    public List<Users> findAllUsersOrderedByBudget() {
        return this.em.createQuery("SELECT users FROM Users as users ORDER BY users.budget DESC ", Users.class).getResultList();
    }
}
