import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.DriverManager;
import java.sql.*;


public class Signin {
	public static void getAccount(Password pw){
		nameAndBirthDay nameBirth = new nameAndBirthDay();
		BillingAddress billing = new BillingAddress();
		Balance bl = new Balance();
        String name = "";
        String birth = "";
		String address = "";
		String phone = "";
		String ss = "";
		int checking = 0;
		int savings = 0;
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "Asdfghjkl;1!");
			Statement myStmt = myConn.createStatement();
			ResultSet rs=myStmt.executeQuery("select * from accounts where pw like '" + pw.getPW() + "'");
			while(rs.next()){
                name = rs.getString("name");
                birth = rs.getString("birth");
				address = rs.getString("address");
				phone = rs.getString("phone");
				checking = rs.getInt("checking");
				savings = rs.getInt("savings");
            }
		}catch (Exception exc){
			exc.printStackTrace();
		}

		nameBirth.inputName(name);
		nameBirth.putBirth(birth);
		billing.putAddress(address);
		billing.putPhone(phone);
		billing.putSS(ss);
		bl.checkingBalance = checking;
		bl.savingsBalance = savings;
		Components.account = new User(nameBirth, billing, pw, bl);
	}


    public void signin(JFrame f) {
		Components.pw = new Password();
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel label = new JLabel("Insert Password");
		label.setBounds(10, 20, 300, 25);
		panel.add(label);
		JTextField text = new JTextField();
		text.setBounds(10, 40, 165, 25);
		panel.add(text);
		
		JLabel incorrect = new JLabel("Password does not exist.");
		incorrect.setBounds(10, 120, 300, 25);
		panel.add(incorrect);
		incorrect.setVisible(false);

		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(10, 120, 220, 25);
		panel.add(empty);
		empty.setVisible(false);
		
		JButton button = new JButton("Sign In");
		button.setBounds(10, 70, 165, 25);
		button.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
			  if(text.getText().isEmpty())
				empty.setVisible(true);
			  else{
				empty.setVisible(false);
	          if(!(Components.pw.contains(text.getText())))
	        	  incorrect.setVisible(true);
	          else {
				Components.pw.putPW(text.getText());
	        	getAccount(Components.pw);
	        	panel.setVisible(false);
	        	new BalancePage().balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	           }
			   }
	          }
			});
		panel.add(button);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 100, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	Components.bankingEntry(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
}
