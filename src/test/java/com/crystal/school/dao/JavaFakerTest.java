package com.crystal.school.dao;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

 class JavaFakerTest {
    Faker faker = Faker.instance();

     @Test
    void nextInt(){
        int nextInt = faker.random().nextInt(2);
        boolean b = nextInt == 0 || nextInt == 1;
        System.out.println(nextInt);
        Assertions.assertTrue(b);
    }
    @Test
    void nextInt2(){
        int nextInt = faker.random().nextInt(6);

        System.out.println((byte) nextInt);
        Assertions.assertTrue(true);
    }
}
