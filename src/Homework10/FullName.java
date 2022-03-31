package Homework10;

public class FullName {

    private String surname;
    private String name;
    private String patronymic;

    public FullName(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        return "Фамилия: " + surname + ", Имя: " + name + ", Отчество: " + patronymic;
    }
}
