import java.time.LocalDate;

public class Receipt {
    private double amount;
    private String paymentMethod;
    private String email;
    private CardDetails cardDets;
    private Address billingAddress;

//    Constructor
    public Receipt(double amount, String paymentMethod, String email, CardDetails cardDets, Address billingAddress) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.email = email;
        this.cardDets = cardDets;
        this.billingAddress = billingAddress;
    }

//    Create receipt for each payment method
    public String generateReceipt() {
//    	stores the current date
        String today = LocalDate.now().toString();
        
//        for PayPal
        if (paymentMethod.equalsIgnoreCase("PayPal")) {
            return String.format("£%.2f paid via PayPal using %s on %s, and the billing address is %s.",
                    amount, email, today, billingAddress);
//          for credit card
        } else if (paymentMethod.equalsIgnoreCase("Credit Card")) {
            return String.format("£%.2f paid by Credit Card using %s on %s, and the billing address is %s.",
                    amount, cardDets, today, billingAddress);
//            error message if invalid option 
        } else {
            return "Unsupported payment method.";
        }
    }

//    return the receipt as string
    @Override
    public String toString() {
        return generateReceipt();
    }
}
