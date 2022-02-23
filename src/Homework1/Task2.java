package Homework1;

/**
 * Необходимо вывести форматированную информацию с переменными в зависимости от варианта
 * (должны присутствовать типы: String/char, byte/short/int/long, float/double)
 */

public class Task2 {
    public static void main (String[] args) {
        String city = "Detroit";
        int population = 674841;
        int unemployed = 80;
        char percent = 37;
        System.out.printf("Город - %s, население - %d человек, безработных - %d%c\n", city, population, unemployed, percent);

        char section = 69;
        int place = 13;
        float price = 29.99f;
        System.out.printf("Секция - %c, место - %d, стоимость билета - %.2f\n", section, place, price);

        String name = "Bob";
        int age = 27;
        int growth = 181;
        System.out.printf("Имя - %s, возраст - %d, рост - %d\n", name, age, growth);

        char firstLetter = 72;
        char secondLetter = 79;
        char thirdLetter = 89;
        int number = 742;
        float weight = 1.2f;
        System.out.printf("Регистрационный номер - [%c%d%c%c], вес - %.1f тонны\n", firstLetter, number, secondLetter, thirdLetter, weight);

        String companyName = "Horns and hooves";
        long income = 1264778569;
        byte marketShare = 42;
        System.out.printf("Название компании - %s, годовой доход - %d, доля на рынке - %d%c\n", companyName, income, marketShare, percent);

        char rh = 43;
        byte bloodType = 2;
        float proportionOfPeople = 28.27f;
        System.out.printf("Резус-фактор - %c, группа крови - %d, доля людей - %.2f%c\n", rh, bloodType, proportionOfPeople, percent);

        String university = "Harvard";
        int students = 146790;
        byte expelled = 13;
        System.out.printf("Университет - %s, количество студентов - %d, из них отчислено - %d%c\n", university, students, expelled, percent);

        char movieRating = 67;
        int copies = 400000;
        byte rating = 51;
        System.out.printf("Рейтинг фильма - %c, копий продано - %d, рейтинг - %d%c\n", movieRating, copies, rating, percent);

        String brandName = "Rodenstock";
        int produced = 43873;
        byte percentageOfSales = 12;
        System.out.printf("Назване бренда - %s, произведено товара - %d, процент продаж - %d%c\n", brandName, produced, percentageOfSales, percent);

        char productCategory = 65;
        int barcode = 115580;
        int buyersOver30 = 29;
        System.out.printf("Категория товара - %s, штрих-код - %d, процент покупателей старше 30 - %d%c\n", productCategory, barcode, buyersOver30, percent);
    }
}
