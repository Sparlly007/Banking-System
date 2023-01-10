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

public class AccountCreation {
	public void accountCreation1(JFrame f) {
		Components.pw = new Password();

		JPanel accountCreation = new JPanel();
		accountCreation.setLayout(null);

		// Name input
		JLabel name = new JLabel("Name:");
		name.setBounds(10, 20, 120, 25);
		accountCreation.add(name);
		JTextField nameText = new JTextField();
		nameText.setBounds(120, 20, 165, 25);
		accountCreation.add(nameText);

		// Email input
		JLabel email = new JLabel("Email:");
		email.setBounds(10, 45, 80, 25);
		accountCreation.add(email);
		JTextField emailText = new JTextField();
		emailText.setBounds(120, 45, 165, 25);
		accountCreation.add(emailText);

		// Password input
		JLabel pw = new JLabel("Password:");
		pw.setBounds(10, 70, 80, 25);
		accountCreation.add(pw);
		JTextField pwText = new JTextField();
		pwText.setBounds(120, 70, 165, 25);
		accountCreation.add(pwText);

		// Confirm password input
		JLabel pwConf = new JLabel("Confirm password:");
		pwConf.setBounds(10, 95, 80, 25);
		accountCreation.add(pwConf);
		JTextField pwConfText = new JTextField();
		pwConfText.setBounds(120, 95, 165, 25);
		accountCreation.add(pwConfText);

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
		createAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nameText.getText().isEmpty() || emailText.getText().isEmpty()
						|| pwText.getText().isEmpty() || pwConfText.getText().isEmpty()) {
					empty.setVisible(true);
				} else {
					empty.setVisible(false);
					if (Components.pw.contains(pwText.getText()) || !(pwText.getText().equals(pwConfText.getText())))
						incorrectPW.setVisible(true);
					else {
						Components.account = new User(nameText.getText(), emailText.getText(), pwConfText.getText());
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
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
}
