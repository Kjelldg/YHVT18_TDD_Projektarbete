package gameplay_test;

import static org.junit.Assert.assertEquals;
import java.time.LocalTime;
import org.junit.jupiter.api.*;

import gameplay_logic.GameplayLogic;

class GameplayTest {

	public static GameplayLogic game;
	public static LocalTime now;
	
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
	
	

}


