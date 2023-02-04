import java.util.*;

public class Game {

    private Scanner input = new Scanner(System.in);
    private List<Cars> carsToBuy = new ArrayList<>();
    private Double costRepair;
    public Integer numberOfMoves=0;
    private static Random random = new Random();
    public Game(){
        addClientsToList(3);
        createListCars();
        this.menuStart();
    }


    public void menuStart(){
        getMoves(0);
        System.out.println(getMoves(0));
        System.out.println("GRA AUTOHANDEL");
        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("0.Zakończ program.");
        System.out.println("1.Pokaż listę samochodów do kupienia.");
        System.out.println("2.Pokaż samochody w swoim garażu.");
        System.out.println("3.Pokaż stan gtówki.");
        System.out.println("4.Pokaż historię tranzakcji.");
        System.out.println("5.Napraw samochód jeśli jest zepsuty.");
        System.out.println("6.Pokaż listę klientów.");
        System.out.println("7.Kup reklamę.");
        if (input.hasNextInt()) {
            Integer number = this.input.nextInt();
            switch (number){
                case 0 -> System.exit(0);
                case 1 -> listaSamochodow();
                case 2 -> checkGarage();
                case 3 -> checkAmountOfCash();
                case 4 -> transactionHistory();
                case 5 -> choseCarToFix();
                case 6 -> listOfClients();
                case 7 -> buyAdvertisement();
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
            getMoves(1);
            Player.addToGarage(this.carsToBuy.get(number - 1));
            Player.withdrawMoney(this.carsToBuy.get(number-1).value,this.carsToBuy.get(number-1).model, "Buy");
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
    private void addClientsToList(Integer ilosc){
            for (int i=0;i<ilosc;i++){
                RandomClientGenerator client = new RandomClientGenerator();
                    Client.clients.add(client.generateRandomClient());
        }
    }

    private void listOfClients() {
        for (int i = 0; i < Client.clients.size(); i++) {
            System.out.println(i+1+". "+Client.clients.get(i));
        }
        System.out.println("1.Wybierz klienta.");
        System.out.println("2.Wyjdź.");
        if (input.hasNextInt()) {
            Integer number = this.input.nextInt();
            switch (number){
                case 1 -> selectClient();
                default -> menuStart();
            }
        }
        else {
            System.out.println("Wprowadzony symbol nie jest liczbą");
            new Game();
        }
    }

    private void selectClient() {
        System.out.println("1.Podaj numer kleinta.");
        if (input.hasNextInt()) {
            Integer clientNumber = this.input.nextInt() - 1;
            if (Player.garageEmpty() == false) {
                for (int i = 0; i < Player.garage.size(); i++) {
                    System.out.println(Player.garage.get(i).type);
                    System.out.println(Client.clients.get(clientNumber).carType);
                    if (Player.garage.get(i).producer == Client.clients.get(clientNumber).producer1 || Player.garage.get(i).producer == Client.clients.get(clientNumber).producer2 && Player.garage.get(i).type == Client.clients.get(clientNumber).carType && Player.garage.get(i).damaged==Client.clients.get(clientNumber).damages) {
                        System.out.println("Aktualna wartość twojego samochodu: " + Math.round(Player.garage.get(i).value));
                        System.out.println("Oszczędności klienta: "+Client.clients.get(clientNumber).money);
                        System.out.println("Podaj cenę samochodu za ile chcesz sprzedać: ");
                        try {
                            double priceForSell = input.nextDouble();
                        if (Client.clients.get(clientNumber).money >= priceForSell) {
                            Player.money = Player.money + priceForSell;
                            Player.money = Player.money - priceForSell*0.02+10;
                            Client.clients.remove(Client.clients.get(clientNumber));
                            Player.addCash(priceForSell, Player.garage.get(i).model);
                            Player.garage.remove(i);
                            System.out.println("Pobrano wartość podatku 2% ze sprzedaży samochodu oraz samochód został umty przed wyjazdem w kwocie usługi 10zł");
                            System.out.println("Pomyślnie sprzedano samochód");
                            getMoves(1);
                            addClientsToList(2);
                            menuStart();
                        } else {
                            System.out.println("Nie stać klienta na kupno samochodu");
                            menuStart();
                        }
                        }
                        catch (Exception e){
                            System.out.println("Wprowadzony symbol nie jest liczbą");
                            selectClient();
                        }
                    } else {
                        System.out.println("Nie posiadasz samochodu które wymaga klient");
                        menuStart();
                    }
                }
            } else {
                System.out.println("Brak samochodów na sprzedaż.");
                menuStart();
            }

        } else {
            System.out.println("Wprowadzony symbol nie jest liczbą");
            menuStart();
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
            System.out.println("Przykro mi uszkodzenia auta są zbyt poważne samochód musi trafić do Janusza i oto jego calkowita cena naprawy");
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
            if(mechanicFirstName=="Marian"){
                costRepair=valueRepair+ valueParts+500.0;

            }
            if(mechanicFirstName=="Adrian") {
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
            Player.withdrawMoney(costRepair,Player.garage.get(carNumber).model, "Repair");
            getMoves(1);
            menuStart();
        }
    }
    private void buyAdvertisement(){
        System.out.println("1.Ogłoszenie w lokalnej gazecie. Koszt 100zł i może przyciągnąć od 1 do 10 klientów");
        System.out.println("2.Ogłoszenie w internecie. Koszt 10zł i przyciąga jednego klienta");
        System.out.println("3.Wyjście.");
        if (input.hasNextInt()) {
            Integer number = this.input.nextInt();
            switch (number){
                case 1 -> paperAdvertisment();
                case 2 -> onlineAdvertisment();
                default -> menuStart();
            }
        }
        else {
            System.out.println("Wprowadzony symbol nie jest liczbą");
            new Game();
        }
    }
    private void paperAdvertisment(){
            int number = random.nextInt(10) + 1;
        if(Player.money>=100){
            Player.withdrawMoney(100.0,null,"buyAdvetisment");
            System.out.println("Zakupiono ogłoszenie w gazecie.");
            getMoves(1);
            System.out.println("Gratulacje twoja liczba klientów wzrosła o: "+number);
            addClientsToList(number);
            menuStart();
        }
        else {
            System.out.println("Niestety nie masz wystarczającej ilości gotówki.");
            menuStart();
        }

    }
    private void onlineAdvertisment(){
        if(Player.money>=10){
            Player.withdrawMoney(10.0,null,"buyAdvetisment");
            System.out.println("Zakupiono ogłoszenie w internecie.");
            getMoves(1);
            addClientsToList(1);
            menuStart();
        }
        else {
            System.out.println("Niestety nie masz wystarczającej ilości gotówki.");
            menuStart();
        }
    }
    public String getMoves(Integer display){

        if(display==1){
            numberOfMoves=numberOfMoves+1;
            return "Wykonałeś jeden ruch.";
        }
        else {
            return "Łączna ilość ruchów:"+numberOfMoves;
        }
    }
    public static void courseOfTheGame(){
        if(Player.money>=100000.0){
            System.out.println("WYGRAŁEŚ!");
            System.exit(0);
        }
        if(Player.money<10){
            System.out.println("PRZEGRAŁEŚ!");
            System.exit(0);
        }
    }
}
