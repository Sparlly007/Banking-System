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


public class BalancePage {
    public void balancePage(JFrame f) {
		JPanel balance = new JPanel();
		balance.setLayout(null);
		
		JLabel cLabel = new JLabel("Checking:");
		cLabel.setBounds(10, 20, 80, 25);
		balance.add(cLabel);
		JLabel cBalance = new JLabel(Float.toString(Components.account.cBalance()));
		cBalance.setBounds(10, 35, 80, 25);
		balance.add(cBalance);
		
		JLabel sLabel = new JLabel("Savings:");
		sLabel.setBounds(200, 20, 80, 25);
		balance.add(sLabel);
		JLabel sBalance = new JLabel(Float.toString(Components.account.sBalance()));
		sBalance.setBounds(200, 35, 80, 25);
		balance.add(sBalance);
		
		JButton background = new JButton("Account Summary");
		background.setBounds(10, 60, 200, 25);
		background.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	AccountActions.accountSummary(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(background);
		
		JButton checkDeposit = new JButton("Deposit to Checking Account");
		checkDeposit.setBounds(10, 90, 230, 25);
		checkDeposit.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	AccountActions.checkingDeposit(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(checkDeposit);
		
		JButton savingsDeposit = new JButton("Deposit to Savings Account");
		savingsDeposit.setBounds(10, 120, 230, 25);
		savingsDeposit.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	AccountActions.savingsDeposit(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(savingsDeposit);
		
		JButton checkingWithdraw = new JButton("Withdraw from Checking Account");
		checkingWithdraw.setBounds(10, 150, 230, 25);
		checkingWithdraw.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	AccountActions.checkingWithdraw(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(checkingWithdraw);
		
		JButton savingsWithdraw = new JButton("Withdraw from Savings Account");
		savingsWithdraw.setBounds(10, 180, 230, 25);
		savingsWithdraw.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	AccountActions.savingsWithdraw(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(savingsWithdraw);
		
		JButton cTransactions = new JButton("Checking Account Transactions");
		cTransactions.setBounds(10, 210, 230, 25);
		cTransactions.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	AccountActions.cTransHistory(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(cTransactions);
		
		JButton signout = new JButton("Sign Out");
		signout.setBounds(10, 240, 200, 25);
		signout.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	balance.setVisible(false);
	        	Components.bankingEntry(f);
	        	f.getContentPane().remove(balance);
	        	balance.removeAll();
	        	}
			});
		balance.add(signout);
		
		f.add(balance);
		balance.setVisible(true);
	}
}
