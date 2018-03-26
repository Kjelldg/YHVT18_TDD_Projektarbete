package GUI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Window extends JFrame {

	private List<Tile> tileArray = new ArrayList();
	private TileType tileType = new TileType();

	public void paint(Graphics g) {
		for (Tile tile : tileArray) {
			g.drawImage(tile.getImage(), tile.getX(), tile.getY() + 26, null);
		}
	}

	public Window() {
		setLayout(new BorderLayout());
		setSize(200, 200);
		setTitle("Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	public void update(int[][] gameboard) throws TileType.InvalidIdException {
		tileArray = tileType.generateTiles(gameboard);
		repaint();
	}

}
