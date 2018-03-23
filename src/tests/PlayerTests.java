package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import gameplay.RunnableGame;
import player.Player;
import player.Player.movementType;

class PlayerTests {

	@Test
	void playerShouldSpawnAtRowOneOfGameBoard() {
		Player player = new Player(1,8,new RunnableGame());
		boolean ok = player.validateMovement(1, 8, movementType.SPAWN);
		
		assertTrue(ok); //Should return true if player is spawned @ row 1 in column 1-9

	}
	
	@Test
	void playerShouldNotBeAbleToMoveOnWallIndexes() {
		Player player = new Player(1, 5, new RunnableGame());
		boolean ok = player.validateMovement(1, 1, movementType.MOVEMENT);
		
		assertFalse(ok); //pass if value is one (1)
	}
	
	@Test
	void gameShouldDetectCollisionBetweenPlayerANdOtherObjects() {
		fail("To be implemented");
		//Should check for other numbers than 1 || 0 in arrayIndex, then throw collison. 
	}

}
