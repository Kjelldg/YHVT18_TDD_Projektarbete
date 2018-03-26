package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

// 0=floor, 1=wall, 2=player, 3=treasure, 4=door, 5=laser
public class TileType {

	String assetPath = System.getProperty("user.dir") + "\\assets\\";
	private BufferedImage floor;
	private BufferedImage wall;
	private BufferedImage player;
	private BufferedImage treasure;
	private BufferedImage laser;
	private BufferedImage door;
	private int imageWidth = 16;
	private int imageHeight = 16;

	public TileType() {
		try {
			this.floor = ImageIO.read(new File(assetPath + "floor.png"));
			this.wall = ImageIO.read(new File(assetPath + "wall.png"));
			this.player = ImageIO.read(new File(assetPath + "player.png"));
			this.treasure = ImageIO.read(new File(assetPath + "treasure.png"));
			this.laser = ImageIO.read(new File(assetPath + "laser.png"));
			this.door = ImageIO.read(new File(assetPath + "door.png"));

		} catch (IOException e) {
			System.err.println("ERROR: Could not load assets.");
		}
	}

	public BufferedImage getImage(int id) throws InvalidIdException {
		switch (id) {
		case 0:
			return floor;
		case 1:
			return wall;
		case 2:
			return player;
		case 3:
			return treasure;
		case 4:
			return door;
		case 5:
			return laser;
		}
		throw new InvalidIdException();
	}

	public List<Tile> generateTiles(int[][] gameboard) throws TileType.InvalidIdException {
		List<Tile> tileList = new ArrayList<>();
		int[] pointer = { 0, 0 };

		for (int y = 0; y < gameboard.length; y++) {
			for (int x = 0; x < gameboard[y].length; x++) {
				tileList.add(new Tile(pointer[0], pointer[1], getImage(gameboard[y][x])));
				pointer[0] += imageWidth;
			}
			pointer[0] = 0;
			pointer[1] += imageHeight;
		}

		return tileList;

	}

	public class InvalidIdException extends Exception {

	}
}
