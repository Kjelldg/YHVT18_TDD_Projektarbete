package Items;

import java.util.Random;

public class Coin {

    private int value;
    private boolean isPickedUp;

    public Coin() {
        this.isPickedUp = false;
        Random r = new Random();
        this.value = r.nextInt(9) + 1;
    }

    public boolean isPickedUp() {
        return isPickedUp;
    }

    public void pickup() {
        isPickedUp = true;
    }

    public int getValue() {
        return value;
    }


}
