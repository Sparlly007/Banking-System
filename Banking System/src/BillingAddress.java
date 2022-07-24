public class BillingAddress {
	public String address = "";
	public String town = "";
	public String phoneNumber = "";
	public String sSecurity = "";

	public void putAddress(String name) {
		this.address = name;
	}

	public void putTown(String name) {
		this.town = name;
	}
	
	public String getAddress() {
		return address + ", " + town;
	}
	
	public void putPhone(String number) {
		this.phoneNumber = number;
	}
	
	public String getPhone() {
		return phoneNumber;
	}

	public void putSS(String number) {
		sSecurity = number;
	}
	
	public String getSS() {
		return sSecurity;
	}
}
