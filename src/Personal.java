public class Personal extends Cars{
    public Personal(Double value, String color, String model, String producer,String segment,Double mileage, String damaged, String type) {
        super(value,color,model,producer,segment,mileage,damaged,type);
    }
    public String toString(){
        return "Wartość: "+ this.value+", Kolor: "+ this.color+",Model: "+this.model+ ", Producent: "+this.producer+", Segment: " + this.segment+ ", Mileage: "+this.mileage+ ", Uszkodzenia: "+this.damaged+", Typ: "+this.type;
    }

}
