package com.mihael.petstore.entitytest;

import com.mihael.petstore.entity.Cat;
import com.mihael.petstore.entity.Dog;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PetsUnitTest {

    @Test
    public void CatPriceAreCorrectlyCalculatedTest() {
        Cat cat1 = new Cat("name1", "desc", LocalDate.of(2020, 1, 1));
        BigDecimal priceCat1 = new BigDecimal(2);
        Cat cat2 = new Cat("name2", "desc", LocalDate.of(2019, 1, 1));
        BigDecimal priceCat2 = new BigDecimal(3);
        Cat cat3 = new Cat("name3", "desc", LocalDate.of(2018, 1, 1));
        BigDecimal priceCat3 = new BigDecimal(4);
        Cat cat4 = new Cat("name4", "desc", LocalDate.of(2017, 1, 1));
        BigDecimal priceCat4 = new BigDecimal(5);
        Cat cat5 = new Cat("name5", "desc", LocalDate.of(2016, 1, 1));
        BigDecimal priceCat5 = new BigDecimal(6);
        Cat cat6 = new Cat("name6", "desc", LocalDate.of(2015, 1, 1));
        BigDecimal priceCat6 = new BigDecimal(7);
        Cat cat7 = new Cat("name7", "desc", LocalDate.of(2014, 1, 1));
        BigDecimal priceCat7 = new BigDecimal(8);
        Cat cat8 = new Cat("name8", "desc", LocalDate.of(2013, 1, 1));
        BigDecimal priceCat8 = new BigDecimal(9);

        assertEquals(priceCat1, cat1.getPrice());
        assertEquals(priceCat2, cat2.getPrice());
        assertEquals(priceCat3, cat3.getPrice());
        assertEquals(priceCat4, cat4.getPrice());
        assertEquals(priceCat5, cat5.getPrice());
        assertEquals(priceCat6, cat6.getPrice());
        assertEquals(priceCat7, cat7.getPrice());
        assertEquals(priceCat8, cat8.getPrice());
    }
    @Test
    public void DogPriceAreCorrectlyCalculatedTest() {
        Dog dog1 = new Dog("name1", "desc", LocalDate.of(2020, 1, 1),1);
        BigDecimal priceDog1 = new BigDecimal(3);
        Dog dog2 = new Dog("name2", "desc", LocalDate.of(2019, 1, 1),2);
        BigDecimal priceDog2 = new BigDecimal(5);
        Dog dog3 = new Dog("name3", "desc", LocalDate.of(2018, 1, 1),3);
        BigDecimal priceDog3 = new BigDecimal(7);
        Dog dog4 = new Dog("name4", "desc", LocalDate.of(2017, 1, 1),4);
        BigDecimal priceDog4 = new BigDecimal(9);
        Dog dog5 = new Dog("name5", "desc", LocalDate.of(2016, 1, 1),5);
        BigDecimal priceDog5 = new BigDecimal(11);
        Dog dog6 = new Dog("name6", "desc", LocalDate.of(2015, 1, 1),6);
        BigDecimal priceDog6 = new BigDecimal(13);
        Dog dog7 = new Dog("name7", "desc", LocalDate.of(2014, 1, 1),7);
        BigDecimal priceDog7 = new BigDecimal(15);
        Dog dog8 = new Dog("name8", "desc", LocalDate.of(2013, 1, 1), 8);
        BigDecimal priceDog8 = new BigDecimal(17);

        assertEquals(priceDog1, dog1.getPrice());
        assertEquals(priceDog2, dog2.getPrice());
        assertEquals(priceDog3, dog3.getPrice());
        assertEquals(priceDog4, dog4.getPrice());
        assertEquals(priceDog5, dog5.getPrice());
        assertEquals(priceDog6, dog6.getPrice());
        assertEquals(priceDog7, dog7.getPrice());
        assertEquals(priceDog8, dog8.getPrice());
    }
}
