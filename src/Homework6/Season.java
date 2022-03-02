package Homework6;

public enum Season {
    Spring("Green"),
    Summer("Yellow"),
    Autumn("Orange"),
    Winter("White");

    private final String color;

    Season(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}
