public class Vans extends Cars{
    public Double spaceSize;
    public Vans(Double value, String color, String model, String producer,String segment,Double mileage,Integer damaged, Double spaceSize) {
        super(value,color,model,producer,segment,mileage,damaged);
        this.spaceSize = spaceSize;
    }
    public String toString(){
        return "Wartość: "+ this.value+", Kolor: "+ this.color+", Model: "+this.model+ ", Producent: "+this.producer+", Segment:" + this.segment+ ", Mileage: "+this.mileage+", Uszkodzenia: "+ this.damaged+ ", Pojemność ładunkowa: "+this.spaceSize;
    }
}
