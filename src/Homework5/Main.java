package Homework5;

public class Main {

    public static void main(String[] args) {

        Car normalCar = new Car(4, true);
        Car brokenCar = new Car(4, false);
        Bicycle usualBicycle = new Bicycle(2, false);
        System.out.println(cruisingRange(normalCar, 5));
        System.out.println(cruisingRange(brokenCar, 2));
        normalCar.setHasEngine(false);
        System.out.println(cruisingRange(normalCar, 5));

    }

    public static float cruisingRange (Transport transport, int hours) {
        return transport.distance(hours);
    }

}
