abstract public class Cars {
    public Double value;
    public String color;
    public String model;
    public String producer;
    public String segment;
    public Double mileage;
    public String damaged;
    public String type;

    public Cars(Double value, String color, String model, String producer, String segment, Double mileage, String damaged, String type) {
        this.value = value;
        this.color = color;
        this.model = model;
        this.producer = producer;
        this.segment = segment;
        this.mileage = mileage;
        this.damaged = damaged;
        this.type = type;
    }
    public static double costCarRepair(String producer, Double value){
        if(producer=="AUDI"){
            return Math.round(value*1.1)-value;
        }
        else if(producer=="TOYOTA"){
            return Math.round(value*1.06)-value;
        }
        else if(producer=="VOLKSWAGEN"){
            return Math.round(value*1.04)-value;
        }
        else if(producer=="HYUNDAI"){
            return Math.round(value*1.09)-value;
        }
        else if(producer=="MERCEDES"){
            return Math.round(value*1.12)-value;
        }
        else if(producer=="BMW"){
            return Math.round(value*1.5)-value;
        }
        else {
            return Math.round(value*1.3)-value;
        }
    }
}
