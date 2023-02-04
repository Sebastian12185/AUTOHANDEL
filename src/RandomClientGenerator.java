import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class RandomClientGenerator {
    private static String[] producers = {"AUDI", "TOYOTA", "VOLKSWAGEN", "HYUNDAI", "MERCEDES","BMW","MITSUBISHI"};
    private static String[] type  = {"van","personal"};
    private static String carProducer1;
    private static String carProducer2;
    private static Random random = new Random();

    public static Client generateRandomClient() {
        Double randomMoney = random.nextInt(15000) + 10000.0;
        String randomType = type[random.nextInt(type.length)];
        carProducer1 = producers[random.nextInt(producers.length)];
        carProducer2 = producers[random.nextInt(producers.length)];
        Integer randomIfDamages = random.nextInt(10);
            if(randomIfDamages==1){
                return new Client(randomMoney,carProducer1,carProducer2,randomType,"SUSPENSION");
            }
            else {
                return new Client(randomMoney,carProducer1,carProducer2,randomType,"WITHOUT");

        }
    }
}
