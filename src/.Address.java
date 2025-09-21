
public class Address {
    private String houseNumber;
    private String postcode;
    private String city;

//    constructor
    public Address(String houseNumber, String postcode, String city) {
        this.houseNumber = houseNumber;
        this.postcode = postcode;
        this.city = city;
    }

//   getters
    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    // Method to get the full address in a single line
    public String getFullAddress() {
        return houseNumber + ", " + postcode + ", " + city;
    }

//    return the full address as a string
    @Override
    public String toString() {
        return getFullAddress();
    }
}
