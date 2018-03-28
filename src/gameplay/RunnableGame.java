package gameplay;

import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JTextField;

import GUI.TileType.InvalidIdException;
import GUI.Window;
import player.Player;
import player.Player.movementType;

public class RunnableGame {

	public static int playerPosition_X_Position = 0;
	public static int playerPosition_Y_Position = 0;
	public static int inputTest = 0;
	public static boolean startGame = false;
	public static String userInput = "";
	public static Gameboard gameBoard;
	public static GameplayLogic gpLogic;
	public static int gold;
	public static boolean openDoor;

	public static void main(String[] args) {

		JTextField textField = new JTextField();
		textField.addKeyListener(new UserInput());
		UserInput userInputClass = new UserInput();
		gameBoard = new Gameboard();
		Player player = new Player(1,2);

		Window window = new Window(); // Nytt objekt för att skapa GUI-gameboard.

		JFrame jframe = new JFrame();
		jframe.add(textField);
		jframe.setSize(100, 100);
		jframe.setVisible(true);
		jframe.setTitle("Window for user input.");

		System.out.println("Would you like to start the game? Press y for yes, n for no.");

		while (true) {

			startGame = userInputClass.startGame(userInput);

			while (startGame == true) {

				// Skapar Mikaels GUI fönster.
				try {
					window.update(gameBoard.gameBoardArray);
				} catch (InvalidIdException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

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
					if(player.validateMovement(playerPosition_Y_Position -1, playerPosition_X_Position, movementType.MOVEMENT)) {
						gameBoard.gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position] = 0;
						gameBoard.gameBoardArray[playerPosition_Y_Position - 1][playerPosition_X_Position] = 1;
						player.CollisionAfterMovement(playerPosition_Y_Position-1, playerPosition_X_Position);
						
						int value = gameBoard.getGameBoardPosistion(playerPosition_Y_Position -1, playerPosition_X_Position);
						if(value == 3) {
							gpLogic.checkTreasure(value);
							gold = 3;
							} else if(value == 4) {
								//Calculate players gold.
								gold = gpLogic.checkGold(gpLogic.treasureOne, gpLogic.treasureTwo, gpLogic.treasureThree);
								
								//Check if the gold is enough for entry.
								openDoor = gpLogic.openDoor(gold);
								if(openDoor = true) {
									System.out.println("YOU WIN!");
									break;
								} else {
									System.out.println("Not enough gold!");
								}
							}	
					}
					break;
				case "DOWN":
					System.out.println("Down arrow was pressed.");
					if(player.validateMovement(playerPosition_Y_Position +1, playerPosition_X_Position, movementType.MOVEMENT)) {
					gameBoard.gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position] = 0;
					gameBoard.gameBoardArray[playerPosition_Y_Position + 1][playerPosition_X_Position] = 1;
					player.CollisionAfterMovement(playerPosition_Y_Position-1, playerPosition_X_Position);

					int value = gameBoard.getGameBoardPosistion(playerPosition_Y_Position -1, playerPosition_X_Position);
					if(value == 3) {
						gpLogic.checkTreasure(value);
						gold = 3;
						} else if(value == 4) {
							//Calculate players gold.
							gold = gpLogic.checkGold(gpLogic.treasureOne, gpLogic.treasureTwo, gpLogic.treasureThree);
							
							//Check if the gold is enough for entry.
							openDoor = gpLogic.openDoor(gold);
							if(openDoor = true) {
								System.out.println("YOU WIN!");
								break;
							} else {
								System.out.println("Not enough gold!");
							}
						}	
					}
					break;
				case "LEFT":
					System.out.println("Left arrow was pressed.");
					if(player.validateMovement(playerPosition_Y_Position, playerPosition_X_Position -1, movementType.MOVEMENT)) {
					gameBoard.gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position] = 0;
					gameBoard.gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position - 1] = 1;
					player.CollisionAfterMovement(playerPosition_Y_Position-1, playerPosition_X_Position);

					int value = gameBoard.getGameBoardPosistion(playerPosition_Y_Position -1, playerPosition_X_Position);
					if(value == 3) {
						gpLogic.checkTreasure(value);
						gold = 3;
						} else if(value == 4) {
							//Calculate players gold.
							gold = gpLogic.checkGold(gpLogic.treasureOne, gpLogic.treasureTwo, gpLogic.treasureThree);
							
							//Check if the gold is enough for entry.
							openDoor = gpLogic.openDoor(gold);
							if(openDoor = true) {
								System.out.println("YOU WIN!");
								break;
							} else {
								System.out.println("Not enough gold!");
							}
						}	
					}
					break;
				case "RIGHT":
					System.out.println("Right arrow was pressed.");
					if(player.validateMovement(playerPosition_Y_Position, playerPosition_X_Position + 1, movementType.MOVEMENT)) {
					gameBoard.gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position] = 0;
					gameBoard.gameBoardArray[playerPosition_Y_Position][playerPosition_X_Position + 1] = 1;
					player.CollisionAfterMovement(playerPosition_Y_Position-1, playerPosition_X_Position);
					
					int value = gameBoard.getGameBoardPosistion(playerPosition_Y_Position -1, playerPosition_X_Position);
					if(value == 3) {
						gpLogic.checkTreasure(value);
						gold = 3;
						} else if(value == 4) {
							//Calculate players gold.
							gold = gpLogic.checkGold(gpLogic.treasureOne, gpLogic.treasureTwo, gpLogic.treasureThree);
							
							//Check if the gold is enough for entry.
							openDoor = gpLogic.openDoor(gold);
							if(openDoor = true) {
								System.out.println("YOU WIN!");
								break;
							} else {
								System.out.println("Not enough gold!");
							}
						}	
					}
					break;
				default:
					System.out.println("Nothing was pressed.");
					break;
				}

				userInput = "";

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
