package gameplay;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserInput extends KeyAdapter {

	/*
	 * This code sets the public static String userInput to various values based on
	 * the user's keyboard actions.
	 */
	@Override
	public void keyPressed(KeyEvent event) {

		char keyPressedDown = event.getKeyChar();

		if (event.getKeyCode() == KeyEvent.VK_UP) {
			RunnableGame.userInput = "UP";
		} else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			RunnableGame.userInput = "DOWN";
		} else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			RunnableGame.userInput = "LEFT";
		} else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			RunnableGame.userInput = "RIGHT";
		} else if (keyPressedDown == 'y') {
			RunnableGame.userInput = "YES";
		} else if (keyPressedDown == 'n') {
			RunnableGame.userInput = "NO";
		}
	}

}
