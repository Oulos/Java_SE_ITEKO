package Homework7;

public enum Status {
    Full(1),
    Empty(0);

    private final int weight;

    Status(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
