package Homework7;

import java.awt.*;
import java.util.Objects;

public class Potion {

    private Color color;
    private Status status;

    public Potion(Color color) {
        this.color = color;
        if (color.getRGB() == Color.WHITE.getRGB()){
            this.status = Status.Empty;
        } else {
            this.status = Status.Full;
        }
    }

    public int getColor() {
        return color.getRGB();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Potion potion = (Potion) o;
        return color.equals(potion.color) && status == potion.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, status);
    }

    @Override
    public String toString() {
        return "Potion{" +
                "color=" + color +
                ", status=" + status +
                '}';
    }
}
