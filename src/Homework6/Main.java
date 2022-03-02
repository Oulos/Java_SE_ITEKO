package Homework6;

public class Main {

    public static void main(String[] args) {
        Employee emp = new Employee("John", "Smith", 27, "Manager", 1000);
        emp.print();
        emp.colorOfSeasonPrint("Autumn");
        Client cl = new Client("Mary", "Goldberg", 32);
        cl.print();
        cl.colorOfSeasonPrint("Winter");

    }

}
