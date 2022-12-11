package com.crystal.school.service;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class FakerService {
    private static FakerService instance;
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());
    Faker faker = Faker.instance();

    private FakerService() {
    }

    public static synchronized FakerService getInstance() {
        if (instance == null)
            instance = new FakerService();

        return instance;
    }

    public String email() {
        return fakeValuesService.bothify("????##@gmail.com");
    }

    /**
     * This method returns a gender type
     *
     * @return a string of gender type
     */
    public String gender() {
        return fakeValuesService.fetchString("gender.types");
    }

    public String random(String[] strings) {
        Integer chosenItem = faker.random().nextInt(0, strings.length - 1);
        return strings[chosenItem];
    }
}
