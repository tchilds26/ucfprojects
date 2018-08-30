package enterprise1;

import java.awt.FlowLayout; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class EnterpriseGui extends JFrame{
	private JTextField bookquantity;
	private JLabel label2;
	
	public EnterpriseGui()
		{
			super("Tylers Book Store");
			setLayout(new FlowLayout());
			
			label2 = new JLabel("Enter quantity of books:");
			add(label2);
			
			bookquantity = new JTextField(50);
			add(bookquantity);
			
		

		}
}



