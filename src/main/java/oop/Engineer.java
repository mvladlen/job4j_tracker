package oop;

public class Engineer extends Profession {
    String description;

    public Engineer(String name, String surname, String education, String birthday, String description) {
        super(name, surname, education, birthday);
        this.description = description;
    }

    public void makeHouse() {

    }
}
