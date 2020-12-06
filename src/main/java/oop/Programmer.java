package oop;

public class Programmer extends Engineer {
    String[] languages;

    public Programmer(String name, String surname, String education, String birthday, String description, String[] languages) {
        super(name, surname, education, birthday, description);
        this.languages = languages;
    }

    public void reviewCode() {

    }
}
