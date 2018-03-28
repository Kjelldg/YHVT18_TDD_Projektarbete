package gameplay;

// Class for the Gameboard and it's getters and setters. 
public class Gameboard {

	int[][] gameBoardArray ={ 	{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
								{ 1, 3, 1, 0, 4, 0, 0, 1, 0, 1 },
								{ 1, 3, 1, 0, 0, 0, 0, 1, 0, 1 },
								{ 1, 0, 1, 1, 0, 1, 1, 1, 0, 1 },
								{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
								{ 1, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
								{ 1, 3, 3, 0, 1, 0, 0, 0, 0, 1 },
								{ 1, 3, 0, 0, 0, 0, 0, 0, 0, 1 },
								{ 1, 0, 0, 0, 1, 0, 0, 0, 2, 1 },
								{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

	public int[][] getGameBoardArray() {
		return gameBoardArray;
	}

	public void setGameBoardArray(int[][] gameBoardArray) {
		this.gameBoardArray = gameBoardArray;
	}
	
	public int getGameBoardPosistion(int posY, int posX) {
		return gameBoardArray[posY][posX];
	}

}
