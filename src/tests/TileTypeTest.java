package tests;

import GUI.TileType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.awt.image.BufferedImage;

public class TileTypeTest {

    TileType tileType;
    @Before public void init() {
        tileType = new TileType();
    }

    @Test
    public void tileType_getImageBasedOnId() {
        int id = 2;
        try {
            BufferedImage bi = tileType.getImage(id);
            Assert.assertEquals(bi, tileType.player);
        } catch (TileType.InvalidIdException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = TileType.InvalidIdException.class)
    public void tileType_invalidIdExceptionWhenGettingImage() {
        int id = 10;
        try {
            BufferedImage bi = tileType.getImage(id);
            Assert.assertEquals(bi, tileType.player);
        } catch (TileType.InvalidIdException e) {
            e.printStackTrace();
        }
    }
}
