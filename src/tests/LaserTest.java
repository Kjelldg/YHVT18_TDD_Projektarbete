package tests;

import Items.Laser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class LaserTest {

    @Test
    public void laser_activationTest() {
        Laser l = new Laser();
        l.activate();
        Assert.assertEquals(true, l.getIsActivated());
    }
}
