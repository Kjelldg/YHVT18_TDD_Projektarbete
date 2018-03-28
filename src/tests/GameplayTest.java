package tests;

import static org.junit.Assert.assertEquals;
import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.jupiter.api.*;

import gameplay.GameplayLogic;

class GameplayTest {

    public static GameplayLogic game;
    public static LocalTime now;

    public static ArrayList<Integer> treasureOne = new ArrayList<Integer>();
    public static ArrayList<Integer> treasureTwo = new ArrayList<Integer>();
    public static ArrayList<Integer> treasureThree = new ArrayList<Integer>();

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

        LocalTime timeOne = LocalTime.parse("20:08");
        LocalTime timeTwo = LocalTime.parse("12:45");

        boolean testOne = game.isActive(timeOne);
        boolean testTwo = game.isActive(timeTwo);

        assertEquals(true, testOne);
        assertEquals(false, testTwo);
    }

    @Test
    void testCheckGold_checkGoldBasedOnTreasures() {

        //Create array list for each type of treasure.
        //Worth is 1, 2 and 3 gold.
        //In this test case we have picked up:
        //One 1g-treasure
        //Three 2g-treasures
        //Two 3g-treasures

        treasureOne.add(1);
        treasureTwo.add(2); treasureTwo.add(2); treasureTwo.add(2);
        treasureThree.add(3); treasureThree.add(3);

        int gold = game.checkGold(treasureOne, treasureTwo, treasureThree);

        assertEquals(13, gold);
    }

    @Test
    void testCheckTreasure_validateTreasureAddToArray() {

        //Validate treasure based on character.
        //Add value to correct array list.

        game.checkTreasure(2);
        int expected = game.treasureTwo.size();

        assertEquals(1, expected);
    }


}


