package Tests;
import Items.Coin;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CoinTest {

    @Test
    public void coin_testPickupMethod() {
        Coin c = new Coin();
        c.pickup();
        assertEquals(true, c.isPickedUp());
    }

    @Test
    public void coin_testValueRange() {
        Coin c = new Coin();
        if(c.getValue() < 1 || c.getValue() > 10) {
            fail("Coin generated too high/low of a value.");
        }
    }
}
