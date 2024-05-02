package nncnpm.Model;

/**
 * Class representing details about a business partner.
 */
public class Partner29 {
    private int partnerId;
    private String partnerName;
    private String address; // Additional detail example
    private String contactNumber; // Additional detail example

    // Constructor with all attributes
    public Partner29(int partnerId, String partnerName, String address, String contactNumber) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    // Getters
    public int getPartnerId() {
        return partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    // Setters
    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
