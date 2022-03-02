package Homework6;

public class Employee extends Person implements Printable, SeasonHandler {

    private int salary;
    private String post;

    public Employee(String name, String surname, int age) {
        super(name, surname, age);
    }

    public Employee(String name, String surname, int age, String post, int salary) {
        super(name, surname, age);
        this.post = post;
        this.salary = salary;
    }

    @Override
    public void print() {
        System.out.println("Поля класса " + this.getClass() + ": " + getName() + " " + getSurname() + " " + getAge() + " " + getPost() + " " + getSalary());
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

    public int getSalary() {
        return salary;
    }

    public String getPost() {
        return post;
    }
}
