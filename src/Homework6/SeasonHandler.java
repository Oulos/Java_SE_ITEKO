package Homework6;

public interface SeasonHandler {

    default void colorOfSeasonPrint(String season) {

        System.out.println("Сейчас " + season + " " + Season.valueOf(season).getColor());

    }

}
