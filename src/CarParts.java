abstract public class CarParts {
    private static final Double DEFAULT_BRAKES_PRICE = 1.1;
    private static final Double DEFAULT_SUSPENSION_PRICE = 1.2;
    private static final Double DEFAULT_ENGINE_PRICE = 2.0;
    private static final Double DEFAULT_BODY_PRICE = 1.5;
    private static final Double DEFAULT_GEARBOX_PRICE = 1.5;
    private Double percentOfValueRepair;
    private CarPartType carPartType;
    public enum CarPartType{
        BRAKES,
        SUSPENSION,
        ENGINE,
        BODY,
        GEARBOX
    }


    public CarParts(CarPartType carPartType){
        this.carPartType = carPartType;
        switch (carPartType){
            case BRAKES -> {this.percentOfValueRepair=DEFAULT_BRAKES_PRICE;}
            case SUSPENSION -> {this.percentOfValueRepair=DEFAULT_SUSPENSION_PRICE;}
            case ENGINE -> {this.percentOfValueRepair=DEFAULT_ENGINE_PRICE;}
            case BODY -> {this.percentOfValueRepair=DEFAULT_BODY_PRICE;}
            case GEARBOX -> {this.percentOfValueRepair=DEFAULT_GEARBOX_PRICE;}
        }
        }
}
