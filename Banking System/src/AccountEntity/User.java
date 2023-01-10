package AccountEntity;

import java.util.LinkedList;
import java.sql.DriverManager;
import java.sql.*;

public class User {
	private long id = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
	private String name;
	private String email;
	private String password;
	Balance b;

	// nameAndBirthDay birth;
	// BillingAddress billing;
	// //NameAndSSecurity nameandSecurity;
	// Balance b;
	// Password password;

	public LinkedList<Double> cTransactions = new LinkedList<Double>();
	public LinkedList<Double> sTransactions = new LinkedList<Double>();

	public User(String name, String email, String pw) {
		this.name = name;
		this.email = email;
		this.password = pw;
	}

	public User(String name, String email, String password, Balance b) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.b = b;
	}

	public String cTrans() {
		String trans = "";

		for (Double i : cTransactions) {
			String j = Double.toString(i);
			trans += j;
			trans += "\n";
		}
		return trans;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Balance getBalance() {
		return b;
	}

	public void depositToChecking(Double deposit) {
		b.depositToChecking(deposit);
		this.cTransactions.addLast(deposit);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBalance(Balance b) {
		this.b = b;
	}

	public void depositToSavings(Double deposit) {
		b.depositToSavings(deposit);
		this.sTransactions.addLast(deposit);
	}

	public void withdrawFromChecking(Double withdraw) {
		b.withdrawFromChecking(withdraw);
		this.cTransactions.addLast(-1 * withdraw);
	}

	public void withdrawFromSavings(Double withdraw) {
		b.withdrawFromSavings(withdraw);
		this.sTransactions.addLast(-1 * withdraw);
	}

	public Double getCBalance() {
		return b.cBalance();
	}

	public Double getSBalance() {
		return b.sBalance();
	}
}
