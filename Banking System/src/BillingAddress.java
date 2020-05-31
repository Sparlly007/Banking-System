import java.io.Serializable;

public class BillingAddress implements Serializable{
	public int houseNumber = 0;
	public String streetName = "";
	public String town = "";
	public String state = "";
	public long phoneNumber = 0;
	public long sSecurity = 0;
	
	public void putHouseNumber(int number) {
		this.houseNumber = number;
	}
	
	public void putStreetName(String name) {
		this.streetName = name;
	}
	
	public void putTownName(String town) {
		this.town = town;
	}
	
	public void putStateName(String state) {
		this.state = state;
	}
	
	public String printBillingAddress() {
		String number = Integer.toString(houseNumber);
		return number + " " + streetName + ", " + town + ", " + state;
	}
	
	public void putPhoneNumber(long number) {
		this.phoneNumber = number;
	}
	
	public long printPhoneNumber() {
		return phoneNumber;
	}
	
	public void inputSocialSecurity(long number) {
		sSecurity = number;
	}
	
	public long getSocialSecurity() {
		return sSecurity;
	}
}
