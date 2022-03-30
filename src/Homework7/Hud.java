package Homework7;

public class Hud<T extends Usable> {

    private T potion;

    public Hud(T potion) {
        this.potion = potion;
    }

    public void drop(){
        this.potion = null;
    }

    public void use() {
        this.potion.use();
    }

}
