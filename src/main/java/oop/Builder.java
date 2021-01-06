package oop;

public class Builder extends Engineer {
    private String specialisation;

    public Builder(String name, String surname,
                   String education, String birthday,
                   String description, String specialisation) {
        super(name, surname, education, birthday, description);
        this.specialisation = specialisation;
    }

    public void makeHouse() {
    }
}