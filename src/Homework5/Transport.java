package Homework5;

public abstract class Transport {

    private int countOfWheels;
    private boolean hasEngine;

    public Transport(int countOfWheels, boolean hasEngine) {
        this.countOfWheels = countOfWheels;
        this.hasEngine = hasEngine;
    }

    public int getCountOfWheels() {
        return countOfWheels;
    }

    public void setCountOfWheels(int countOfWheels) {
        this.countOfWheels = countOfWheels;
    }

    public boolean isHasEngine() {
        return hasEngine;
    }

    public void setHasEngine(boolean hasEngine) {
        this.hasEngine = hasEngine;
    }

    public abstract float distance(int time);
}
