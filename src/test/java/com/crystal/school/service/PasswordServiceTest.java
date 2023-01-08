package com.crystal.school.service;

import com.crystal.school.exception.InvalidLengthException;
import com.crystal.school.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordServiceTest {

    private final PasswordService passwordService = new PasswordService();
    int length = 10;
    String password = "testPassword";
    String salt;

    @BeforeEach
    void beforeAll() throws InvalidLengthException {
        salt = passwordService.getSaltValue(10);
    }


    @Test
    void getSaltValue_ThrowsInvalidLength() {
        Assertions.assertThrows(InvalidLengthException.class, () -> passwordService.getSaltValue(-10));
    }

    @Test
    void getSaltValue_CheckLength() throws InvalidLengthException {
        String saltValue = passwordService.getSaltValue(length);
        Assertions.assertEquals(length, saltValue.length());
    }

    @Test
    void generateSecurePassword_DoesNotContainOrg() throws InvalidLengthException {
        String salt = passwordService.getSaltValue(10);
        String securePassword = passwordService.encryptPassword(password, salt);
        Assertions.assertFalse(securePassword.contains(password));
    }

    @Test
    void generateSecurePassword_MoreCharacters() {

        String securePassword = passwordService.encryptPassword(password, salt);
        Assertions.assertTrue(securePassword.length() > password.length());
    }

    @Test
    void doesPasswordMatches() {
        String securePassword = passwordService.encryptPassword(password, salt);
        Assertions.assertTrue(passwordService.doesPasswordMatches(password, securePassword, salt));
    }

    @Test
    void createUser_Login() throws InvalidLengthException {
        User user = new User();
        user.setFirstName("Indrit");
        user.setLastName("Vaka");
        user.setEmail("indrit.vaka@crystal-system.eu");

        String saltValue = passwordService.getSaltValue(30);
        //The password we get from FE
        String inputtedPassword = "DemoPassword";
        // Only securedPassword will be saved to the DB
        user.setSalt(saltValue);
        String securePassword = passwordService.encryptPassword(inputtedPassword, saltValue);
        user.setPassword(securePassword);

        // Creating a login case
        Assertions.assertTrue(passwordService.doesPasswordMatches(inputtedPassword, user.getPassword(), user.getSalt()));
    }
}