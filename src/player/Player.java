package player;

import java.util.ArrayList;

import gameplay.RunnableGame;

public class Player {
	
	ArrayList<Integer> inventory; //Should change to treasure class instead of Integer? 
	private int xPosCurret, yPosCurrent;
	private int xPosPrevious, yPosPrevious;
	private RunnableGame game;
	
	//TODO: remove later when RunnableGame has instance variables and getters and setters
	public int[][] gameBoardArray = {
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
			};
	
	
	public Player(int startPosX, int startPosY, RunnableGame game) {
		inventory = new ArrayList<>(); //makes sure that the inventory is empty when player is created. 
		xPosCurret = startPosX;
		yPosCurrent = startPosY;
		this.game = game; //needed to get access to gameBoard coordinates
	}
	//TODO: remove later, only for test purpose since gameBoard class is not complete. 
	public Player(int startPosX, int startPosY) {
		xPosCurret = startPosX;
		yPosCurrent = startPosY;
	}
	
	//Should this be in gameClass instead?
	public boolean validateMovement(int posX, int posY) {
		int gameX = gameBoardArray[posX][posY]; //value of current tile
		
	boolean okMove = (gameX != 1) ?  true : false; // if value of tile is not 1 (wall) then it's ok to move to that tile
		return okMove;
	}
	//Should this be in gameClass instead?
	public void doMove(int posX, int posY) {
		if(validateMovement(posX, posY)) {
			//TODO: implement call to gameboard to move player
			//CollisionAfterMovement();
		}
	}
	
	public void CollisionAfterMovement() {
		//TODO: check number of current tile, if laser - game over, if key - add to inventory etc...
	}

}
