import java.io.*;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

//Customer class inherits the User class
public class Customer extends User{
	
//	constructor
	public Customer(String userID, String username, String name, Address address) {
		super(userID, username, name, address, "customer");
	}
	
//	get the event info from the stock file. This is everything apart from the performance fee
	@Override
	public List<String> accessEventDetails() throws IOException {
	    
	    List<Event> stock = new ArrayList<>();
	    List<String> sortedStock = new ArrayList<>();
	    
	    BufferedReader br = new BufferedReader(new FileReader("data files/Stock.txt"));
	    String line;
	    
	    while ((line = br.readLine()) != null) {
	        String[] parts = line.split(",");
	        
	        String id = parts[0].trim();
	        LiveEventCategory category = LiveEventCategory.valueOf(parts[1].trim().toUpperCase());
	        String type = parts[2].trim();
	        String name = parts[3].trim();
	        AgeRestrictionCategory ageRestriction = AgeRestrictionCategory.valueOf(parts[4].trim().toUpperCase());
	        int quantity = Integer.parseInt(parts[5].trim());
	        double fee = Double.parseDouble(parts[6].trim());
	        double price = Double.parseDouble(parts[7].trim());
	        String extraInfo = parts[8].trim();
	        
	        stock.add(new Event(id, name, type, ageRestriction, quantity, fee, price, category, extraInfo));
	    }
	    br.close();
	    
	    // Sort by ticket price
	    stock.sort(Comparator.comparingDouble(Event::getTicketPrice));

	    // Table header
	    String header = String.format(
	        "%-8s | %-12s | %-18s | %-25s | %-10s | %-8s | %-12s | %-15s",
	        "EventID", "Category", "Type", "Name", "Age", "Qty", "Price(£)", "Extra Info"
	    );
	    String divider = "-".repeat(header.length());

	    System.out.println(header);
	    System.out.println(divider);
	    sortedStock.add(header);
	    sortedStock.add(divider);

	    // Table rows
	    for (Event event : stock) {
	        String row = String.format(
	            "%-8s | %-12s | %-18s | %-25s | %-10s | %-8d | %-12.2f | %-15s",
	            event.getEventID(),
	            event.getEventCategory(),
	            event.getEventType(),
	            event.getEventName(),
	            event.getAgeRestriction(),
	            event.getQuantityInStock(),
	            event.getTicketPrice(),
	            event.getAdditionalInfo()
	        );
	        System.out.println(row);
	        sortedStock.add(row);
	    }

	    return sortedStock;
	}
	
	
//	search by given id
	public List<String> searchByID(String id) throws IOException{
		List<String> results = new ArrayList<>();
		
		boolean found = false;
		BufferedReader br = new BufferedReader(new FileReader("data files/Stock.txt"));
		String line;
		while ((line = br.readLine()) != null) {
			String[] parts = line.split(",");
			if (parts.length > 0) {
				String currentID = parts[0].trim();
				if (currentID.equals(id)) {
					results.add(line);
					found = true;
				}
			}
		}
		br.close();
		
//		error message is id does not exist in the stock file
		if (!found) {
			results.add("ID not found");
		}
		return results;		
	}
	
	
//	search by language
	public List<String> searchByLang(String lang) throws IOException{
		List<String> results = new ArrayList<>();
		
		boolean found = false;
		BufferedReader br = new BufferedReader(new FileReader("data files/Stock.txt"));
		String line;
		while ((line = br.readLine()) != null) {
			String[] parts = line.split(",");
			if (parts.length > 0) {
				String currentLang = parts[8].trim();
				if (currentLang.trim().toUpperCase().equals(lang.trim().toUpperCase())) {
					results.add(line);
					found = true;
				}
			}
		}
		br.close();
		
//		error message if the language does not exist in the stock file
		if (!found) {
			results.add("Language not found");
		}
		
		return results;
			
	}
	
	
//	create a ticket
	public Ticket createTicket(String id) throws IOException {
//		add ticket
		Ticket ticket = null;
	
		BufferedReader br = new BufferedReader(new FileReader("data files/Stock.txt"));
		String line = null;
		while((line = br.readLine()) != null) {
			String[] parts = line.split(",");
			if(parts[0].equals(id)) {
			    LiveEventCategory category = LiveEventCategory.valueOf(parts[1].trim().toUpperCase());
			    String type = parts[2].trim();
			    String name = parts[3].trim();
			    AgeRestrictionCategory ageRestriction = AgeRestrictionCategory.valueOf(parts[4].trim().toUpperCase());
			    int quantity = Integer.parseInt(parts[5].trim());
			    double fee = Double.parseDouble(parts[6].trim());
			    double price = Double.parseDouble(parts[7].trim());
			    String extraInfo = parts[8].trim();
			    
//			    create new Event object
				Event addEv = new Event(id,name,type,ageRestriction,quantity,fee,price,category,extraInfo);
//				create new Ticket object
				ticket = new Ticket(addEv,price);

			}
			
		}
        br.close();
        return ticket;
	}
	
//	getters
	public Address getAddress() {
		return address;
	}
	
}