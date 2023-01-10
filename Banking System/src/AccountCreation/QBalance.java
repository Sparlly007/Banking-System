package AccountCreation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AccountEntity.Balance;
import AccountEntity.User;
import BankActions.BalancePage;
import Service.Service;

public class QBalance{
	Service service;
    ///Decide the starting checking balance that should be at least $150
	public void qBalance(JFrame f) {
		service = new Service();
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
	        		
	        		if(Double.parseDouble(cText.getText()) < 150 || Double.parseDouble(sText.getText()) < 500)
	        			tSmall.setVisible(true);
	        		else {
		        		panel.setVisible(false);
						Components.account.setBalance(new Balance(Double.parseDouble(cText.getText()), Double.parseDouble(sText.getText())));
			   			service.register(Components.account);
		        		new BalancePage().balancePage(f);
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
				AccountCreation create = new AccountCreation();
	        	create.accountCreation1(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
}
