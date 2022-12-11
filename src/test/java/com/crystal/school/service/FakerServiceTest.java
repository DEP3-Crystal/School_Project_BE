package com.crystal.school.service;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FakerServiceTest {

    @Test
    void email() {
        FakerService fakerService = FakerService.getInstance();
        String email = fakerService.email();

        Matcher emailMatcher = Pattern.compile("\\w{4}\\d{2}@gmail.com").matcher(email);

        assertTrue(emailMatcher.find());
    }
}