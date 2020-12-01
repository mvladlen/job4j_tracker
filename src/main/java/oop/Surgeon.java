package oop;

public class Surgeon extends Doctor {
    String specialisation;

    public void Dentist(String name, String surname, String education, String birthday, String specialisation) {
        Doctor(name, surname, education, birthday, specialisation);
    }

    public void cut() {

    }

    public void sewUp() {
    }
}
