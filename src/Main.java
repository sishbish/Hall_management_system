import java.io.*;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{

    	System.out.println("Welcome to the performance hall booking and admin system.\nRegistered users may login using their given username.");
        
//    	Start scanner for taking inputs
        Scanner scanner = new Scanner(System.in);
        
//       main program loop
        boolean running = true;
        while(running) {
	        
	        
	        Customer customer = null;
	        Admin admin = null;
	        
		        
//		        open user accounts file
		        BufferedReader br = new BufferedReader(new FileReader("data files/UserAccounts.txt"));
				String line = null;

				

		        System.out.println("                                                                  Type 'quit' to end program\n");
		        System.out.println("Please select a login by entering the username:\n");
		        
				// Table header
			    String header = String.format(
			        "%-8s | %-12s",
			        "Username", "Role"
			    );
			    String divider = "-".repeat(header.length());
			    
			    System.out.println(header);
			    System.out.println(divider);
		        
//					read through file
				while((line = br.readLine()) != null) {
//						split each entry in the file by the comma
					String[] parts = line.split(",");
									    
				    // Table rows
			        String row = String.format(
			            "%-8s | %-12s",
			            parts[1],
			            parts[6]
			        );
			        System.out.println(row);

				}
				br.close();
			
				//        Login
		        boolean runningLogin = true;
		        while(runningLogin) {
//			        take input
			        String login = scanner.nextLine();
			        
//			        option to end program
			        if(login.equals("quit")) {
			        	running = false;
			        		break;
			        }
			        
			        BufferedReader br1 = new BufferedReader(new FileReader("data files/UserAccounts.txt"));
			        				
	//					read through file
					while((line = br1.readLine()) != null) {
	//						split each entry in the file by the comma
						String[] parts = line.split(",");
						
//						check if the entered username matches any of the usernames in the file
						if(parts[1].trim().equals(login)) {
							
//							create address object
							Address address = new Address(parts[3].trim(),parts[4].trim(),parts[5].trim());
							
//							if the user name is for a customer then create customer object
							if(parts[6].trim().equals("customer")) {
			//					create new customer object with the login information
								customer = new Customer (parts[0].trim(),parts[1].trim(),parts[2].trim(),address);
								System.out.println("Welcome " + parts[1]);
								
//								line break for easier readability
								System.out.println();
								
//								if the username is for an admin then create admin object
							}else {
			//					create new admin object with the login info
								admin = new Admin (parts[0].trim(),parts[1].trim(),parts[2].trim(),address);
								System.out.println("Welcome " + parts[1]);
								
//								line break for easier readability
								System.out.println();
							}
							
//							end the login loop
							runningLogin = false;
					        br1.close();
							break;

						}
						
					}
					
					if(runningLogin) {
						System.out.println("Invalid username. Please select a username from the displayed usernames.");
					}
				
		        }
	        
	        
	        
	        
	//        admin functionalities
	    	if(admin != null) {
	    		
//	    		admin loop
	    		boolean runningAdmin = true;
	    		while(runningAdmin) {
	    			
	    			int opt;
	    			while(true) {
	//	    			display admin options
			    		System.out.println("Select an option by entering the corresponding number\n");
			    		System.out.println("1. View all events");
			    		System.out.println("2. Add an event to the existing event list");
			    		System.out.println("3. Logout\n");
			    		System.out.println("Enter option: ");

//			    		take input for what option the user wants and also check for valid input
			            if (scanner.hasNextInt()) {
		            		opt = scanner.nextInt();
		            		break;
		                } else {
		                    System.out.println("Invalid input. Please enter an integer value.");
		                    scanner.nextLine(); // clear the invalid input
		                }
	    			}
		            scanner.nextLine();
		            
	//	            view events
		            if(opt == 1) {
		            	admin.accessEventDetails();
		            	
		            	
	//	            add event. Some of the event attributes have a loop for the user input.
//		            This is becuase some of the attributes must be a certain data type
		            }else if(opt == 2) {
		            	
//		            	event id
		            	System.out.println("Enter event ID: ");
		            	String id = scanner.nextLine().trim();
		            	
//		            	event category
		            	LiveEventCategory category = null;
		            	while(true) {
			            	System.out.println("Enter event category: ");
			            	String categ = scanner.nextLine().trim().toUpperCase();
			            	try {
			            	    category = LiveEventCategory.valueOf(categ);
			            	    break;
			            	} catch (IllegalArgumentException e) {
			            	    System.out.println("Invalid category.");
			            	}
		            	}
		            	
//		            	event type
		            	System.out.println("Enter event type: ");
		            	String type = scanner.nextLine().trim();
		            	
//		            	event name
		            	System.out.println("Enter event name: ");
		            	String name = scanner.nextLine().trim();
		            	
//		            	age restriction
		            	AgeRestrictionCategory restriction = null;
		            	while(true) {
			            	System.out.println("Enter event restriction: ");
			            	String restr = scanner.nextLine().trim().toUpperCase();
			            	try {
			            		restriction = AgeRestrictionCategory.valueOf(restr);
			            		break;
			            	} catch (IllegalArgumentException e) {
			            		System.out.println("Invalid age restriction");
			            	}
		            	}
		            	
//		            	ticket quantity
		            	int quantity = 0;
		            	while(true) {
			            	System.out.println("Enter event quantity: ");
			            	
			            	if (scanner.hasNextInt()) {
			            		quantity = scanner.nextInt();
			            		scanner.nextLine();
			            		break;
			                } else {
			                    System.out.println("Invalid input. Please enter an integer value.");
			                    scanner.nextLine(); // clear the invalid input
			                }
		            	}
		            	
//		            	performance fee
		            	double fee = 0.0;
		            	while(true) {
			            	System.out.println("Enter event performance fee: ");
			            	
			            	if (scanner.hasNextDouble()) {
			            		fee = scanner.nextDouble();
			            		scanner.nextLine();
			            		break;
			            	} else {
			            		System.out.println("Invalid input. Please enter a double value.");
			                    scanner.nextLine(); // clear the invalid input
			            	}
		            	}
		            	
//		            	ticket price
		            	double price = 0.0;
		            	while(true) {
			            	System.out.println("Enter event ticket price: ");
			            	
			            	if (scanner.hasNextDouble()) {
			            		price = scanner.nextDouble();
			            		scanner.nextLine();
			            		break;
			                } else {
			                    System.out.println("Invalid input. Please enter a double value.");
			                    scanner.nextLine(); // clear the invalid input
			                }
		            	}
		            	
//		            	additional info
		            	System.out.println("Enter event additional information: ");
		            	String extraInfo = scanner.nextLine().trim();
		            	
		            	
		            	
//		            	check if the entered ID already exists for another event
		            	if (admin.addEvent(id, category, type, name, restriction, quantity, fee, price, extraInfo)) {
		            		System.out.println("The new event ID matches an existing event.\nEnter a unique ID for the new event.");
		            	}else {
		            		System.out.println("Event added\n");
		            	}
		            	
		            }
//		            logout
		            else if(opt == 3) {
		            	runningAdmin = false;
		            }
		            
//		            error message if invalid input
	//	            invalid input
		            else {
		            	System.out.println("invalid input");
		            }
		            
	    		}
	    	}
	    	
	//    	customer functionalities
	    	else if(customer != null){
	    		Basket basket = new Basket();
	    		
//	    		customer loop
	    		boolean runningCustomer = true;
	    		while(runningCustomer) {
	    			
	    			int opt;
	    			while(true) {
	//	    			display customer options
			    		System.out.println("\n\nSelect an option by entering the corresponding number\n");
			    		System.out.println("1. View all available events"); 
			    		System.out.println("2. Search events by ID"); 
			    		System.out.println("3. Search events by Language"); 
			    		System.out.println("4. Add tickets to basket");
			    		System.out.println("5. View basket");
			    		System.out.println("6. Complete payment for selected tickets");
			    		System.out.println("7. Clear basket");
			    		System.out.println("8. Logout");
			    		
			    		
	//		    		take input for what option the user wants and also check for valid input
			            if (scanner.hasNextInt()) {
		            		opt = scanner.nextInt();
		            		break;
		                } else {
		                    System.out.println("Invalid input. Please enter an integer value.");
		                    scanner.nextLine(); // clear the invalid input
		                }
	    			}
		            scanner.nextLine();
		            
	//	            display all events in ascending price order
		            if(opt == 1) {
		            	customer.accessEventDetails();
		            }
		            
//		            search by id
		            else if(opt == 2) {
		            	System.out.println("Enter ID: ");
		            	String id = scanner.nextLine();
		            	List<String> res = customer.searchByID(id);
		            	for (String search:res) {
		            		System.out.println(search);
		            	}
		            	
		            }
		            
//		            search by language
		            else if(opt == 3) {
		            	System.out.println("Available languages:");
		            	System.out.println("\t-English\n\t-Japanese\n\t-Arabic\n\t-Spanish");
		            	System.out.println("Enter language: ");
		            	String lang = scanner.nextLine();
		            	List<String> res = customer.searchByLang(lang);
		            	for (String search:res) {
		            		System.out.println(search);
		            	}
		            }
		            
	//	            select and add tickets to basket
		            else if(opt == 4) {
		            	customer.accessEventDetails();
		            	
		            	boolean runningTickets = true;
		            	
		            	while(runningTickets) {
		            		
			            	System.out.println("\nenter the ID of the ticket you would like to add to basket: ");
			            	String id = scanner.nextLine().trim();
			            	System.out.println("Enter the number of tickets you would like to purchase: ");
			            	int quant = scanner.nextInt();
			            	scanner.nextLine();
			            	
			            	Ticket ticket = customer.createTicket(id);
			            	
//			            	check if entered id exists
			            	if (ticket == null) {
			            	    System.out.println("No event found with ID: " + id);
			            	} else {
			            	    basket.addTicket(ticket, quant);
			            	     
			            	    
			            	}
			            	
//			            	ask if user wants to add another ticket
			            	System.out.println("Would you like to add another ticket to your basket? [yes/no]");
			            	String ans = scanner.nextLine();
			            	
			            	while(true) {
				            	if(ans.equals("no")) {
				            		runningTickets = false;
				            		break;
				            	}else if(ans.trim().toLowerCase().equals("yes")){
				            		runningTickets = true;
				            		break;
				            	}else {
				            		System.out.println("invalid input");
				            		ans = scanner.nextLine();
				            	}
			            	}
		            	}
		            }
		            
	//	            view the basket
		            else if (opt == 5) {
		            	List<Ticket> tickets = basket.getTickets();
		            	if (tickets.isEmpty()) {
		            	    System.out.println("Your basket is currently empty.");
		            	} else {
		            	    System.out.println("Tickets in your basket:\n");
		            	    for (Ticket t : tickets) {
		            	        System.out.println(t);
		            	        System.out.println("-----------");
		            	    }
		            	}
		            	System.out.println("Total price:" + " " + "£" + basket.getTotalPrice());
		            }
		            
	//	            pay and generate receipt
		            else if (opt == 6) {
		            	
		            	PaymentMethod paymentMethod = null;
		            	Receipt receipt = null;
		            	int opt1;
		            	
		            	while(true) {
			            	System.out.println("Seclect a payment method by entering the corresponding number");
			            	System.out.println("1. Credit card");
			            	System.out.println("2. PayPal");
			            	
			            	if (scanner.hasNextInt()) {
			            		opt1 = scanner.nextInt();
			            		break;
			                } else {
			                    System.out.println("Invalid input. Please enter an integer value.");
			                    scanner.nextLine(); // clear the invalid input
			                }
		            	}
		            	
		            	scanner.nextLine();
	//	            	pay with credit card
		            	if(opt1 == 1) {
		            		System.out.println("Enter your card number: ");
		            		String cardNo = scanner.nextLine();
		            		System.out.println("Enter your security code: ");
		            		String secCode = scanner.nextLine();
		            		
		            		CardDetails cardDets = new CardDetails(cardNo,secCode);
		            		paymentMethod = new CreditCard(cardDets);
		            		
		            	}
		            	
	//	            	pay PayPal
		            	else if (opt1 == 2) {
		            		String email = null;
		            		while(true) {
			            		System.out.println("Enter your email address: ");
			            		email = scanner.nextLine();	 
			            		
			            		if(email.contains("@") && email.contains(".")) {
			            			break;
			            		}else {
			            			System.out.println("Invalid email");
			            			continue;
			            		}
			            		
		            		}
		            		paymentMethod = new PayPal(email);
		            	}
		            	
	//	            	invalid input
		            	else {
		            		System.out.println("invalid input");
		            	}
		            	
		            	if (paymentMethod != null) {
		            	    receipt = paymentMethod.processPayment(basket.getTotalPrice(), customer.getAddress());
		            	    System.out.println(receipt.generateReceipt());
		            	    basket.clearBasket();
		            	}
		            }
		            
	//	            clear basket
		            else if(opt == 7) {
		            	basket.clearBasket();
	            		System.out.println("Basket cleared");
		            }
		            
		            else if(opt == 8) {
		            	runningCustomer = false;
		            	
		            }
		            
	//	            invalid input
		            else {
		            	System.out.println("Invalid input");
		            }
	    		}	
	        }  
	    	
	    	
        }
        scanner.close();
        System.out.println("Program ended");
    }	
}
