import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Mechanic Janusz;
    private Mechanic Marian;
    private Mechanic Adrian;
    private Scanner input = new Scanner(System.in);
    private List<Cars> carsToBuy = new ArrayList<>();
    public Game(){
        this.Janusz = new Mechanic("Janusz",1000.0,100,0);
        this.Marian = new Mechanic("Marian",500.0,90,0);
        this.Adrian = new Mechanic("Adrian",250.0,80,2);
        for(int i=0;i<20;i++) {
            RandomCarGenerator car = new RandomCarGenerator();
            this.carsToBuy.add(car.generateRandomCar());
        }
        this.menuStart();
    }


    public void menuStart(){
        System.out.println("GRA AUTOHANDEL");
        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("1.Pokaż listę samochodów do kupienia");
        int number = this.input.nextInt();
        switch (number){
            case 1 -> listaSamochodow();
        }
    }

    private void listaSamochodow() {
        for (int i = 0; i < carsToBuy.size(); i++) {
            System.out.println(i+1+". "+carsToBuy.get(i));
        }
        System.out.println("1.Kup samochód.");
        System.out.println("2.Wyjdź.");
        int number = this.input.nextInt();
        switch (number){
            case 2 -> menuStart();
        }
    }
}
