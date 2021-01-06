package oop;

public class Doctor extends Profession {
    private String specialisation;

    public Doctor(String name, String surname,
                  String education, String birthday,
                  String specialisation) {
        super(name, surname, education, birthday);
        this.specialisation = specialisation;
    }

    public void heal() {
    }
}
