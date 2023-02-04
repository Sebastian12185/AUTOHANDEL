abstract public class CarParts {
    private static final Double DEFAULT_BRAKES_PRICE = 1.1;
    private static final Double DEFAULT_SUSPENSION_PRICE = 1.2;
    private static final Double DEFAULT_ENGINE_PRICE = 2.0;
    private static final Double DEFAULT_BODY_PRICE = 1.5;
    private static final Double DEFAULT_GEARBOX_PRICE = 1.5;
    private Double percentOfValueRepair;


    public CarParts(String carPartType){
        switch (carPartType){
            case "BRAKES" -> {this.percentOfValueRepair=DEFAULT_BRAKES_PRICE;}
            case "SUSPENSION" -> {this.percentOfValueRepair=DEFAULT_SUSPENSION_PRICE;}
            case "ENGINE" -> {this.percentOfValueRepair=DEFAULT_ENGINE_PRICE;}
            case "BODY" -> {this.percentOfValueRepair=DEFAULT_BODY_PRICE;}
            case "GEARBOX" -> {this.percentOfValueRepair=DEFAULT_GEARBOX_PRICE;}
        }
        }
    public static Object costRepairOfParts(String part,Double value) {
        switch (part){
            case "BRAKES" -> {return Math.round(value*1.05)-value;}
            case "SUSPENSION" -> {return Math.round(value*1.1)-value;}
            case "ENGINE" -> {return Math.round(value*1.5)-value;}
            case "BODY" -> {return Math.round(value*1.25)-value;}
            case "GEARBOX" -> {return Math.round(value*1.25)-value;}
            default -> {return "Naprawa nieopłacalna.";}
        }
    }

    public static void getCostCarAfterRepairByPart(Cars car){
        if(car.damaged=="BRAKES"){
            Math.round(car.value = car.value*DEFAULT_BRAKES_PRICE);
        }
        if(car.damaged=="SUSPENSION"){
            Math.round(car.value = car.value*DEFAULT_SUSPENSION_PRICE);
        }
        if(car.damaged=="ENGINE"){
            Math.round(car.value = car.value*DEFAULT_ENGINE_PRICE);
        }
        if(car.damaged=="BODY"){
            Math.round(car.value = car.value*DEFAULT_BODY_PRICE);
        }
        if(car.damaged=="GEARBOX") {
            Math.round(car.value = car.value * DEFAULT_GEARBOX_PRICE);
        }
    }
}
