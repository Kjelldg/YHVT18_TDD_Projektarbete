package GUI;

import java.awt.image.BufferedImage;

public class Tile {

    private int x;
    private int y;
    private BufferedImage image;

    public Tile(int x, int y, BufferedImage image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public BufferedImage getImage() {
        return image;
    }
}
