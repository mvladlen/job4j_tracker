package oop;

public class Builder extends Engineer {
    String specialisation;

    public void Builder(String name, String surname, String education, String birthday, String description, String specialisation) {
        Engineer(name, surname, education, birthday, description);
        this.specialisation = specialisation;
    }

    ;

    public void makeHouse() {

    }
}
