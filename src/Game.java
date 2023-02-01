import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);
    private List<Cars> carsToBuy = new ArrayList<>();
    private Double costRepair;

    public Game(){

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
        System.out.println("5.Napraw samochód jeśli jest zepsuty.");
        if (input.hasNextInt()) {
            Integer number = this.input.nextInt();
            switch (number){
                case 0 -> System.exit(0);
                case 1 -> listaSamochodow();
                case 2 -> checkGarage();
                case 3 -> checkAmountOfCash();
                case 4 -> transactionHistory();
                case 5 -> choseCarToFix();
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
    private void choseCarToFix(){
        if(Player.garageEmpty()==false){
            Player.getCarsToRepair();
            System.out.println("wpisz numer samochodu, który chcesz naprawić: ");
            Integer number = this.input.nextInt();
            if(Player.garage.get(number-1).damaged != "WITHOUT"){
                repairCar(number - 1);
            }
            else {
                System.out.println("Ten samochód jest sprawny.");
                menuStart();
            }
        }
        else {
            System.out.println("Brak samochodów do naprawy.");
            menuStart();
        }
    }
    private void repairCar(Integer carNumber){
        System.out.println("Wybierz swojego mechanika:");
        System.out.println("1.Janusz");
        System.out.println("Masz 100% pewność, że naprawi i nic nie zniszczy poza naprawą, koszt usługi 1000zł + dodatkowe koszty związane z marką oraz częściami do pojazdu");
        System.out.println("2.Marian");
        System.out.println("Masz 90% pewność, że naprawi,w przypadku braku możliwości naprawy Mariana samochód w celu naprawy będzie musiał trafić do Janusza, koszt usługi 500zł + dodatkowe koszty związane z marką oraz częściami do pojazdu");
        System.out.println("3.Adrian");
        System.out.println("Masz 80% pewność, że naprawi, ale jest 2% szansy na zainstnienie innych uszkodzeń, koszt usługi 700zł + dodatkowe koszty związane z marką oraz częściami do pojazdu");
        System.out.println("4.Wyjdź do menu.");
        if (input.hasNextInt()) {
            Integer number = this.input.nextInt();
            switch (number){
                case 1 -> mechanicWork("Janusz",carNumber);
                case 2 -> mechanicWork("Marian",carNumber);
                case 3 -> mechanicWork("Adrian",carNumber);
                case 4 -> menuStart();
                default -> choseCarToFix();
            }
        }
        else {
            System.out.println("Wprowadzony symbol nie jest liczbą");
            new Game();
        }
    }
    private void mechanicWork(String mechanicFirstName,Integer carNumber){
        if(Player.getCar(carNumber).damaged.contains("+")){
            System.out.println("Przykro mi uszkodzenia auta są zbyt poważne samochód musi trafić do Janusza");
            mechanicFirstName = "Janusz";
            Player.getCar(carNumber).damaged=Player.getCar(carNumber).damaged.substring(0,Player.getCar(carNumber).damaged.length()-1);
        }
        Object obj = CarParts.costRepairOfParts(Player.getCar(carNumber).damaged,Player.getCar(carNumber).value);
        if(CarParts.costRepairOfParts(Player.getCar(carNumber).damaged,Player.getCar(carNumber).value) instanceof Double){
            String str = obj.toString();
            double valueParts = Double.valueOf(str).doubleValue();
            double valueRepair = Cars.costCarRepair(Player.getCar(carNumber).producer,Player.getCar(carNumber).value);
            if(mechanicFirstName=="Janusz"){
                costRepair=valueRepair+ valueParts+1000.0;
            }
            else if(mechanicFirstName=="Marian"){
                costRepair=valueRepair+ valueParts+500.0;

            }
            else {
                costRepair=valueRepair+ valueParts+700.0;
            }
            System.out.println("Cena "+Math.round(costRepair));
            System.out.println("Naprawiamy czy odpuszczamy?");
            System.out.println("1.Napraw.");
            System.out.println("2.Wyjście do menu.");
            if (input.hasNextInt()) {
                Integer number = this.input.nextInt();
                switch (number){
                    case 1 -> repairDamage(carNumber,costRepair,mechanicFirstName);
                    case 2 -> menuStart();
                }
            }
            else {
                System.out.println("Wprowadzony symbol nie jest liczbą");
                new Game();
            }
        }
        else{
            System.out.println(obj);
            menuStart();
        }
    }
    private void repairDamage(Integer carNumber,Double costRepair,String mechanicFirstName){
        if(Player.getMoney()>=costRepair){
            Repairs.carRepair(Player.getCar(carNumber),mechanicFirstName);
            Player.withdrawMoney(costRepair,this.carsToBuy.get(carNumber).model);
            System.out.println("Samochód został naprawiony");
            menuStart();
        }
    }
}
