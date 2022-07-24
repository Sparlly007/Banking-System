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

public class QBalance{
    ///Decide the starting checking balance that should be at least $150
	public void qBalance(JFrame f) {
		//User account = Components.pw.get(Components.currPassword);
		Components.b = new Balance();
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
		        		Components.b.depositToChecking(Float.parseFloat(cText.getText()));
		        		Components.b.depositToSavings(Float.parseFloat(sText.getText()));
		        		panel.setVisible(false);
						Components.account = new User(Components.birth, Components.address, Components.pw, Components.b);
			   			Components.account.add(Components.account);
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
	        	create.accountCreation2(f);
	        	f.getContentPane().remove(panel);
	        	panel.removeAll();
	        	}
			});
		panel.add(back);
		
		f.add(panel);
		panel.setVisible(true);
	}
}
