import java.util.LinkedList;
import java.sql.DriverManager;
import java.sql.*;

public class User {
	public int accountNumber = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
	
	nameAndBirthDay birth;
	BillingAddress billing;
	//NameAndSSecurity nameandSecurity;
	Balance b;
	Password password;
	
	public LinkedList<Float> cTransactions = new LinkedList<Float>();
	public LinkedList<Float> sTransactions = new LinkedList<Float>();
	
	public User(nameAndBirthDay birthday, BillingAddress billingaddress, Password pw, Balance bl) {
		this.birth = birthday;
		this.billing = billingaddress;
		this.password = pw;
		this.b = bl;
	}

	public void add(User user){
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "Asdfghjkl;1!");
			Statement myStmt = myConn.createStatement();
			String sql = "insert into accounts " + " (pw, name, birth, address, phone, checking, savings)" + " values ('" 
			+ password.getPW() + "', '" + user.getName() + "', '" + user.getBirth() + "', '" + user.getAddress() + "', '" + user.getPhone() + "', '" 
			+ user.cBalance() + "', '" + user.sBalance() + "')";
         	myStmt.executeUpdate(sql);
		}catch (Exception exc){
			exc.printStackTrace();
		}
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
	
	public String getBirth() {
		return birth.getBirth();
	}
	
	public String getAddress() {
		return billing.getAddress();
	}
	
	public String getName() {
		return birth.getName();
	}
	
	public String getSS() {
		return billing.getSS();
	}
	
	public String getPhone() {
		return billing.getPhone();
	}

	public String getPW(){
		return password.getPW();
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
