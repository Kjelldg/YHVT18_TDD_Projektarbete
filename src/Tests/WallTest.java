package Tests;

import Items.Wall;
import org.junit.Assert;
import org.junit.Test;

public class WallTest {

    @Test
    public void wall_testCollisionBoolean() {
        Wall w = new Wall();
        w.setCollidable(false);

        Assert.assertEquals(false, w.isCollidable());
    }
}
