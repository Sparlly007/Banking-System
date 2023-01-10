package AccountCreation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AccountEntity.Balance;
import AccountEntity.Password;
import AccountEntity.User;
import BankActions.BalancePage;
import Service.Service;

import java.sql.DriverManager;
import java.sql.*;


public class Signin {

	Service service;

	//Creates signin page
    public void signin(JFrame f) {
		service = new Service();
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
	        	Components.account = service.getUser(text.getText());
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
