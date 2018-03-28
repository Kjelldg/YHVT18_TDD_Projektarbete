package player;

import java.util.ArrayList;

import gameplay.Gameboard;
import gameplay.GameplayLogic;
import gameplay.RunnableGame;

public class Player {

	public final int playerValue = 2;
	public Gameboard gbTest;

	public enum movementType {
		SPAWN, MOVEMENT;
	}

	ArrayList<Integer> inventory; // Should change to treasure class instead of Integer?
	private int xPosCurrent, yPosCurrent;

	public Player() {
		gbTest = new Gameboard();
		inventory = new ArrayList<>();
		xPosCurrent = RunnableGame.playerPosition_X_Position;
		yPosCurrent = RunnableGame.playerPosition_Y_Position;

	}

	public Player(int startPosY, int startPosX) {
		gbTest = new Gameboard(); //for testing
		inventory = new ArrayList<>(); // makes sure that the inventory is empty when player is created.
		xPosCurrent = startPosX;
		yPosCurrent = startPosY;
		//this.game = game; // needed to get access to gameBoard coordinates
		try {
			spawnPlayer(xPosCurrent, yPosCurrent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spawnPlayer(int posX, int posY) throws Exception {
		if (validateMovement(posX, posY, movementType.SPAWN)) {
			RunnableGame.playerPosition_X_Position = xPosCurrent;
			RunnableGame.playerPosition_Y_Position = yPosCurrent;
		} else
			throw new Exception("Player could not spawn on that tile");
	}

	public boolean validateMovement(int posY, int posX, movementType mType) {
		boolean okMove = false;
		if((posX >= 0 && posX <= 9)&&(posY >= 0 && posY <= 9)) {
		//int gameX = gbTest.getGameBoardPosistion(posY, posX); //used 4 tests!
		int gameX = RunnableGame.gameBoard.getGameBoardPosistion(posY, posX); // value of current tile
		switch (mType) {
		case SPAWN:
			okMove = (posX == 1 && (posY > 0 && posY < 9)) ? true : false; // if value of pos x is 1 and posy y is > 0 <
																			// 9 -> player spawns correctly
			break;
		case MOVEMENT:
			okMove = (gameX != 1) ? true : false; // if value of tile is not 1 (wall) then it's ok to move to that tile
			break;
		}
		}

		return okMove;
	}
	//NOT NEEDED SINCE IMPLEMENTATION IS IN RUNNABLEGAME
	public boolean doMove(int posY, int posX, String direction) {
		// Cache players last position to change value to zero on gameboard
		int xPosPrevious = posX;
		int yPosPrevious = posY;
		boolean moveOk = false;
		// direction was game.arrow
		switch (direction) {
		case "UP":
			if (moveOk = validateMovement(yPosPrevious - 1, xPosPrevious, movementType.MOVEMENT))
				System.out.println("Moving up");
			// UpdateGameboard - new pos and old pos (two new methods?) should have the
			// value of 0
			break;
		case "DOWN":
			if (moveOk = validateMovement(yPosPrevious+ 1, xPosPrevious, movementType.MOVEMENT))
				System.out.println("moving down");
				// UpdateGameboard - new pos and old pos (two new methods?) should have the
				// value of 0
				break;
		case "RIGHT":
			if (moveOk = validateMovement((yPosPrevious), xPosPrevious +1 , movementType.MOVEMENT))
				System.out.println("Moving right");
			// UpdateGameboard - new pos and old pos (two new methods?) should have the
			// value of 0
			break;
		case "LEFT":
			if (moveOk = validateMovement(yPosPrevious, xPosPrevious - 1, movementType.MOVEMENT))
				System.out.println("moving left");
				// UpdateGameboard - new pos and old pos (two new methods?) should have the
				// value of 0
				break;
		}

		return moveOk;

		// CollisionAfterMovement();
	}

	public boolean CollisionAfterMovement(int posY, int posX) {
		//int tileValue = RunnableGame.gameBoard.getGameBoardPosistion(posY, posX); <-- for tests
		int tileValue = gbTest.getGameBoardPosistion(posY, posX);
		boolean collision;
		switch (tileValue) {
		case 3:
			System.out.println("FOUND TREASURE");
			return true;
		// break;
		case 4:
			System.out.println("FOUND DOOR");
			return true;
		// break;
		case 5:
			System.out.println("LASERDEATH!");
			return true;
		// break;
		default:
			System.out.println("Found nothing");
			return false;
		}
		// TODO: check number of current tile, if laser - game over, if key - add to
		// inventory etc...
	}

}