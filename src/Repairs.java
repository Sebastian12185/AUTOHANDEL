import java.util.Random;

public class Repairs {
    private static Random random = new Random();
    public static void carRepair(Cars car, String mechanicFirstName){
        Integer randomNumber = random.nextInt(100)+1;
        if(mechanicFirstName=="Janusz"){
            CarParts.getCostCarAfterRepairByPart(car);
            System.out.println("Samochód został anprawiony.");
            car.damaged="WITHOUT";
        }
        if(mechanicFirstName=="Marian"){
            if(randomNumber<=10){
                System.out.println("Nie udało się naprawić samochód musi trafić do Janusza.");
                car.damaged = car.damaged + "+";
            }
            if(randomNumber>10) {
                CarParts.getCostCarAfterRepairByPart(car);
                System.out.println("Samochód został anprawiony.");
                car.damaged="WITHOUT";
            }
        }
        if(mechanicFirstName=="Adrian"){
            if(randomNumber<=100){
                System.out.println("Nie udało się naprawić samochodu.");
                if(randomNumber<=100){
                    car.damaged = car.damaged + ",BODY";
                    System.out.println("Przy próbie naprawy uszkodzono również karoserie.");
                }
            }
            if(randomNumber==20) {
                CarParts.getCostCarAfterRepairByPart(car);
                System.out.println("Samochód został maprawiony.");
                car.damaged="WITHOUT";
            }
        }
    }

}
