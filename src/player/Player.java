package player;

import java.util.ArrayList;

import gameplay.RunnableGame;

public class Player {
	
	public final int playerValue = 2;
	public enum movementType {SPAWN, MOVEMENT;}
	ArrayList<Integer> inventory; //Should change to treasure class instead of Integer? 
	private int xPosCurrent, yPosCurrent, xPosPrevious, yPosPrevious;
	private RunnableGame game;
	
	public Player() {
		
	}
	
	public Player(int startPosX, int startPosY, RunnableGame game) {
		inventory = new ArrayList<>(); //makes sure that the inventory is empty when player is created. 
		xPosCurrent = startPosX;
		yPosCurrent = startPosY;
		this.game = game; //needed to get access to gameBoard coordinates
		try {
			spawnPlayer(xPosCurrent, yPosCurrent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void spawnPlayer(int posX, int posY) throws Exception {
		if(validateMovement(posX, posY, movementType.SPAWN)) {
			System.out.println("PLAYER SPAWNED");
			game.playerPosition_X_Position = xPosCurrent;
			game.playerPosition_Y_Position = yPosCurrent;
		}
		else
			throw new Exception("Player could not spawn on that tile");
	}
	
	//Should this be in gameClass instead?
	public boolean validateMovement(int posX, int posY, movementType mType) {
		int gameX = game.getGameBoardPos(posX, posY); //value of current tile
		boolean okMove = false;
		switch(mType) {
		case SPAWN:
			okMove = (posX == 1 && (posY > 0 && posY < 9)) ?  true : false; // if value of pos x is 1 and posy y is > 0 < 9 -> player spawns correctly
			break;
		case MOVEMENT:
			okMove = (gameX != 1) ?  true : false; // if value of tile is not 1 (wall) then it's ok to move to that tile
			break;
		}
	 
		return okMove;
	}
	
	public void doMove(int posX, int posY) {
			//Cache players last position to change value to zero on gameboard
			xPosPrevious = posX;
			yPosPrevious = posY;
			boolean moveOk = false;
			switch(game.arrow) {
				case "UP":
					if(moveOk = validateMovement(posX,--posY,movementType.MOVEMENT))
						//UpdateGameboard - new pos and old pos (two new methods?) should have the value of 0
				break;
				case "DOWN":
					if(moveOk = validateMovement(posX,++posY,movementType.MOVEMENT))
						//UpdateGameboard - new pos and old pos (two new methods?) should have the value of 0
				break;
				case "RIGHT":
					if(moveOk = validateMovement(++posX,posY,movementType.MOVEMENT))
						//UpdateGameboard - new pos and old pos (two new methods?) should have the value of 0
				break;
				case "LEFT":
					if(moveOk = validateMovement(--posX,posY,movementType.MOVEMENT))
						//UpdateGameboard - new pos and old pos (two new methods?) should have the value of 0
				break;
			}
			
			//CollisionAfterMovement();
		}
	}
	
	public void CollisionAfterMovement() {
		//TODO: check number of current tile, if laser - game over, if key - add to inventory etc...
	}

}
