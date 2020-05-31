import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI{
	private JFrame frame;
	
	static Components comp = new Components();
	
	public GUI() {
		frame = new JFrame();
		frame.setSize(500, 500);
		
		frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
		                // Ask for confirmation before terminating the program.
				int option = JOptionPane.showConfirmDialog(
					frame, 
					"Are you sure you want to close the application?",
					"Close Confirmation", 
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE);
				if (option == JOptionPane.YES_OPTION) {
					try {
					FileOutputStream fos = new FileOutputStream("Test.txt");
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(comp.pw);
					oos.close();
					}catch (Exception ex) {
			            ex.printStackTrace();
			        }
					System.exit(0);
				}
			}
		});
		
		comp.bankingEntry(frame);
		
		frame.setVisible(true);
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new GUI();
		/*Password pw = new Password();
		String filename = "Test.txt";
		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(pw);
		oos.close();*/
	}
}
