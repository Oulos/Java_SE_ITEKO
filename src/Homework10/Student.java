package Homework10;

public class Student {

    private FullName fullName;
    private int age;
    private int grade;
    private Subject favoriteSubject;

    public Student(FullName fullName, int age, int grade, Subject favoriteSubject) {
        this.fullName = fullName;
        this.age = age;
        this.grade = grade;
        this.favoriteSubject = favoriteSubject;
    }

    public FullName getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    public Subject getFavoriteSubject() {
        return favoriteSubject;
    }

    @Override
    public String toString() {
        return "Student: " + fullName.toString();
    }
}
