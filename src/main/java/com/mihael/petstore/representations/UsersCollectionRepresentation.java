package com.mihael.petstore.representations;

import com.mihael.petstore.entity.Users;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
@XmlRootElement(name = "users")
public class UsersCollectionRepresentation {
    private List<UsersRepresentation> users;

    public UsersCollectionRepresentation() {
    }

    public UsersCollectionRepresentation(List<Users> users) {
        this.users = new ArrayList<>();
        for(Users user : users){
            this.users.add(new UsersRepresentation(user));
        }
    }

    public List<UsersRepresentation> getUsers() {
        return users;
    }

    public void setUsers(List<UsersRepresentation> users) {
        this.users = users;
    }
}
