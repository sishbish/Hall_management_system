
public class Ticket {
    private Event event;    
    private double ticketPrice; 

    // Constructor
    public Ticket(Event event, double ticketPrice) {
        this.event = event;
        this.ticketPrice = event.getTicketPrice();  
    }

    // Getter for event
    public Event getEvent() {
        return event;
    }

    // Getter for total price
    public double getTicketPrice() {
        return ticketPrice;
    }
    
//    return the ticket info as string
    @Override
    public String toString() {
        return "Ticket:\n" +"  Event ID: " + event.getEventID() + "\n" +"  Name: " + event.getEventName() + "\n" +"  Type: " + event.getEventType() + "\n" +"  Category: " + event.getEventCategory() + "\n" +"  Price: £" + getTicketPrice() + "\n" +"  Age Restriction: " + event.getAgeRestriction() + "\n" +"  Info: " + event.getAdditionalInfo();
    }

}
