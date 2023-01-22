public class Client {
    public Double money;

    private InterestedCarType interestedCarType;
    public enum InterestedCarType{
        PERSONAL,
        VANS
    }
    private InterestedTypeOfCarByProducer interestedTypeOfCarByProducer;
    public enum InterestedTypeOfCarByProducer{
        AUDI,
        TOYOTA,
        VOLKSWAGEN,
        HYUNDAI,
        MERCEDES,
        BMW,
        MITSUBISHI
    }
    private InterestedDamaged interestedDamaged;
            public enum InterestedDamaged{
                DAMAGED,
                SUSPENSION,
                NODAMAGED
            }

}
