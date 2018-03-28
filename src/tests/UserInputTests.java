package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gameplay.UserInput;

public class UserInputTests {

    public static UserInput userInputTest;

    @BeforeEach
    void Init()
    {
        userInputTest = new UserInput();
    }

    @Test
    void checkForUserInput ()
    {
        userInputTest.keyPressed(null);
    }

}
