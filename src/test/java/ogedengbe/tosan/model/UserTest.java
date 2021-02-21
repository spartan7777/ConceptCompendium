package ogedengbe.tosan.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getAge() {
        // create the object that has the method I want to test
        User user = new User();

        // set date of birth for user
        LocalDate birthdate = LocalDate.parse("1971-01-01");
        user.setDateOfBirth(birthdate);

        // create a variable for the expected value
        int expectedAge = 50;

        // call the method and get the actual value
        int actualAge = user.getAge();

        // compare the two, pass or fail
        assertEquals(expectedAge, actualAge);
    }
}
