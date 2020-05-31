import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Components {
	nameAndBirthDay birth;
	BillingAddress address;
	Balance b;
	Password pw;
	String currPassword = "";
	User account;
	
	public void bankingEntry(JFrame f) {
		try {
		FileInputStream fin = new FileInputStream("Test.txt");
		ObjectInputStream ois = new ObjectInputStream(fin);
		pw = (Password) ois.readObject();
		ois.close();
		}catch (Exception ex) {
            ex.printStackTrace();
        }
		JPanel entry = new JPanel();
		entry.setLayout(null);
		//Sets up creating the entry page for the banking account 
		JButton newAccount = new JButton("Create New Account");
		newAccount.setBounds(10, 80, 300, 25);
		newAccount.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	   entry.setVisible(false);
	        	   accountCreation1(f);
	        	   f.getContentPane().remove(entry);
	        	   entry.removeAll();
	        }
	    });
		entry.add(newAccount);
		
		JButton existingAccount = new JButton("Sign in");
		existingAccount.setBounds(10, 100, 300, 25);
		existingAccount.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	   entry.setVisible(false);
	        	   signin(f);  
	        	   f.getContentPane().remove(entry);
	        	   entry.removeAll();
	        }
	    });
		entry.add(existingAccount);
		
		f.add(entry);
		entry.setVisible(true);
	}
	
	///Input name and birthday
	public void accountCreation1(JFrame f) {
		birth = new nameAndBirthDay();
		
		JPanel accountCreation = new JPanel();
		accountCreation.setLayout(null);
		
		JLabel name = new JLabel("Name:");
		name.setBounds(10, 20, 80, 25);
		accountCreation.add(name);
		JTextField nameText = new JTextField();
		nameText.setBounds(100, 20, 165, 25);
		accountCreation.add(nameText);
		
		JLabel month = new JLabel("Birth Month:");
		month.setBounds(10, 45, 80, 25);
		accountCreation.add(month);
		JTextField monthText = new JTextField();
		monthText.setBounds(100, 45, 165, 25);
		accountCreation.add(monthText);
		
		JLabel day = new JLabel("Birth Day:");
		day.setBounds(10, 70, 80, 25);
		accountCreation.add(day);
		JTextField dayText = new JTextField();
		dayText.setBounds(100, 70, 20, 25);
		accountCreation.add(dayText);
		
		JLabel year = new JLabel("Birth Year:");
		year.setBounds(10, 95, 80, 25);
		accountCreation.add(year);
		JTextField yearText = new JTextField();
		yearText.setBounds(100, 95, 165, 25);
		accountCreation.add(yearText);
		
		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(100, 125, 165, 25);
		accountCreation.add(empty);
		empty.setVisible(false);
		
		JLabel incorrect = new JLabel("One of your inputs is not in the correct format");
		incorrect.setBounds(100, 125, 165, 25);
		accountCreation.add(incorrect);
		incorrect.setVisible(false);
		
		JButton continueCreation = new JButton("Continue");
		continueCreation.setBounds(100, 120, 80, 25);
		continueCreation.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	 if(nameText.getText().isEmpty() || monthText.getText().isEmpty() 
	           			   || dayText.getText().isEmpty() || yearText.getText().isEmpty()) {
	        			 empty.setVisible(true);
	           	   	  }else {
	           	   		  empty.setVisible(false);
	           	   		  birth.inputName(nameText.getText());
	           	   		  birth.putBirthMonth(monthText.getText());
	           	   		  birth.putBirthDate(Integer.parseInt(dayText.getText()));
	           	   		  birth.putBirthYear(Integer.parseInt(yearText.getText()));
	           	   		  accountCreation.setVisible(false);
	           	   		  accountCreation2(f);
	           	   		  f.getContentPane().remove(accountCreation);
	           	   		  accountCreation.removeAll();
	           	   	  }
	        		}
				});
		accountCreation.add(continueCreation);
		
		JButton back = new JButton("Back");
		back.setBounds(100, 150, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	accountCreation.setVisible(false);
	        	bankingEntry(f);
	        	f.getContentPane().remove(accountCreation);
	        	accountCreation.removeAll();
	        	}
			});
		accountCreation.add(back);
		
		
		f.add(accountCreation);
		accountCreation.setVisible(true);
	}
	
	///Input billing address, phone number, social security number, and password
	public void accountCreation2(JFrame f) {
		address = new BillingAddress();
		b = new Balance();
		JPanel accountCreation = new JPanel();
		accountCreation.setLayout(null);
		
		JLabel house = new JLabel("House Number:");
		house.setBounds(10, 20, 80, 25);
		accountCreation.add(house);
		JTextField houseText = new JTextField();
		houseText.setBounds(100, 20, 165, 25);
		accountCreation.add(houseText);
		
		JLabel street = new JLabel("Street Name:");
		street.setBounds(10, 45, 80, 25);
		accountCreation.add(street);
		JTextField streetText = new JTextField();
		streetText.setBounds(100, 45, 165, 25);
		accountCreation.add(streetText);
		
		JLabel town = new JLabel("Town");
		town.setBounds(10, 70, 80, 25);
		accountCreation.add(town);
		JTextField townText = new JTextField();
		townText.setBounds(100, 70, 165, 25);
		accountCreation.add(townText);
		
		JLabel state = new JLabel("State:");
		state.setBounds(10, 95, 80, 25);
		accountCreation.add(state);
		JTextField stateText = new JTextField();
		stateText.setBounds(100, 95, 165, 25);
		accountCreation.add(stateText);
		
		JLabel number = new JLabel("Phone Number:");
		number.setBounds(10, 120, 200, 25);
		accountCreation.add(number);
		JTextField numberText = new JTextField();
		numberText.setBounds(100, 120, 165, 25);
		accountCreation.add(numberText);
		
		JLabel SSNumber = new JLabel("Social Security Number:");
		SSNumber.setBounds(10, 145, 200, 25);
		accountCreation.add(SSNumber);
		JTextField SSText = new JTextField();
		SSText.setBounds(100, 145, 165, 25);
		accountCreation.add(SSText);
		
		JLabel password = new JLabel("New Password:");
		password.setBounds(10, 170, 200, 25);
		accountCreation.add(password);
		JTextField pText = new JTextField();
		pText.setBounds(100, 170, 165, 25);
		accountCreation.add(pText);
		
		JLabel incorrectSS = new JLabel("Incorrect Social Security Number");
		incorrectSS.setBounds(100, 220, 200, 25);
		accountCreation.add(incorrectSS);
		incorrectSS.setVisible(false);

		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(100, 220, 200, 25);
		accountCreation.add(empty);
		empty.setVisible(false);
		
		JLabel incorrectPW = new JLabel("Password is already taken");
		incorrectPW.setBounds(100, 240, 300, 25);
		accountCreation.add(incorrectPW);
		incorrectPW.setVisible(false);
		
		JButton continueCreation = new JButton("Continue");
		continueCreation.setBounds(100, 190, 80, 25);
		continueCreation.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	if(houseText.getText().isEmpty() || streetText.getText().isEmpty() || stateText.getText().isEmpty()
	        			|| numberText.getText().isEmpty() || SSText.getText().isEmpty()){
	        		empty.setVisible(true);
	        	}else {
	        	  empty.setVisible(false);
	        	  if(SSText.getText().length() != 9)
	        		  incorrectSS.setVisible(true);
	        	  else {
	        	   incorrectSS.setVisible(false);
	        	   
	        	  if(pw.contains(pText.getText()))
	        		  incorrectPW.setVisible(true);
	        	  else {	  
	               address.putHouseNumber(Integer.parseInt(houseText.getText()));
	               address.putStreetName(streetText.getText());
	               address.putTownName(townText.getText());
	               address.putStateName(stateText.getText());
	               address.putPhoneNumber(Long.parseLong(numberText.getText()));
	               address.inputSocialSecurity(Long.parseLong(SSText.getText()));
	               pw.add(pText.getText(), new User(birth, address, b));
	               currPassword = pText.getText();
	               accountCreation.setVisible(false);
	               qBalance(f);
	               f.getContentPane().remove(accountCreation);
	               accountCreation.removeAll();
	        	  }
	        	  }
	        	}
	        }
	    });
		accountCreation.add(continueCreation);
		
		JButton back = new JButton("Back");
		back.setBounds(100, 210, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	accountCreation.setVisible(false);
	        	accountCreation1(f);
	        	f.getContentPane().remove(accountCreation);
	        	accountCreation.removeAll();
	        	}
			});
		accountCreation.add(back);
		
		f.add(accountCreation);
		accountCreation.setVisible(true);
	}
	
	///Decide the starting checking balance that should be at least $150
	public void qBalance(JFrame f) {
		User account = pw.get(currPassword);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel cQ1 = new JLabel("Starting Checking Balance (Minumum: $150.00)");
		cQ1.setBounds(10, 20, 300, 25);
		panel.add(cQ1);
		JTextField cText = new JTextField();
		cText.setBounds(10, 40, 165, 25);
		panel.add(cText);
		
		JLabel sQ1 = new JLabel("Starting Savings Balance (Minumum: $500.00)");
		sQ1.setBounds(10, 60, 300, 25);
		panel.add(sQ1);
		JTextField sText = new JTextField();
		sText.setBounds(10, 80, 165, 25);
		panel.add(sText);
		
		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(100, 200, 300, 25);
		panel.add(empty);
		empty.setVisible(false);
		
		JLabel tSmall = new JLabel("Insufficient amount of funds");
		tSmall.setBounds(100, 220, 300, 25);
		panel.add(tSmall);
		tSmall.setVisible(false);
		
		JButton forward = new JButton("Continue");
		forward.setBounds(100, 140, 80, 25);
		forward.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	if(cText.getText().isEmpty())
	        		empty.setVisible(true);
	        	else {
	        		empty.setVisible(false);
	        		
	        		if(Float.parseFloat(cText.getText()) < 150 || Float.parseFloat(sText.getText()) < 500)
	        			tSmall.setVisible(true);
	        		else {
		        		account.depositToChecking(Float.parseFloat(cText.getText()));
		        		account.depositToSavings(Float.parseFloat(sText.getText()));
		        		panel.setVisible(false);
		        		balancePage(f);
		        		f.getContentPane().remove(panel);
			        	panel.removeAll();
	        		  }
		        	}
	        	}
			});
		panel.add(forward);
		
		JButton back = new JButton("Back");
		back.setBounds(100, 180, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	accountCreation2(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public void signin(JFrame f) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label = new JLabel("Insert Password");
		label.setBounds(10, 20, 300, 25);
		panel.add(label);
		JTextField text = new JTextField();
		text.setBounds(10, 40, 165, 25);
		panel.add(text);
		
		JLabel incorrect = new JLabel("Password does not exist.");
		incorrect.setBounds(10, 100, 300, 25);
		panel.add(incorrect);
		incorrect.setVisible(false);
		
		JButton button = new JButton("Sign In");
		button.setBounds(10, 70, 165, 25);
		button.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	          if(!(pw.contains(text.getText()))) {
	        	  incorrect.setVisible(true);
	          }else {
	        	//account = pw.get(text.getText());
	        	currPassword = text.getText();
	        	panel.setVisible(false);
	        	balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	           }
	          }
			});
		panel.add(button);
		
		JButton back = new JButton("Back");
		back.setBounds(100, 150, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	bankingEntry(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public void balancePage(JFrame f) {
		User account = pw.get(currPassword);
		JPanel balance = new JPanel();
		balance.setLayout(null);
		
		JLabel cLabel = new JLabel("Checking:");
		cLabel.setBounds(10, 20, 80, 25);
		balance.add(cLabel);
		JLabel cBalance = new JLabel(Float.toString(account.cBalance()));
		cBalance.setBounds(10, 35, 80, 25);
		balance.add(cBalance);
		
		JLabel sLabel = new JLabel("Savings:");
		sLabel.setBounds(200, 20, 80, 25);
		balance.add(sLabel);
		JLabel sBalance = new JLabel(Float.toString(account.sBalance()));
		sBalance.setBounds(200, 35, 80, 25);
		balance.add(sBalance);
		
		JButton background = new JButton("Account Summary");
		background.setBounds(10, 60, 200, 25);
		background.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	accountSummary(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(background);
		
		JButton checkDeposit = new JButton("Deposit to Checking Account");
		checkDeposit.setBounds(10, 90, 200, 25);
		checkDeposit.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	checkingDeposit(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(checkDeposit);
		
		JButton savingsDeposit = new JButton("Deposit to Savings Account");
		savingsDeposit.setBounds(10, 120, 200, 25);
		savingsDeposit.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	savingsDeposit(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(savingsDeposit);
		
		JButton checkingWithdraw = new JButton("Withdraw from Checking Account");
		checkingWithdraw.setBounds(10, 150, 200, 25);
		checkingWithdraw.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	checkingWithdraw(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(checkingWithdraw);
		
		JButton savingsWithdraw = new JButton("Withdraw from Savings Account");
		savingsWithdraw.setBounds(10, 180, 200, 25);
		savingsWithdraw.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	savingsWithdraw(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(savingsWithdraw);
		
		JButton cTransactions = new JButton("Checking Account Transactions");
		cTransactions.setBounds(10, 210, 200, 25);
		cTransactions.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	cTransHistory(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(cTransactions);
		
		JButton signout = new JButton("Sign Out");
		signout.setBounds(10, 240, 200, 25);
		signout.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	pw.add(currPassword, account);
	        	currPassword = "";
	        	try {
					FileOutputStream fos = new FileOutputStream("Test.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(pw);
					oos.close();
					}catch (Exception ex) {
			            ex.printStackTrace();
			        }
	        	balance.setVisible(false);
	        	bankingEntry(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(signout);
		
		f.add(balance);
		balance.setVisible(true);
	}
	
	public void accountSummary(JFrame f) {
		User account = pw.get(currPassword);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel summary = new JLabel("Account Summary:");
		summary.setBounds(80, 20, 500, 25);
		panel.add(summary);
		
		JLabel name = new JLabel("Name: " + account.getName());
		name.setBounds(10, 35, 500, 25);
		panel.add(name);
		
		JLabel birthday = new JLabel("Birthday: " + account.getBirthDay());
		birthday.setBounds(10, 55, 500, 25);
		panel.add(birthday);
		
		JLabel address = new JLabel("Billing address: " + account.getBillingAddress());
		address.setBounds(10, 75, 500, 25);
		panel.add(address);
		
		JLabel pNumber = new JLabel("Phone Number: " + Long.toString(account.getPhoneNumber()));
		pNumber.setBounds(10, 95, 500, 25);
		panel.add(pNumber);
		
		//Make sure to return last four digits
		JLabel SSNumber = new JLabel("Social Security Number: " + Long.toString(account.getSocialSecurity()));
		SSNumber.setBounds(10, 115, 500, 25);
		panel.add(SSNumber);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 135, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public void checkingDeposit(JFrame f) {
		User account = pw.get(currPassword);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel cQ1 = new JLabel("Checking Deposit (Minumum: $10.00)");
		cQ1.setBounds(10, 20, 300, 25);
		panel.add(cQ1);
		JTextField cText = new JTextField();
		cText.setBounds(10, 40, 165, 25);
		panel.add(cText);
		
		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(100, 100, 165, 25);
		panel.add(empty);
		empty.setVisible(false);
		
		JLabel tSmall = new JLabel("Insufficient funds");
		tSmall.setBounds(100, 115, 165, 25);
		panel.add(tSmall);
		tSmall.setVisible(false);
		
		JButton forward = new JButton("Continue");
		forward.setBounds(10, 60, 80, 25);
		forward.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	if(cText.getText().isEmpty())
	        		empty.setVisible(true);
	        	else {
	        		empty.setVisible(false);
	        		
	        		if(Float.parseFloat(cText.getText()) < 10)
	        			tSmall.setVisible(true);
	        		else {
		        		account.depositToChecking(Float.parseFloat(cText.getText()));
		        		panel.setVisible(false);
		        		balancePage(f);
		        		f.getContentPane().remove(panel);
			        	panel.removeAll();
	        		  }
		        	}
	        	}
			});
		panel.add(forward);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 80, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public void savingsDeposit(JFrame f) {
		User account = pw.get(currPassword);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel sQ1 = new JLabel("Savings Deposit (Minumum: $50.00)");
		sQ1.setBounds(10, 20, 300, 25);
		panel.add(sQ1);
		JTextField sText = new JTextField();
		sText.setBounds(10, 40, 165, 25);
		panel.add(sText);
		
		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(100, 100, 165, 25);
		panel.add(empty);
		empty.setVisible(false);
		
		JLabel tSmall = new JLabel("Insufficient funds");
		tSmall.setBounds(100, 115, 165, 25);
		panel.add(tSmall);
		tSmall.setVisible(false);
		
		JButton forward = new JButton("Continue");
		forward.setBounds(10, 60, 80, 25);
		forward.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	if(sText.getText().isEmpty())
	        		empty.setVisible(true);
	        	else {
	        		empty.setVisible(false);
	        		
	        		if(Float.parseFloat(sText.getText()) < 10)
	        			tSmall.setVisible(true);
	        		else {
		        		account.depositToSavings(Float.parseFloat(sText.getText()));
		        		panel.setVisible(false);
		        		balancePage(f);
		        		f.getContentPane().remove(panel);
			        	panel.removeAll();
	        		  }
		        	}
	        	}
			});
		panel.add(forward);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 80, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public void checkingWithdraw(JFrame f) {
		User account = pw.get(currPassword);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel cQ1 = new JLabel("Checking Withdraw (Minumum: $20.00)");
		cQ1.setBounds(10, 20, 300, 25);
		panel.add(cQ1);
		JTextField cText = new JTextField();
		cText.setBounds(10, 40, 165, 25);
		panel.add(cText);
		
		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(100, 100, 165, 25);
		panel.add(empty);
		empty.setVisible(false);
		
		JLabel tSmall = new JLabel("Insufficient funds");
		tSmall.setBounds(100, 115, 165, 25);
		panel.add(tSmall);
		tSmall.setVisible(false);
		
		JButton forward = new JButton("Continue");
		forward.setBounds(10, 60, 80, 25);
		forward.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	if(cText.getText().isEmpty())
	        		empty.setVisible(true);
	        	else {
	        		empty.setVisible(false);
	        		
	        		if(Float.parseFloat(cText.getText()) < 20)
	        			tSmall.setVisible(true);
	        		else {
		        		account.withdrawFromChecking(Float.parseFloat(cText.getText()));
		        		panel.setVisible(false);
		        		balancePage(f);
		        		f.getContentPane().remove(panel);
			        	panel.removeAll();
	        		  }
		        	}
	        	}
			});
		panel.add(forward);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 80, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public void savingsWithdraw(JFrame f) {
		User account = pw.get(currPassword);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel cQ1 = new JLabel("Savings Withdraw (Minumum: $20.00)");
		cQ1.setBounds(10, 20, 300, 25);
		panel.add(cQ1);
		JTextField cText = new JTextField();
		cText.setBounds(10, 40, 165, 25);
		panel.add(cText);
		
		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(100, 100, 165, 25);
		panel.add(empty);
		empty.setVisible(false);
		
		JLabel tSmall = new JLabel("Insufficient funds");
		tSmall.setBounds(100, 115, 165, 25);
		panel.add(tSmall);
		tSmall.setVisible(false);
		
		JButton forward = new JButton("Continue");
		forward.setBounds(10, 60, 80, 25);
		forward.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	if(cText.getText().isEmpty())
	        		empty.setVisible(true);
	        	else {
	        		empty.setVisible(false);
	        		
	        		if(Float.parseFloat(cText.getText()) < 10)
	        			tSmall.setVisible(true);
	        		else {
		        		account.withdrawFromSavings(Float.parseFloat(cText.getText()));
		        		panel.setVisible(false);
		        		balancePage(f);
		        		f.getContentPane().remove(panel);
			        	panel.removeAll();
	        		  }
		        	}
	        	}
			});
		panel.add(forward);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 80, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public void cTransHistory(JFrame f) {
		User account = pw.get(currPassword);
		JPanel panel =  new JPanel();
		panel.setLayout(null);
		
		JTextArea transactions = new JTextArea(account.cTrans(), 50, 300);
		transactions.setBounds(10, 40, 80, 300);
		panel.add(transactions);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 350, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public static void serializeDataOut(Password pw)throws IOException {
		String filename = "Test.txt";
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(pw);
		oos.close();
	}
	
	public static Password serializeDataIn() throws ClassNotFoundException, IOException{
		   String fileName= "Test.txt";
		   FileInputStream fin = new FileInputStream(fileName);
		   ObjectInputStream ois = new ObjectInputStream(fin);
		   Password pw= (Password) ois.readObject();
		   ois.close();
		   fin.close();
		   return pw;
		}
}
