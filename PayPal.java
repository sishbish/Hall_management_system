
//PayPal class implements the PaymentMethod interface class
public class PayPal implements PaymentMethod{
	private String email;

//	Constructor
    public PayPal(String email) {
        this.email = email;
    }

//    Creates receipt object for a PayPal payment
    @Override
    public Receipt processPayment(double amount, Address fullAddress) {
        return new Receipt(amount, "PayPal", email, null, fullAddress);
    }
}
