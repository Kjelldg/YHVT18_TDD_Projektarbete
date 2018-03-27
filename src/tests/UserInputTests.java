package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.KeyEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gameplay.RunnableGame;
import gameplay.UserInput;

public class UserInputTests {

	public static UserInput userInputTest;
	public static KeyEvent keyEvent;
	public static RunnableGame runnableGame;

	@BeforeEach
	void Init() {
		userInputTest = new UserInput();
		runnableGame = new RunnableGame();
	}

	@Test
	void checkForUserInput() {
		// char keyEventTestChar = keyEvent.getKeyChar();
		// userInputTest.keyPressed(keyEvent);

		assertEquals("", runnableGame.userInput);

	}

	@Test
	void startGameMethodTest() {
		boolean gameStartedTrue = userInputTest.startGame("YES");

		assertEquals(true, gameStartedTrue);
	}

}
