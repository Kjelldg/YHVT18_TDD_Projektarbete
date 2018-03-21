package Items;

public class Wall {
    private boolean isCollidable=true;

    public Wall() { }
    public boolean isCollidable(){
        return isCollidable;
    }

    public void setCollidable(boolean collidable) {
        isCollidable = collidable;
    }
}
