import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Mechanic Janusz = new Mechanic("Janusz",1000.0,100,0);
        Mechanic Marian = new Mechanic("Marian",500.0,90,0);
        Mechanic Adrian = new Mechanic("Adrian",250.0,80,2);
        List<Cars> carsToBuy = new ArrayList<>();
        for(int i=0;i<=20;i++) {
            RandomCarGenerator car = new RandomCarGenerator();
            carsToBuy.add(car.generateRandomCar());
        }
    }
}