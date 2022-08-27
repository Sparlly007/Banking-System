import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccountCreation {
    public void accountCreation1(JFrame f) {
		Components.birth = new nameAndBirthDay();
		Components.address = new BillingAddress();
		Components.b = new Balance();
		Components.pw = new Password();
		
		JPanel accountCreation = new JPanel();
		accountCreation.setLayout(null);
		
		JLabel name = new JLabel("Full Legal Name:");
		name.setBounds(10, 20, 120, 25);
		accountCreation.add(name);
		JTextField nameText = new JTextField();
		nameText.setBounds(120, 20, 165, 25);
		accountCreation.add(nameText);
		
		JLabel month = new JLabel("Birth Month:");
		month.setBounds(10, 45, 80, 25);
		accountCreation.add(month);
		JTextField monthText = new JTextField();
		monthText.setBounds(120, 45, 165, 25);
		accountCreation.add(monthText);
		
		JLabel day = new JLabel("Birth Day:");
		day.setBounds(10, 70, 80, 25);
		accountCreation.add(day);
		JTextField dayText = new JTextField();
		dayText.setBounds(120, 70, 20, 25);
		accountCreation.add(dayText);
		
		JLabel year = new JLabel("Birth Year:");
		year.setBounds(10, 95, 80, 25);
		accountCreation.add(year);
		JTextField yearText = new JTextField();
		yearText.setBounds(120, 95, 165, 25);
		accountCreation.add(yearText);

		JLabel street = new JLabel("Address:");
		street.setBounds(10, 120, 80, 25);
		accountCreation.add(street);
		JTextField streetText = new JTextField();
		streetText.setBounds(120, 120, 165, 25);
		accountCreation.add(streetText);

		JLabel town = new JLabel("Town:");
		town.setBounds(10, 145, 80, 25);
		accountCreation.add(town);
		JTextField townText = new JTextField();
		townText.setBounds(120, 145, 165, 25);
		accountCreation.add(townText);
		
		JLabel number = new JLabel("Phone Number:");
		number.setBounds(10, 170, 200, 25);
		accountCreation.add(number);
		JTextField numberText = new JTextField();
		numberText.setBounds(120, 170, 165, 25);
		accountCreation.add(numberText);
		
		JLabel password = new JLabel("New Password:");
		password.setBounds(10, 195, 200, 25);
		accountCreation.add(password);
		JTextField pText = new JTextField();
		pText.setBounds(120, 195, 165, 25);
		accountCreation.add(pText);
		
		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(10, 275, 220, 25);
		accountCreation.add(empty);
		empty.setVisible(false);
		
		JLabel incorrect = new JLabel("One of your inputs is not in the correct format");
		incorrect.setBounds(10, 285, 165, 25);
		accountCreation.add(incorrect);
		incorrect.setVisible(false);

		JLabel incorrectPW = new JLabel("Password is already taken");
		incorrectPW.setBounds(10, 295, 300, 25);
		accountCreation.add(incorrectPW);
		incorrectPW.setVisible(false);
		
		JButton createAccount = new JButton("Create Account");
		createAccount.setBounds(10, 220, 130, 25);
		createAccount.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	 if(nameText.getText().isEmpty() || monthText.getText().isEmpty() 
	           			   || dayText.getText().isEmpty() || yearText.getText().isEmpty() 
						   || streetText.getText().isEmpty() || townText.getText().isEmpty() || 
						   numberText.getText().isEmpty() || pText.getText().isEmpty()) {
	        			 empty.setVisible(true);
	           	   	  }else {
	           	   		  empty.setVisible(false);
						  if(Components.pw.contains(pText.getText()))
							incorrectPW.setVisible(true);
						  else{
	           	   		  Components.birth.inputName(nameText.getText());
						  Components.birth.putBirth(monthText.getText(), dayText.getText(), yearText.getText());
						  Components.address.putAddress(streetText.getText());
						  Components.address.putTown(townText.getText());
						  Components.address.putPhone(numberText.getText());Components.pw.putPW(pText.getText());
						  accountCreation.setVisible(false);
						  new QBalance().qBalance(f);
	           	   		  f.getContentPane().remove(accountCreation);
	           	   		  accountCreation.removeAll();
	           	   	  }
					}
	        		}
				});
		accountCreation.add(createAccount);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 250, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	accountCreation.setVisible(false);
                Components comp = new Components();
	        	comp.bankingEntry(f);
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
	Components.address = new BillingAddress();
	Components.b = new Balance();
	Components.pw = new Password();
	JPanel accountCreation = new JPanel();
	accountCreation.setLayout(null);
	
	JLabel street = new JLabel("Address:");
	street.setBounds(10, 20, 80, 25);
	accountCreation.add(street);
	JTextField streetText = new JTextField();
	streetText.setBounds(110, 20, 165, 25);
	accountCreation.add(streetText);

	JLabel town = new JLabel("Town:");
	town.setBounds(10, 45, 80, 25);
	accountCreation.add(town);
	JTextField townText = new JTextField();
	townText.setBounds(110, 45, 165, 25);
	accountCreation.add(townText);
	
	JLabel number = new JLabel("Phone Number:");
	number.setBounds(10, 70, 200, 25);
	accountCreation.add(number);
	JTextField numberText = new JTextField();
	numberText.setBounds(110, 70, 165, 25);
	accountCreation.add(numberText);
	
	JLabel password = new JLabel("New Password:");
	password.setBounds(10, 95, 200, 25);
	accountCreation.add(password);
	JTextField pText = new JTextField();
	pText.setBounds(110, 95, 165, 25);
	accountCreation.add(pText);

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
			if(streetText.getText().isEmpty() || townText.getText().isEmpty() || 
					 numberText.getText().isEmpty()){
				empty.setVisible(true);
			}else {
			  empty.setVisible(false);
			  if(Components.pw.contains(pText.getText()))
				  incorrectPW.setVisible(true);
			  else {	  
			   //address.putHouseNumber(Integer.parseInt(houseText.getText()));
			   //address.putStreetName(streetText.getText());
			   Components.address.putAddress(streetText.getText());
			   //address.putTownName(townText.getText());
			   //address.putStateName(stateText.getText());
			   Components.address.putTown(townText.getText());
			   Components.address.putPhone(numberText.getText());
			   //Components.account = new User(Components.birth, Components.address, pText.getText(), Components.b);
			   //Components.account.add(Components.account);
			   //Components.pw.add(pText.getText(), new User(Components.birth, Components.address, Components.b));
			   Components.pw.putPW(pText.getText());
			  accountCreation.setVisible(false);
			   new QBalance().qBalance(f);
			   f.getContentPane().remove(accountCreation);
			   accountCreation.removeAll();
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
			AccountCreation create = new AccountCreation();
			create.accountCreation1(f);
			f.getContentPane().remove(accountCreation);
			accountCreation.removeAll();
			}
		});
	accountCreation.add(back);
	
	f.add(accountCreation);
	accountCreation.setVisible(true);
}
}
