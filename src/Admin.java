import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Admin class inherits from the User class
public class Admin extends User{
	
//	constructor
	public Admin(String userID, String username, String name, Address address) {
		super(userID, username, name, address, "admin");
	}
	
	
//	get the stock in ascending price order
	@Override
	public List<String> accessEventDetails() throws IOException{
        
		List<Event> stock = new ArrayList<>();
		List<String> sortedStock = new ArrayList<>();
		
        BufferedReader br = new BufferedReader(new FileReader("data files/Stock.txt"));
		String line = null;
		 while((line = br.readLine()) != null) {
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
					 
		    stock.add(new Event(id,name,type,ageRestriction,quantity,fee,price,category,extraInfo));
		 }
		 br.close();
		 
		 stock.sort(Comparator.comparingDouble(Event :: getTicketPrice));
		 
		 
		 for (Event event : stock) {
			 sortedStock.add(event.getEventID() + "," + event.getEventCategory() + "," + event.getEventType() + "," + event.getEventName() + "," + event.getAgeRestriction() + "," + event.getQuantityInStock() + "," + event.getPerformanceFee()+ "," + event.getTicketPrice() + "," + event.getAdditionalInfo());
		}
		 
		 
	    // Table header
	    String header = String.format(
	        "%-8s | %-12s | %-18s | %-25s | %-10s | %-8s | %-12s | %-12s | %-15s",
	        "EventID", "Category", "Type", "Name", "Age", "Qty", "Fee(£)", "Price(£)", "Extra Info"
	    );
	    String divider = "-".repeat(header.length());

	    System.out.println(header);
	    System.out.println(divider);

	    // Table rows
	    for (Event event : stock) {
	        String row = String.format(
	            "%-8s | %-12s | %-18s | %-25s | %-10s | %-8d | %-12.2f| %-12.2f | %-15s",
	            event.getEventID(),
	            event.getEventCategory(),
	            event.getEventType(),
	            event.getEventName(),
	            event.getAgeRestriction(),
	            event.getQuantityInStock(),
	            event.getPerformanceFee(),
	            event.getTicketPrice(),
	            event.getAdditionalInfo()
	        );
	        System.out.println(row);
	    }
		
		 return sortedStock;
	}
	
	
	
//	add an event to stock file. Returns a boolean to check if it was added successfully.
	public boolean addEvent(String id,LiveEventCategory category,String type,String name,AgeRestrictionCategory ageRestriction,int quantity,double fee,double price,String extraInfo) throws IOException{
		Event event = new Event(id,name,type,ageRestriction,quantity,fee,price,category,extraInfo);
		
		BufferedReader br = new BufferedReader(new FileReader("data files/Stock.txt"));
		String line = null;
		boolean copy = false;
		 while((line = br.readLine()) != null) {
			 String[] parts = line.split(",");
			 if(parts[0] == event.getEventID()) {
				 copy = true;
				 return copy;
			 }
			 
		 }
		
		
		String eventLine = event.getEventID() + "," + event.getEventCategory() + "," + event.getEventType() + "," + event.getEventName() + "," + event.getAgeRestriction() + "," + event.getQuantityInStock() + "," + event.getPerformanceFee() + "," + event.getTicketPrice() + "," + event.getAdditionalInfo();
		
		FileWriter writer = new FileWriter("data files/Stock.txt", true);
		writer.write(eventLine + "\n");
		writer.close();
		return copy;
	}
	
	
}
