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
	private JTextField bookID;
	private JLabel bookIDLabel;
	private JTextField bookQuantity;
	private JLabel bookQuantityLabel;
	
	private JLabel ItemInfo;
	private JTextField ItemInfoBox;
	private JLabel OrderSubtotal;
	private JTextField OrderSubtotalBox;
	
	private JButton submitButton;
	private JButton orderButton;
	private JButton historyButton;
	private JButton otherButton;
	
	
	public EnterpriseGui()
		{
			super("Tyler's Book Store");
			setLayout(new FlowLayout());
			
			label2 = new JLabel("Enter quantity of books:");
			add(label2);
			bookquantity = new JTextField(50);
			add(bookquantity);
			
			bookIDLabel = new JLabel("Enter Book ID for Item # ");
			add(bookIDLabel);
			bookID = new JTextField(50);
			add(bookID);
			
			bookQuantityLabel = new JLabel("Enter quantity for Item #");
			add(bookQuantityLabel);
			bookQuantity = new JTextField(50);
			add(bookQuantity);
		
			ItemInfo = new JLabel("Item #" + "Info");
			add(ItemInfo);
			ItemInfoBox = new JTextField(50);
			ItemInfoBox.setHorizontalAlignment(JTextField.RIGHT);
			add(ItemInfoBox);
			ItemInfoBox.setEditable(false);
			
			OrderSubtotal = new JLabel("OrderSubtotal for " + "items");
			add(OrderSubtotal);
			OrderSubtotalBox = new JTextField(50);
			add(OrderSubtotalBox);
			OrderSubtotalBox.setEditable(false);
			
			submitButton = new JButton("Submit");
			add(submitButton);
			orderButton = new JButton("Order");
			add(orderButton);
			historyButton = new JButton("History");
			add(historyButton);
			otherButton = new JButton("Other");
			add(otherButton);
		}
}



