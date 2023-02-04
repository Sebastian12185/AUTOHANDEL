import java.util.ArrayList;
import java.util.List;

public class Client {

    static List<Client> clients = new ArrayList<>();
    public Double money;
    public String producer1;
    public String producer2;
    public String carType;
    public String damages;
    public Client(Double money, String producer1,String producer2, String carType, String damages) {
        this.money = money;
        this.producer1 = producer1;
        this.producer2 = producer2;
        this.carType = carType;
        this.damages = damages;
    }
    public String toString(){
        return "Oszczędności: "+ this.money+"; Producenci: "+ this.producer1+", "+this.producer2+"; Typ: "+this.carType+ "; Uszkodzenia: "+this.damages;
    }

}
