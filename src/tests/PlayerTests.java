package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import player.Player;
import player.Player.movementType;

class PlayerTests {

	/*@Test
	void playerShouldSpawnAtRowOneOfGameBoard() {
		fail("Not implemented");

	}
	
	@Test
	void playerShouldNotBeAbleToMoveOnWallIndexes() {
		//fail("Not yet implemented");
		Player player = new Player(0, 2);
		boolean ok = player.validateMovement(0, 2, movementType.MOVEMENT);
		
		assertFalse(ok);
	}
	
	@Test
	void gameShouldDetectCollisionBetweenPlayerANdOtherObjects() {
		fail("To be implemented");
		//Should check for other numbers than 1 || 0 in arrayIndex, then throw collison. 
	}*/
	@Test
	void playerShouldSpawnAtRowOneOfGameBoard() {
		Player player = new Player(1,8);
		boolean ok = player.validateMovement(1, 1, movementType.SPAWN);
		
		assertTrue(ok); //Should return true if player is spawned @ row 1 in column 1-9

	}
	
	@Test
	void playerShouldNotBeAbleToMoveOnWallIndexes() {
		Player player = new Player(1, 5);
		boolean ok = player.validateMovement(1, 0, movementType.MOVEMENT);
		
		assertFalse(ok); //pass if value is one (1)
	}
	
	@Test
	void playerMovementUpShouldNotWork() {
		Player player = new Player(1,1);
		boolean moveOkUp = player.doMove(0, 1, "UP"); //would move to wall tile
		
		assertEquals(false, moveOkUp);
	}
	@Test
	void playerMovementDownShouldNotWork() {
		Player player = new Player(1,1);
		boolean moveOkDown = player.doMove(0, 0, "DOWN"); //would move to wall tile
		
		assertEquals(false, moveOkDown);

	}
	
	@Test
	void playerMovementLeftShouldNotWork() {
		Player player = new Player(1,1);

		boolean moveOkLeft = player.doMove(0, 0, "LEFT"); //would move to wall tile
		
		assertEquals(false, moveOkLeft);
		
	}
	@Test
	void playerMovementRightShouldNotWork() {
		Player player = new Player(1,1);

		boolean moveOkRight = player.doMove(0, 9, "RIGHT"); //would move to wall tile
		
		assertEquals(false, moveOkRight);
		
	}
	
	@Test
	void gameShouldDetectCollisionBetweenPlayerTreasure() {
		Player player = new Player(1, 1);
		boolean isColliding = player.CollisionAfterMovement(0,1);
		assertEquals(true, isColliding);

	}
	@Test
	void gameShouldDetectCollisionBetweenPlayerLaser() {
		Player player = new Player(1, 1);
		boolean isColliding = player.CollisionAfterMovement(0,2);
		assertEquals(true, isColliding);

	}

}
