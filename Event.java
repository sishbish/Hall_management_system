
//Event class inherits from LiveEvent class.
//I did this becuase the LiveEvent class does not have all the attributes for a stock entry for some reason
public class Event extends LiveEvent {
	
	private String eventType;
	private String additionalInfo;

//	constructor
	public Event(String eventID, String eventName, String eventType, AgeRestrictionCategory restriction, int quantityInStock,
			double performanceFee, double ticketPrice, LiveEventCategory liveEventCategory, String additionalInfo) {
		super(eventID, eventName, restriction, quantityInStock, performanceFee, ticketPrice, liveEventCategory);
		this.eventType = eventType;
		this.additionalInfo = additionalInfo;
	}
	
//	getters
	public String getEventType() {
	    	return eventType;
	    }
	    
    public String getAdditionalInfo() {
    	return additionalInfo;
    }

}
