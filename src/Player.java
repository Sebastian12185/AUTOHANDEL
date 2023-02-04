import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Player {
    static Double money=50000.0;
    static List<Cars> garage = new ArrayList<>();
    static List<Object> tranzations = new ArrayList<>();
    public Player(Double money) {
        this.money = money;
    }
    public static Double getMoney(){
        return money;
    }

    public static void getTranzations(){
        tranzationsEmpty();
        if (tranzationsEmpty()==false){
            for (Object element : tranzations) {
                System.out.println(element);
            }
        }
    }
    public static Boolean tranzationsEmpty(){
        if (tranzations.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public static List<Cars> getGarage() {
        garageEmpty();
        if(garageEmpty()==true){
            return garage;
        }
        else{
            for (int i = 0; i < garage.size(); i++) {
                System.out.println(i+1+". "+garage.get(i));
            }
            return garage;
        }
    }
    public static void getCarsToRepair() {
            for (int i = 0; i < garage.size(); i++) {
                System.out.println(i + 1 + ". " + garage.get(i));
            }
    }
    public static Boolean garageEmpty(){
        if (garage.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public static void addToGarage(Cars samochód){
        garage.add(samochód);
    }

    public static Boolean addCash(Double cash, String model){
        LocalDateTime now = LocalDateTime.now();
        tranzations.add("Sprzedaż samochodu:");
        tranzations.add("Kwota: ");
        tranzations.add(Math.round(cash));
        tranzations.add("Model samochodu: ");
        tranzations.add(model);
        tranzations.add("Kiedy: ");
        tranzations.add(now);
        Game.courseOfTheGame();
        return true;
    }
    public static Boolean withdrawMoney(Double cash,String model,String typeWithdraw){
        LocalDateTime now = LocalDateTime.now();
        if(typeWithdraw=="Buy"){
            tranzations.add("Kupno samochodu:");
        }
        if(typeWithdraw=="Repair"){
            tranzations.add("Naprawa samochodu:");
        }
        if(typeWithdraw=="buyAdvetisment"){
            tranzations.add("Kupno reklamy:");
        }
        tranzations.add("Kwota: ");
        tranzations.add(Math.round(cash));
        if(model!=null){
            tranzations.add("Model samochodu: ");
            tranzations.add(model);
        }
        tranzations.add("Kiedy: ");
        tranzations.add(now);
        money = Player.money - cash;
        Game.courseOfTheGame();
        return true;
    }
    public static Cars getCar(Integer carNumber){
        return garage.get(carNumber);
    }
}
