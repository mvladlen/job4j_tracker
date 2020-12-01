package oop;

public class Programmer extends Engineer {
    String[] languages;

    public void Engineer(String name, String surname, String education, String birthday, String description, String[] languages) {
        Engineer(name, surname, education, birthday, description);
        this.languages = languages;
    }

    public void reviewCode() {

    }
}
