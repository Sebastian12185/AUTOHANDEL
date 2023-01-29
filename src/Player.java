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
            for (Cars car : garage) {
                System.out.println(car);
            }
            return garage;
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
    public static Boolean withdrawMoney(Double cash,String model){
        LocalDateTime now = LocalDateTime.now();
        tranzations.add("Kwota: ");
        tranzations.add(cash);
        tranzations.add("Model samochodu: ");
        tranzations.add(model);
        tranzations.add("Kiedy: ");
        tranzations.add(now);
        money = Player.money - cash;
        return true;
    }
}
