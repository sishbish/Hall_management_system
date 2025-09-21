//abstract class because only the Event class is used since
//LiveEvent does not have two of the required attributes.

public abstract class LiveEvent{
    private String eventID;
    private String eventName;
    private LiveEventCategory liveEventCategory;         
    private double performanceFee;
    private int quantityInStock;
    private AgeRestrictionCategory restriction;
    private double ticketPrice;
 

    // Constructor
    public LiveEvent(String eventID, String eventName, AgeRestrictionCategory restriction, int quantityInStock, double performanceFee, double ticketPrice, LiveEventCategory liveEventCategory){
        this.eventID = eventID;
        this.eventName = eventName;
        this.restriction = restriction;
        this.quantityInStock = quantityInStock;
        this.performanceFee = performanceFee;
        this.ticketPrice = ticketPrice;
        this.liveEventCategory = liveEventCategory;
    }

    // Getters
    public AgeRestrictionCategory getAgeRestriction() {
    	return restriction;
    }
    
    public LiveEventCategory getEventCategory(){
        return liveEventCategory;
    }
    
    public String getEventID(){
        return eventID;
    }

    public String getEventName(){
        return eventName;
    }
    
    public double getPerformanceFee(){
        return performanceFee;
    }
    
    public int getQuantityInStock(){
        return quantityInStock;
    }
    
    public double getTicketPrice(){
        return ticketPrice;
    }
    
    public void setQuantitiyInStock(int newQuantityInStock) {
    	this.quantityInStock = newQuantityInStock;
    }

//    returns all the attributes as a string
    @Override
    public String toString() {
        return eventID + "," + eventName + "," + liveEventCategory + "," + performanceFee + "," + quantityInStock + "," + restriction + "," + ticketPrice;
    }
}
