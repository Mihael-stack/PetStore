package com.mihael.petstore.services;

import com.mihael.petstore.dao.HistoryDao;
import com.mihael.petstore.dao.PetsDao;
import com.mihael.petstore.dao.UsersDao;
import com.mihael.petstore.entity.*;
import com.mihael.petstore.exceptions.InsufficientFundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.random;

@Transactional
@Service
public class PetsAndUsersServiceProduction implements PetsAndUsersService {
    private final UsersDao usersDao;
    private final PetsDao petsDao;
    private final HistoryDao historyDao;

    @Autowired
    public PetsAndUsersServiceProduction(UsersDao usersDao, PetsDao petsDao, HistoryDao historyDao) {
        this.usersDao = usersDao;
        this.petsDao = petsDao;
        this.historyDao = historyDao;
    }

    @Override
    public void createUsers() {
        Random randomNumber = new Random();
        for(int i = 0; i <10; i++){
            Users user = new Users(random(5,true,false),
                    random(7,true,false),
                    random(7,true,false)+"@mail.com", BigDecimal.valueOf(randomNumber.nextDouble(25)));
            this.usersDao.saveUser(user);
        }
    }

    @Override
    public void createPets() {
        Random randomNumber = new Random();
        long now = LocalDate.now().toEpochDay();
        long max = LocalDate.of(2002,1,1).toEpochDay();
        for(int i = 0; i < 10; i++){
            Dog dog = new Dog(
                    random(5, true, false),
                    random(5, true, false),
                    LocalDate.ofEpochDay(randomNumber.nextLong(max, now)),
                    randomNumber.nextInt(0, 10)
            );
            Cat cat = new Cat(
                    random(5, true, false),
                    random(5, true, false),
                    LocalDate.ofEpochDay(randomNumber.nextLong(max, now))
            );
            this.petsDao.savePet(dog);
            this.petsDao.savePet(cat);
        }
    }

    @Override
    public List<Users> findAllUsers() {
        return this.usersDao.findAllUsers();
    }

    @Override
    public List<Pets> findAllPets() {
        return this.petsDao.findAllPets();
    }

    @Override
    public void buy() throws InsufficientFundsException {
        LocalDate dateOfBuying = LocalDate.now();
        int fail = 0;
        int success = 0;

        List<Users> users = this.usersDao.findAllUsersOrderedByBudget();
        List<Pets> pets = this.petsDao.findAllPetsWithoutOwners();

        for(Users user : users){
            double isBudgetSame = user.getBudget().doubleValue(); // variable for later to see if the user has not found a pet.
            for(Pets pet : pets){
                if(user.getBudget().compareTo(pet.getPrice()) >= 0 && pet.getOwner() == null){ // checking if user has enough funds.
                    pet.setOwner(user); // appointing  owner to pet.
                    user.subtractBudget(pet.getPrice()); // subtracting funds from user.
                    success++; // adding to successful transaction
                    System.out.println((((pet.getType() == TypeEnum.CAT)) ? "Meow, cat " : "Woof, dog ") + pet.getName() + " has owner " + pet.getOwner().getFirstName() + " " + pet.getOwner().getLastName());
                    break; // Assumption: A user is going to buy one pet per Buy operation
                }
            }
            if(isBudgetSame == user.getBudget().doubleValue()) fail++; //checking if user has not found a pet.
        }

        this.historyDao.saveHistory(new History(dateOfBuying,success,fail));
        System.out.println("Time of buying: " + dateOfBuying);
        System.out.println("successful: " + success);
        System.out.println("failed: " + fail);
    }
}
