import java.io.Serializable;

public class Balance implements Serializable{
	public float savingsBalance = 0;
	public float checkingBalance = 0;
	
	public void depositToSavings(float deposit) {
		savingsBalance += deposit;
	}
	
	public void depositToChecking(float deposit) {
		checkingBalance += deposit;
	}
	
	public void withdrawFromChecking(float withdraw) {
		checkingBalance -= withdraw;
	}
	
	public void withdrawFromSavings(float withdraw) {
		savingsBalance -= withdraw;
	}
	
	public String savingsToChecking(float transfer) {
		savingsBalance -= transfer;
		checkingBalance += transfer;
		return "Savings Balance: $" + savingsBalance + "; Checking Balance: $" + checkingBalance;
	}
	
	public String checkingToSavings(float transfer) {
		checkingBalance -= transfer;
		savingsBalance += transfer;
		return "Savings Balance: $" + savingsBalance + "; Checking Balance: $" + checkingBalance;
	}
	
	public float cBalance() {
		return checkingBalance;
	}
	
	public float sBalance() {
		return savingsBalance;
	}
}
