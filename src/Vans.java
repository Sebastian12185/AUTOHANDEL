public class Vans extends Cars{
    public Double spaceSize;
    public Vans(Double value, String color, String model, String producer,String segment,Double mileage,String damaged,String type, Double spaceSize) {
        super(value,color,model,producer,segment,mileage,damaged,type);
        this.spaceSize = spaceSize;
    }
    public String toString(){
        return "Wartość: "+ this.value+", Kolor: "+ this.color+", Model: "+this.model+ ", Producent: "+this.producer+", Segment:" + this.segment+ ", Mileage: "+this.mileage+", Uszkodzenia: "+ this.damaged+", Pojemność ładunkowa: "+this.spaceSize;
    }
}
