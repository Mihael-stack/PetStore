package com.mihael.petstore.dao;

import com.mihael.petstore.entity.Users;

import java.util.List;

public interface UsersDao {
    void saveUser(Users user);
    List<Users> findAllUsers();

    List<Users> findAllUsersOrderedByBudget();
}
