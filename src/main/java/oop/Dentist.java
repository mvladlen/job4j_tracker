package oop;

public class Dentist extends Doctor {
    int priceOfReview;

    public void Dentist(String name, String surname, String education, String birthday, String specialisation) {
        Doctor(name, surname, education, birthday, specialisation);
    }

    public void makeReview() {
    }
}
