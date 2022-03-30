package Homework7;

import java.awt.*;
import java.util.Objects;

public class HealPotion extends Potion implements Usable{

    private final Color defaultColor = Color.RED;

    public HealPotion(Color color) {
        super(color);
    }

    @Override
    public void use() {
        System.out.println("Health are increased!");
        this.setStatus(Status.Empty);
    }

    @Override
    public Potion mix(Potion potion) {
        if (potion.getStatus() != Status.Empty) {
            Color colorNewPotion = new Color(defaultColor.getRGB() + potion.getColor());
            return new Potion(colorNewPotion);
        } else {
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealPotion that = (HealPotion) o;
        return defaultColor.equals(that.defaultColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultColor);
    }

    @Override
    public String toString() {
        return "HealPotion{" +
                "defaultColor=" + defaultColor +
                '}';
    }
}
