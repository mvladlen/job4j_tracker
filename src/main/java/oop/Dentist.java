package oop;

public class Dentist extends Doctor {
    private int priceOfReview;

    public Dentist(String name, String surname,
                   String education, String birthday,
                   String specialisation) {
        super(name, surname, education, birthday, specialisation);
        this.priceOfReview = 100;
    }

    public void makeReview() {
    }
}
