package oop;

public class Surgeon extends Doctor {
    String specialisation;

    public Surgeon(String name, String surname, String education, String birthday, String specialisation) {
        super(name, surname, education, birthday, specialisation);
    }

    public void cut() {

    }

    public void sewUp() {
    }
}
