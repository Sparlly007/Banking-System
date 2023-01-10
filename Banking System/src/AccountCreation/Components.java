package AccountCreation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import AccountEntity.Balance;
import AccountEntity.Password;
import AccountEntity.User;

public class Components {
	public static Password pw;
	public static User account;
	public static Balance b;

	// This panel sets up the account creation page
	public static void bankingEntry(JFrame f) {
		JPanel entry = new JPanel();
		entry.setLayout(null);
		JButton newAccount = new JButton("Create New Account");
		newAccount.setBounds(10, 80, 300, 25);
		newAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entry.setVisible(false);
				new AccountCreation().accountCreation1(f);
				f.getContentPane().remove(entry);
				entry.removeAll();
			}
		});
		entry.add(newAccount);

		JButton existingAccount = new JButton("Sign in");
		existingAccount.setBounds(10, 100, 300, 25);
		existingAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
