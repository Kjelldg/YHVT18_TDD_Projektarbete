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
	//TODO: Arrays are not defined as we thought. Y is horizontal, not vertical
	@Test
	void playerMovementUpShouldNotWork() {
		Player player = new Player(1,1, new RunnableGame());
		boolean moveOkUp = player.doMove(1, 1, "UP"); //would move to wall tile
		
		assertEquals(false, moveOkUp);
	}
	@Test
	void playerMovementDownShouldNotWork() {
		Player player = new Player(1,1, new RunnableGame());
		boolean moveOkDown = player.doMove(2, 8, "DOWN"); //would move to wall tile
		
		assertEquals(false, moveOkDown);

	}
	
	@Test
	void playerMovementLeftShouldNotWork() {
		Player player = new Player(1,1, new RunnableGame());

		boolean moveOkLeft = player.doMove(1, 1, "LEFT"); //would move to wall tile
		
		assertEquals(false, moveOkLeft);
		
	}
	@Test
	void playerMovementRightShouldNotWork() {
		Player player = new Player(1,1, new RunnableGame());

		boolean moveOkRight = player.doMove(8, 1, "RIGHT"); //would move to wall tile
		
		assertEquals(false, moveOkRight);
		
	}
	
	@Test
	void gameShouldDetectCollisionBetweenPlayerTreasure() {
		Player player = new Player(1, 1, new RunnableGame());
		
		boolean isColliding = player.CollisionAfterMovement(2,1);
		
		assertEquals(true, isColliding);

	}
	@Test
	void gameShouldDetectCollisionBetweenPlayerLaser() {
		Player player = new Player(1, 1, new RunnableGame());
		
		boolean isColliding = player.CollisionAfterMovement(3,1);
		
		assertEquals(true, isColliding);

	}

}
