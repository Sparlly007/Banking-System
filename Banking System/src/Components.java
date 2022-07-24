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
	static nameAndBirthDay birth;
	static BillingAddress address;
	static Balance b;
	static Password pw;
	static User account;
	
	public static void bankingEntry(JFrame f) {
		JPanel entry = new JPanel();
		entry.setLayout(null);
		//Sets up creating the entry page for the banking account 
		JButton newAccount = new JButton("Create New Account");
		newAccount.setBounds(10, 80, 300, 25);
		newAccount.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	   entry.setVisible(false);
	        	   new AccountCreation().accountCreation1(f);
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
	        	   new Signin().signin(f);  
	        	   f.getContentPane().remove(entry);
	        	   entry.removeAll();
	        }
	    });
		entry.add(existingAccount);
		
		f.add(entry);
		entry.setVisible(true);
		}
}
