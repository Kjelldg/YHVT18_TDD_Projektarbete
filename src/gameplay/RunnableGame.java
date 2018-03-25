package gameplay;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class RunnableGame {

	public static int playerPosition_X_Position = 0;
	public static int playerPosition_Y_Position = 0;
	public static int inputTest = 0;
	public static boolean startGame = false;
	public static String userInput = "";

	public static void main(String[] args) {

		JTextField textField = new JTextField();
		textField.addKeyListener(new UserInput());
		Gameboard gameBoard = new Gameboard();

		JFrame jframe = new JFrame();
		jframe.add(textField);
		jframe.setSize(2, 2);
		jframe.setVisible(true);

		System.out.println("Would you like to start the game? Press y for yes, n for no.");

		while (true) {

			switch (userInput) {
			case "YES":
				startGame = true;
				System.out.println("Good luck!");
				break;
			case "NO":
				startGame = false;
				System.out.println("That's a shame.");
				break;
			default:
				break;
			}

			while (startGame == true) {

				System.out.println("\n\n\n\n\n"); // Prints empty lines beneath the game board.

				// Loops the gameBoard array
				for (int i = 0; i < gameBoard.gameBoardArray.length; i++) {
					System.out.println(Arrays.toString(gameBoard.gameBoardArray[i]));

					for (int j = 0; j < gameBoard.gameBoardArray[i].length; j++) {
						if (gameBoard.gameBoardArray[i][j] == 1) {
							playerPosition_X_Position = j;
							playerPosition_Y_Position = i;
						}
					}
				}

				System.out.println("Y position is: " + playerPosition_Y_Position);
				System.out.println("X position is: " + playerPosition_X_Position);

				// Move the player by having the java swing window selected and use the arrow
				// keys (not numpad arrow keys btw).
				// TODO: Add exceptions & tests
				switch (userInput) {
				case "UP":
					System.out.println("Up arrow was pressed.");
					gameBoard.gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position] = 0;
					gameBoard.gameBoardArray[playerPosition_Y_Position - 1][playerPosition_X_Position] = 1;
					break;
				case "DOWN":
					System.out.println("Down arrow was pressed.");
					gameBoard.gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position] = 0;
					gameBoard.gameBoardArray[playerPosition_Y_Position + 1][playerPosition_X_Position] = 1;
					break;
				case "LEFT":
					System.out.println("Left arrow was pressed.");
					gameBoard.gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position] = 0;
					gameBoard.gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position - 1] = 1;
					break;
				case "RIGHT":
					System.out.println("Right arrow was pressed.");
					gameBoard.gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position] = 0;
					gameBoard.gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position + 1] = 1;
					break;
				default:
					System.out.println("Nothing was pressed.");
					break;
				}

				userInput = "";

				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
