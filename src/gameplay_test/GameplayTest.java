package gameplay_test;

import static org.junit.Assert.assertEquals;
import java.time.LocalTime;
import org.junit.jupiter.api.*;

import gameplay_logic.GameplayLogic;

class GameplayTest {

	public static GameplayLogic game;
	public static LocalTime now;
	public static int[] treasureOne;
	public static int[] treasureTwo;
	public static int[] treasureThree;
	
	@BeforeAll
	static void Init() {
		game = new GameplayLogic();
		now = LocalTime.now();
	}
	
	@Test
	void testOpenDoor_checkEntryBasedOnTreasures() {
		
		//Test with 10 or higher passes if expected is true.
		//Test with 9 or lower passes if expected is false.
		//Both fails if expected is set to the opposite.
		
		boolean testOne = game.openDoor(5);
		boolean testTwo = game.openDoor(10);
		
		assertEquals(false, testOne);
		assertEquals(true, testTwo);
		
	}
	
	
	@Test
	void testIsActive_checkIfCurrentTimeIsWithinActiveHours() {
		
		//Test one with a set time that is in range of active hours.
		//Test two was done with local time outside of active hours.
		
		LocalTime time = LocalTime.parse("20:08");
		
		boolean testOne = game.isActive(time);
		boolean testTwo = game.isActive(now);
		
		assertEquals(true, testOne);
		assertEquals(false, testTwo);
	}
	
	@Test
	void testCheckGold_checkGoldBasedOnTreasures() {
		
		//Create arrays for each type of treasure.
		//Worth is 1, 2 and 3 gold.
		//In this test case we have picked up:
		//One 1g-treasure
		//Three 2g-treasures
		//Two 3g-treasures
		
		treasureOne = new int[]{1};
		treasureTwo = new int[]{2, 2, 2};
		treasureThree = new int[]{3, 3};
		
		int gold = game.checkGold(treasureOne, treasureTwo, treasureThree);
		
		assertEquals(13, gold);
	}
	

}


