import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Ticket> tickets;

//    constructor. Just a list to store all the tickets
    public Basket() {
        this.tickets = new ArrayList<>();
    }

//    add a ticket to the basket list
    public void addTicket(Ticket ticket, int quant) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader("data files/Stock.txt"));
        
    	boolean ticketAdded = false;
    	String line = null;
		while((line = br.readLine()) != null) {
			String[] parts = line.split(",");
			if( (ticket.getEvent().getEventID().equals(parts[0])) && ( (Integer.parseInt(parts[5].trim()) - quant) > 0) ) {
				for(int i=0;i<quant;i++) {
				tickets.add(ticket);
				}
				ticketAdded = true;
				
			}
		}
//		check if there is enough stock to added requested tickets
		if(ticketAdded) {
			System.out.println("Ticket added to basket");
		}else {
			System.out.println("Not enough stock");
		}
        br.close();
        
    	
    }
    
//    getters
    public List<Ticket> getTickets() {
        return tickets;
    }
    
    public double getTotalPrice() {
        double total = 0.0;
        for (Ticket ticket : tickets) {
            total += ticket.getTicketPrice();
        }
        return total;
    }

//    clear the basket
    public void clearBasket() {
        tickets.clear();
    }
}
