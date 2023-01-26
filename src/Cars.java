import java.util.Random;
abstract public class Cars {
    public Double value;
    public String color;
    public String model;
    public String producer;
    public String segment;
    public Double mileage;

    public Cars(Double value, String color, String model, String producer, String segment, Double mileage) {
        this.value = value;
        this.color = color;
        this.model = model;
        this.producer = producer;
        this.segment = segment;
        this.mileage = mileage;
    }

    public Double getValue() {
        return value;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public String getProducer() {
        return producer;
    }
    public String getSegment() {
        return segment;
    }
    public Double getMileage() {
        return mileage;
    }

}
