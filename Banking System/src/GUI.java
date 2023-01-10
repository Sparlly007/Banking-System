import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import AccountCreation.Components;


public class GUI{
	private JFrame frame;
	
	Components comp = new Components();
	
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
					System.exit(0);
				}
			}
		});
		
		comp.bankingEntry(frame);
		
		frame.setVisible(true);
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new GUI();
	}
}
