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

import java.io.Serializable;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.sql.*;

public class AccountActions {
	public static void changeCBalance(){
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "Asdfghjkl;1!");
			Statement myStmt = myConn.createStatement();
			String sql = "update accounts set checking=" + Components.account.cBalance() + " where pw='" + Components.account.getPW() + "'";
			myStmt.executeUpdate(sql);
		}catch (Exception exc){
			exc.printStackTrace();
		}
	}

	public static void changeSBalance(){
		try{
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "Asdfghjkl;1!");
			Statement myStmt = myConn.createStatement();
			String sql = "update accounts set savings=" + Components.account.sBalance() + " where pw='" + Components.account.getPW() + "'";
			myStmt.executeUpdate(sql);
		}catch (Exception exc){
			exc.printStackTrace();
		}
	}

    public static void accountSummary(JFrame f) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel summary = new JLabel("Account Summary:");
		summary.setBounds(80, 20, 500, 25);
		panel.add(summary);
		
		JLabel name = new JLabel("Name: " + Components.account.getName());
		name.setBounds(10, 35, 500, 25);
		panel.add(name);
		
		JLabel birthday = new JLabel("Birthday: " + Components.account.getBirth());
		birthday.setBounds(10, 55, 500, 25);
		panel.add(birthday);
		
		JLabel address = new JLabel("Billing address: " + Components.account.getAddress());
		address.setBounds(10, 75, 500, 25);
		panel.add(address);
		
		JLabel pNumber = new JLabel("Phone Number: " + Components.account.getPhone());
		pNumber.setBounds(10, 95, 500, 25);
		panel.add(pNumber);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 115, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	new BalancePage().balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public static void checkingDeposit(JFrame f) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel cQ1 = new JLabel("Checking Deposit (Minumum: $10.00)");
		cQ1.setBounds(10, 20, 300, 25);
		panel.add(cQ1);
		JTextField cText = new JTextField();
		cText.setBounds(10, 40, 165, 25);
		panel.add(cText);
		
		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(10, 130, 250, 25);
		panel.add(empty);
		empty.setVisible(false);
		
		JLabel tSmall = new JLabel("Insufficient funds");
		tSmall.setBounds(10, 130, 165, 25);
		panel.add(tSmall);
		tSmall.setVisible(false);
		
		JButton forward = new JButton("Continue");
		forward.setBounds(10, 70, 110, 25);
		forward.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	if(cText.getText().isEmpty())
	        		empty.setVisible(true);
	        	else {
	        		empty.setVisible(false);
	        		
	        		if(Float.parseFloat(cText.getText()) < 10)
	        			tSmall.setVisible(true);
	        		else {
		        		Components.account.depositToChecking(Float.parseFloat(cText.getText()));
						changeCBalance();
		        		panel.setVisible(false);
		        		new BalancePage().balancePage(f);
		        		f.getContentPane().remove(panel);
			        	panel.removeAll();
	        		  }
		        	}
	        	}
			});
		panel.add(forward);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 100, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	new BalancePage().balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public static void savingsDeposit(JFrame f) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel sQ1 = new JLabel("Savings Deposit (Minumum: $50.00)");
		sQ1.setBounds(10, 20, 300, 25);
		panel.add(sQ1);
		JTextField sText = new JTextField();
		sText.setBounds(10, 40, 165, 25);
		panel.add(sText);
		
		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(10, 130, 250, 25);
		panel.add(empty);
		empty.setVisible(false);
		
		JLabel tSmall = new JLabel("Insufficient funds");
		tSmall.setBounds(10, 130, 165, 25);
		panel.add(tSmall);
		tSmall.setVisible(false);
		
		JButton forward = new JButton("Continue");
		forward.setBounds(10, 70, 110, 25);
		forward.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	if(sText.getText().isEmpty())
	        		empty.setVisible(true);
	        	else {
	        		empty.setVisible(false);
	        		
	        		if(Float.parseFloat(sText.getText()) < 50)
	        			tSmall.setVisible(true);
	        		else {
		        		Components.account.depositToSavings(Float.parseFloat(sText.getText()));
						changeSBalance();
		        		panel.setVisible(false);
		        		new BalancePage().balancePage(f);
		        		f.getContentPane().remove(panel);
			        	panel.removeAll();
	        		  }
		        	}
	        	}
			});
		panel.add(forward);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 100, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	new BalancePage().balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public static void checkingWithdraw(JFrame f) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel cQ1 = new JLabel("Checking Withdraw (Minumum: $20.00)");
		cQ1.setBounds(10, 20, 300, 25);
		panel.add(cQ1);
		JTextField cText = new JTextField();
		cText.setBounds(10, 40, 165, 25);
		panel.add(cText);
		
		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(10, 130, 250, 25);
		panel.add(empty);
		empty.setVisible(false);
		
		JLabel tSmall = new JLabel("Insufficient funds");
		tSmall.setBounds(10, 130, 165, 25);
		panel.add(tSmall);
		tSmall.setVisible(false);
		
		JButton forward = new JButton("Continue");
		forward.setBounds(10, 70, 110, 25);
		forward.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	if(cText.getText().isEmpty())
	        		empty.setVisible(true);
	        	else {
	        		empty.setVisible(false);
	        		
	        		if(Float.parseFloat(cText.getText()) < 20)
	        			tSmall.setVisible(true);
	        		else {
		        		Components.account.withdrawFromChecking(Float.parseFloat(cText.getText()));
						changeCBalance();
		        		panel.setVisible(false);
		        		new BalancePage().balancePage(f);
		        		f.getContentPane().remove(panel);
			        	panel.removeAll();
	        		  }
		        	}
	        	}
			});
		panel.add(forward);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 100, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	new BalancePage().balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public static void savingsWithdraw(JFrame f) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JLabel cQ1 = new JLabel("Savings Withdraw (Minumum: $20.00)");
		cQ1.setBounds(10, 20, 300, 25);
		panel.add(cQ1);
		JTextField cText = new JTextField();
		cText.setBounds(10, 40, 165, 25);
		panel.add(cText);
		
		JLabel empty = new JLabel("Please complete information above");
		empty.setBounds(10, 130, 250, 25);
		panel.add(empty);
		empty.setVisible(false);
		
		JLabel tSmall = new JLabel("Insufficient funds");
		tSmall.setBounds(10, 130, 165, 25);
		panel.add(tSmall);
		tSmall.setVisible(false);
		
		JButton forward = new JButton("Continue");
		forward.setBounds(10, 70, 110, 25);
		forward.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	if(cText.getText().isEmpty())
	        		empty.setVisible(true);
	        	else {
	        		empty.setVisible(false);
	        		
	        		if(Float.parseFloat(cText.getText()) < 10)
	        			tSmall.setVisible(true);
	        		else {
		        		Components.account.withdrawFromSavings(Float.parseFloat(cText.getText()));
						changeSBalance();
		        		panel.setVisible(false);
		        		new BalancePage().balancePage(f);
		        		f.getContentPane().remove(panel);
			        	panel.removeAll();
	        		  }
		        	}
	        	}
			});
		panel.add(forward);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 100, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	new BalancePage().balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
	
	public static void cTransHistory(JFrame f) {
		JPanel panel =  new JPanel();
		panel.setLayout(null);
		
		JTextArea transactions = new JTextArea(Components.account.cTrans(), 50, 300);
		transactions.setBounds(10, 40, 80, 300);
		panel.add(transactions);
		
		JButton back = new JButton("Back");
		back.setBounds(10, 350, 80, 25);
		back.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	panel.setVisible(false);
	        	new BalancePage().balancePage(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
}