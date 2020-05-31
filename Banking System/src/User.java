import java.io.Serializable;
import java.util.LinkedList;

public class User implements Serializable{
	public String password = "";
	public int accountNumber = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
	
	nameAndBirthDay birth;
	BillingAddress billing;
	NameAndSSecurity nameandSecurity;
	Balance b;
	
	public LinkedList<Float> cTransactions = new LinkedList<Float>();
	public LinkedList<Float> sTransactions = new LinkedList<Float>();
	
	public User(nameAndBirthDay birthday, BillingAddress billingaddress, Balance bl) {
		this.birth = birthday;
		this.billing = billingaddress;
		this.b = bl;
	}
	
	public String cTrans() {
		String trans = "";
		
		for(float i: cTransactions) {
			String j = Float.toString(i);
			trans += j;
			trans += "\n";
		}
		return trans;
	}
	
	public String getBirthDay() {
		return birth.printBirthDay();
	}
	
	public String getBillingAddress() {
		return billing.printBillingAddress();
	}
	
	public String getName() {
		return birth.getName();
	}
	
	public long getSocialSecurity() {
		return billing.getSocialSecurity();
	}
	
	public String printBirthDay() {
		return birth.printBirthDay();
	}
	
	public long getPhoneNumber() {
		return billing.printPhoneNumber();
	}
	
	public void depositToChecking(float deposit) {
		b.depositToChecking(deposit);
		this.cTransactions.addLast(deposit);
	}
	
	public void depositToSavings(float deposit) {
		b.depositToSavings(deposit);
		this.sTransactions.addLast(deposit);
	}
	
	public void withdrawFromChecking(float withdraw) {
		b.withdrawFromChecking(withdraw);
		this.cTransactions.addLast(-1*withdraw);
	}
	
	public void withdrawFromSavings(float withdraw) {
		b.withdrawFromSavings(withdraw);
		this.sTransactions.addLast(-1*withdraw);
	}
	
	public float cBalance() {
		return b.cBalance();
	}
	
	public float sBalance() {
		return b.sBalance();
	}
}
