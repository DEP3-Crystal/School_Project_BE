package com.crystal.school.dao;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class JavaFakerTest {
    Faker faker = Faker.instance();
    Random random = new Random();
    @Test
    void nextInt(){
        int nextInt = faker.random().nextInt(2);
        boolean b = nextInt == 0 || nextInt == 1;
        System.out.println(nextInt);
        Assertions.assertTrue(b);
    }
}
