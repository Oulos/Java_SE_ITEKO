package Homework5;

public class Car extends Transport {

    private final int topSpeed = 200;
    private int price;

    public Car(int countOfWheels, boolean hasEngine) {
        super(countOfWheels, hasEngine);
    }

    public boolean canMove() {
        return getCountOfWheels() == 4 && isHasEngine();
    }

    public Car(int countOfWheels, boolean hasEngine, int price) {
        super(countOfWheels, hasEngine);
        this.price = price;
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
