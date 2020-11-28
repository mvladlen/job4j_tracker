package oop;

public class Battery {
    private int load;

    public void setLoad(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        this.load+=another.load;
        another.load=0;
    }

}
