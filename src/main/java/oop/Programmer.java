package oop;

public class Programmer extends Engineer {
    private String[] languages;

    public Programmer(String name, String surname,
                      String education, String birthday,
                      String description, String[] languages) {
        super(name, surname, education, birthday, description);
        this.languages = languages;
    }

    public void reviewCode() {

    }
}
