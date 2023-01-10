package AccountEntity;
public class Balance{
	public double savingsBalance = 0;
	public double checkingBalance = 0;

	public Balance(double savings, double checking){
		this.savingsBalance = savings;
		this.checkingBalance = checking;
	}
	
	public void depositToSavings(double deposit) {
		savingsBalance += deposit;
	}
	
	public void depositToChecking(double deposit) {
		checkingBalance += deposit;
	}
	
	public void withdrawFromChecking(double withdraw) {
		if(checkingBalance - withdraw < 0)
			checkingBalance = 0;
		checkingBalance -= withdraw;
	}
	
	public void withdrawFromSavings(double withdraw) {
		if(savingsBalance - withdraw < 0)
			savingsBalance = 0;
		savingsBalance -= withdraw;
	}
	
	public String savingsToChecking(double transfer) {
		savingsBalance -= transfer;
		checkingBalance += transfer;
		return "Savings Balance: $" + savingsBalance + "; Checking Balance: $" + checkingBalance;
	}
	
	public String checkingToSavings(double transfer) {
		checkingBalance -= transfer;
		savingsBalance += transfer;
		return "Savings Balance: $" + savingsBalance + "; Checking Balance: $" + checkingBalance;
	}
	
	public double cBalance() {
		return checkingBalance;
	}
	
	public double sBalance() {
		return savingsBalance;
	}
}
