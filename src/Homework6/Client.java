package Homework6;

public class Client extends Person implements Printable, SeasonHandler {

    private int countOfMoney;
    private float height;

    public Client(String name, String surname, int age) {
        super(name, surname, age);
    }

    public Client(String name, String surname, int age, int countOfMoney, float height) {
        super(name, surname, age);
        this.countOfMoney = countOfMoney;
        this.height = height;
    }

    @Override
    public void print() {
        System.out.println("Поля класса " + this.getClass() + ": " + getName() + " " + getSurname() + " " + getAge() + " " + getCountOfMoney() + " " + getHeight());
    }

    @Override
    public void colorOfSeasonPrint(String season) {
        SeasonHandler.super.colorOfSeasonPrint(season);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    public int getCountOfMoney() {
        return countOfMoney;
    }

    public float getHeight() {
        return height;
    }
}
