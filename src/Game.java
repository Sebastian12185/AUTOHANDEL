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
        createListCars();
        this.menuStart();
    }


    public void menuStart(){
        System.out.println("GRA AUTOHANDEL");
        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("0.Zakończ program.");
        System.out.println("1.Pokaż listę samochodów do kupienia.");
        System.out.println("2.Pokaż samochody w swoim garażu.");
        System.out.println("3.Pokaż stan gtówki.");
        System.out.println("4.Pokaż historię tranzakcji.");
        if (input.hasNextInt()) {
            Integer number = this.input.nextInt();
            switch (number){
                case 0 -> System.exit(0);
                case 1 -> listaSamochodow();
                case 2 -> checkGarage();
                case 3 -> checkAmountOfCash();
                case 4 -> transactionHistory();
                default -> menuStart();
            }
        }
        else {
            System.out.println("Wprowadzony symbol nie jest liczbą");
            new Game();
        }

    }

    private void listaSamochodow() {

        for (int i = 0; i < carsToBuy.size(); i++) {
            System.out.println(i+1+". "+carsToBuy.get(i));
        }
        System.out.println("1.Kup samochód.");
        System.out.println("2.Wyjdź.");
        if (input.hasNextInt()) {
            Integer number = this.input.nextInt();
            switch (number){
            case 1 -> buyCar();
            case 2 -> menuStart();
            default -> listaSamochodow();
            }
        }
        else {
            System.out.println("Wprowadzony symbol nie jest liczbą");
            new Game();
        }
    }
    private void buyCar(){
        System.out.println("Zakupując samochód z listy akcpetujesz wartość podatku wynoszącego 2% wartości samochodu oraz koszt umycia przed zakupem");
        System.out.println("1.Podaj numer samochodu z listy.");
        Integer number = this.input.nextInt();
        Double additionalCosts = this.carsToBuy.get(number-1).value * 0.02+10;
        if(this.carsToBuy.get(number-1).value+additionalCosts<=Player.getMoney()) {
            System.out.println("Pomyślnie zakupiono samochód");
            Player.addToGarage(this.carsToBuy.get(number - 1));
            Player.withdrawMoney(this.carsToBuy.get(number-1).value,this.carsToBuy.get(number-1).model);
            carsToBuy.clear();
            createListCars();
            menuStart();
        }
        else{
            System.out.println("Nie masz wystarczającej ilości gotówki");
            menuStart();
        }
    }
    private void createListCars(){
        for(int i=0;i<20;i++) {
            RandomCarGenerator car = new RandomCarGenerator();
            this.carsToBuy.add(car.generateRandomCar());
        }
    }
    private void checkGarage(){
        if(Player.garageEmpty()==false){
            Player.getGarage();
            menuStart();
        }
        else {
            System.out.println("Twój garaż jest pusty.");
            menuStart();
        }
    }
    private void checkAmountOfCash(){
        System.out.println(Player.getMoney());
        menuStart();
    }
    private void transactionHistory(){
        if(Player.tranzationsEmpty()==false){
            Player.getTranzations();
            menuStart();
        }
        else {
            System.out.println("Brak operacji na koncie");
            menuStart();
        }
    }
}
