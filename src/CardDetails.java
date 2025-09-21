
public class CardDetails {
	private String cardNo;
	private String secCode;
	
//	constructor
	public CardDetails(String cardNo, String secCode) {
		this.cardNo = cardNo;
		this.secCode = secCode;
	}
	
//	getters
	public String getCardNo() {
		return cardNo;
	}
	
	public String getSecCode() {
		return secCode;
	}
	
//	returns the card number as a string. Used for the receipt
	@Override
	public String toString() {
		return cardNo;
	}
	
}
