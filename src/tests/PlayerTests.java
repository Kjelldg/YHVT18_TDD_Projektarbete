package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import player.Player;

class PlayerTests {

	@Test
	void playerShouldSpawnAtRowOneOfGameBoard() {
		fail("Not implemented");

	}
	
	@Test
	void playerShouldNotBeAbleToMoveOnWallIndexes() {
		//fail("Not yet implemented");
		Player player = new Player(0, 2);
		boolean ok = player.validateMovement(0, 2);
		
		assertFalse(ok);
	}
	
	@Test
	void gameShouldDetectCollisionBetweenPlayerANdOtherObjects() {
		fail("To be implemented");
		//Should check for other numbers than 1 || 0 in arrayIndex, then throw collison. 
	}

}
