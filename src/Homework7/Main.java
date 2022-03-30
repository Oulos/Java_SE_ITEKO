package Homework7;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        ManaPotion mp = new ManaPotion(Color.BLUE);
        HealPotion hp = new HealPotion(Color.RED);
        Hud<ManaPotion> hudRight = new Hud<>(mp);
        Hud<HealPotion> hudLeft = new Hud<>(hp);

    }

}
