import java.util.Random;

public class RandomCarGenerator {
    private static String[] producers = {"AUDI", "TOYOTA", "VOLKSWAGEN", "HYUNDAI", "MERCEDES","BMW","MITSUBISHI"};
    private static String[] models = {"A1", "SQ8", "Corolla", "Yaris", "Golf","Polo","Margo","Elantra","Klasa A","Klasa B","M50","I4","Outlander","Lancer"};
    private static String[] colors = {"black","white","red","grey","yellow"};
    private static String[] segments = {"premium","standard","budget"};
    private static String[] damages  = {"BRAKES","SUSPENSION","ENGINE","BODY","GEARBOX","WITHOUT"};
    private static Random random = new Random();

    public static Cars generateRandomCar() {
        String randomProducer = producers[random.nextInt(producers.length)];
        String randomModel = models[random.nextInt(models.length)];
        String randomColor = colors[random.nextInt(colors.length)];
        String randomSegment = segments[random.nextInt(segments.length)];
        Double randomValue = random.nextInt(5000) + 10000.0;
        Double randomMileage = random.nextInt(300000) + 0.0;
        Double randomSpaceSize = random.nextInt(2000) + 500.0;
        String randomDamaged = damages[random.nextInt(damages.length)];
        Integer randomTypeCar = random.nextInt(2);
        if(randomTypeCar==0){
                return new Personal(randomValue, randomColor, randomModel, randomProducer, randomSegment, randomMileage, randomDamaged,"personal");
        }
        else{
            return new Vans(randomValue, randomColor, randomModel,randomProducer,randomSegment,randomMileage, randomDamaged,"van", randomSpaceSize);
        }
    }
}
