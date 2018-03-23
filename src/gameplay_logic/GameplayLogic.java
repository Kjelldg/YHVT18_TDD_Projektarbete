package gameplay_logic;

import java.time.LocalTime;

public class GameplayLogic {

	public boolean openDoor(int treasures) {
		
		//If treasures is 10 or higher, you can enter.
		//If treasures is below 10, you are denied.
		
		if(treasures >= 10) {
			return true;
		}
		return false;
	}

	public boolean isActive(LocalTime now) {
		
		//Create start and end-time for lasers.
		//At 18:01 they'll be active.
		//At 07:59 they'll still be active, but 07:59:01 they'll be turned off.
		//Between 08:00-18:00 the museum is open and no lasers will be active.
		
		LocalTime open = LocalTime.parse("18:01");
		LocalTime closed = LocalTime.parse("07:59");
		
		if(now.isAfter(open) || now.isBefore(closed)) {
			return true;
			
		} else if(now.equals(open) || now.equals(closed)) {
			return true;
			
		}
		return false;
	}

	public int checkGold(int[] treasureOne, int[] treasureTwo, int[] treasureThree) {
		
		//Count each array that hold treasures.
		//Calculate the value of picked up treasures.
		//Return total amount of gold.
		
		int gold = 0;
		int countOne = 0, countTwo = 0, countThree = 0;
		
		for(int i = 0; i <= treasureOne.length; i++) {
			countOne = i;
				
			
			for(int j = 0; j <= treasureTwo.length; j++) {	
				countTwo = j;
				}
			
			for(int k = 0; k <= treasureThree.length; k++) {
				countThree = k;
				}
		}
		
		countOne = countOne*1;
		countTwo = countTwo*2;
		countThree = countThree*3;
		
		gold = countOne+countTwo+countThree;
		
		return gold;
	}

}
