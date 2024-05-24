package Entity;

public class Lift {
    private int liftNumber;
    private boolean isDown;
    private int floorNumber;

    public Lift(int liftNumber, boolean isDown) {
        this.liftNumber = liftNumber;
        this.isDown = isDown;
        this.floorNumber = 0;
    }

    public int getLiftNumber() {
        return liftNumber;
    }

    public void setLiftNumber(int liftNumber) {
        this.liftNumber = liftNumber;
    }

    public boolean isDown() {
        return isDown;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
