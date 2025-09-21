
//CreditCard class implements the PaymentMethod interface class
public class CreditCard implements PaymentMethod{
	
	 private CardDetails cardDetails;

//	 constructor
	    public CreditCard(CardDetails cardDetails) {
	        this.cardDetails = cardDetails;
	    }
	    
//	    Creates receipt object for a credit card payment
	    @Override
	    public Receipt processPayment(double amount, Address fullAddress) {
	        return new Receipt(amount, "Credit Card", null, cardDetails, fullAddress);
	    }
}
