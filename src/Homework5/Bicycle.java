package Homework5;

public class Bicycle extends Transport {

    private final int topSpeed = 35;
    private int price;

    public Bicycle(int countOfWheels, boolean hasEngine) {
        super(countOfWheels, hasEngine);
    }

    public boolean canMove() {
        return getCountOfWheels() == 2;
    }

    public int getTopSpeed() {
        return this.topSpeed;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public float distance (int time) {
        if (!canMove()) {
            return 0f;
        } else {
            return (float) getTopSpeed() / time;
        }
    }


}
