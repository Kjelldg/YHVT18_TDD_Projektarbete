package Items;

public class Laser {

    private Boolean isActivated = false;

    public Laser() { }

    public void activate() {
        isActivated = true;
    }

    public void deactivate() {
        isActivated = false;
    }

    public boolean getIsActivated() {
        return isActivated;
    }

}
