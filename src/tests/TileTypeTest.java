package tests;

import java.awt.image.BufferedImage;

import GUI.TileType;

public class TileTypeTest {

	TileType tileType;

	@Before
	public void init() {
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
