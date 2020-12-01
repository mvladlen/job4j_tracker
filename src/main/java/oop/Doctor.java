package oop;

public class Doctor extends Profession {
    String specialisation;

    public void Doctor(String name, String surname, String education, String birthday, String specialisation) {
        Profession(name, surname, education, birthday);
        this.specialisation = specialisation;
    }

    public void heal() {
    }
}
