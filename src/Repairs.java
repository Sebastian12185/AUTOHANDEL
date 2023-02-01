import java.util.Random;

public class Repairs {
    private static Random random = new Random();
    public static void carRepair(Cars car, String mechanicFirstName){
        Integer randomNumber = random.nextInt(100)+1;
        if(mechanicFirstName=="Janusz"){
            car.damaged="WITHOUT";
            car.value=CarParts.getCostCarAfterRepairByPart(car);
        }
        else if(mechanicFirstName=="Marian"){
            if(randomNumber<=10){
                System.out.println("Nie udało się naprawić samochód musi trafić do Janusza.");
                car.damaged = car.damaged + "+";
            }
            else {
                car.damaged="WITHOUT";
                car.value=CarParts.getCostCarAfterRepairByPart(car);
            }
        }
        else{
            if(randomNumber<=20){
                System.out.println("Nie udało się naprawić samochodu.");
                if(randomNumber==1 || randomNumber==2){
                    car.damaged = car.damaged + ",BODY";
                    System.out.println("Przy próbie naprawy uszkodzono również karoserie.");
                }
            }
            else {
                car.damaged="WITHOUT";
                car.value=CarParts.getCostCarAfterRepairByPart(car);
            }
        }
    }

}
