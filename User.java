import java.io.*;
import java.util.List;

//abstract class User
public abstract class User {
	
//	attributes are protected since they are never directly accessed
	protected String userID;
    protected String username;
    protected String name;
    protected Address address;
    protected String role;
    
//    constructor
    public User(String userID, String username, String name, Address address, String role) {
    	
        this.userID = userID;
        this.username = username;
        this.name = name;
        this.address = address;
        this.role = role;
        
    }
    
//    the method to get the stock info
    public abstract List<String> accessEventDetails() throws IOException;
    
}
