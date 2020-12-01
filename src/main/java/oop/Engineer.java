package oop;

public class Engineer extends Profession {
    String description;

    public void Engineer(String name, String surname, String education, String birthday, String description) {
        Profession(name, surname, education, birthday);
        this.description = description;
    }

    public void makeHouse() {

    }
}
