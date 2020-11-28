package oop;

public class BallStory {

    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox alisa = new Fox();
        hare.tryEat(ball);
        wolf.tryEat(ball);
        alisa.tryEat(ball);

    }
}
