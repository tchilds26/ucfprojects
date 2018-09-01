/* Name: Tyler Carouthers-Childs
 * Course: CNT 4714 - Fall 2018
 * Assignment Title: Program 1- Event-driven Programming
 * Date: Sunday September 9, 2018
 */
package enterprise1;

import java.awt.FlowLayout; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EnterpriseGui extends JFrame {
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
	
	protected JButton submitButton;
	private JButton orderButton;
	private JButton historyButton;
	private JButton finishOrderButton;
	private JButton newOrderButton;
	private JButton exitButton;
	
	private int orderNumber = 1;
	private double subTotal = 0;
	private int totalQuantity = 0;
	String codeTemp = null;
	String nameTemp;
	double priceTemp;
	double subTotalTemp;
	int quantityTemp;
	
	int counter = 0;
	int flag = 0;
	
	String splitBy = ",";
	
	public EnterpriseGui()
		{
		super("Tyler's Book Store");
		
		String fileName = "inventory.txt";
		String line = null;
		Map<Integer, ArrayList<String>> bookMap = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> finalOrderCodes = new ArrayList<>();
		ArrayList<String> finalOrderNames = new ArrayList<>();
		ArrayList<Double> finalOrderPrice = new ArrayList<>();
		ArrayList<Double> finalOrderSubtotal = new ArrayList<>();
		ArrayList<Integer> finalOrderQuantity = new ArrayList<>();
		
	//////////////////	file reader
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			  while((line = bufferedReader.readLine()) != null) {
				  	ArrayList<String> tempMapName = new ArrayList<String>();
	                
				  	String[] bookinfo = line.split(splitBy);
	                int tempMapCode = Integer.parseInt(bookinfo[0]);
	                tempMapName.add(bookinfo[1]);
	                tempMapName.add(bookinfo[2]);
	                bookMap.put(tempMapCode, tempMapName);
	                
	                
	            }  
			
			bufferedReader.close();
		}
		  catch(FileNotFoundException ex) {
	            System.out.println(
	                "Unable to open file '" + 
	                fileName + "'");                
	        }
		  catch(IOException ex) {
	            System.out.println(
	                "Error reading file '" 
	                + fileName + "'");                  
	        }
	
	
	
	//////////////	end of file reader
		
		
		//test print statement for map
		/*for (Entry<Integer, ArrayList<String>> entry : bookMap.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}*/

		
	///////////// GUI Labels and Text Fields	
			setLayout(new FlowLayout());
			
			label2 = new JLabel("Enter total quantity of books:");
			add(label2);
			bookquantity = new JTextField(50);
			add(bookquantity);
			
			bookIDLabel = new JLabel("Enter Book ID for Item #" + orderNumber);
			add(bookIDLabel);
			bookID = new JTextField(50);
			add(bookID);
			
			bookQuantityLabel = new JLabel("Enter quantity for Item #" + orderNumber);
			add(bookQuantityLabel);
			bookQuantity = new JTextField(50);
			add(bookQuantity);
		
			ItemInfo = new JLabel("Item #" + orderNumber + " Info");
			add(ItemInfo);
			ItemInfoBox = new JTextField(50);
			add(ItemInfoBox);
			ItemInfoBox.setEditable(false);
			
			OrderSubtotal = new JLabel("Order Subtotal for " + orderNumber + " items");
			add(OrderSubtotal);
			OrderSubtotalBox = new JTextField(50);
			add(OrderSubtotalBox);
			OrderSubtotalBox.setEditable(false);
	////////////////GUI Labels and Text Fields END
			
	///////////////Buttons and Button Listeners Start
			submitButton = new JButton("Process Item #" + orderNumber);
			submitButton.addActionListener(new ActionListener() {

				///process button
				@Override
				public void actionPerformed(ActionEvent e) {
					int currentCode = Integer.parseInt(bookID.getText());
					if(bookMap.containsKey(currentCode)) {
						
						JFrame myFrame = new JFrame("showOptionDialog() Test");
						myFrame.setLocationByPlatform(true);
						JOptionPane.showMessageDialog(
							    myFrame, "Book with ID " +currentCode+" successfully added.");
						
						
						
					int quantity = Integer.parseInt(bookQuantity.getText());
					
					totalQuantity = Integer.parseInt(bookquantity.getText());
					if(flag ==0) {
						counter = totalQuantity;
						flag = 1;
						}
					
						bookquantity.setEditable(false);
						ItemInfoBox.setText(currentCode + " " + bookMap.get(currentCode).toString());
						List<String> tempList = new ArrayList<>(bookMap.get(currentCode));
						double tempPrice = Double.parseDouble(tempList.get(1));
						subTotal += tempPrice * quantity;
						OrderSubtotalBox.setText("$" + subTotal);
						submitButton.setEnabled(false);
						 codeTemp = bookID.getText();
						 nameTemp = tempList.get(0);
						 priceTemp = Double.parseDouble(tempList.get(1));
						 subTotalTemp = tempPrice * quantity;
						 quantityTemp = quantity;
						orderButton.setEnabled(true);
					}
					else {
						JFrame myFrame = new JFrame("showOptionDialog() Test");
						myFrame.setLocationByPlatform(true);
						JOptionPane.showMessageDialog(
							    myFrame, "Book ID not found.");
					}
				}
				
			});
				///confirm button
			orderButton = new JButton("Confirm Item #" + orderNumber);
			orderButton.setEnabled(false);
			orderButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					orderNumber++;
					///update all fields with new item#
					orderButton.setText("Confirm Item #" + orderNumber);
					submitButton.setText("Process Item #" + orderNumber);
					bookIDLabel.setText("Enter Book ID for Item #" + orderNumber);
					bookQuantityLabel.setText("Enter quantity for Item #" + orderNumber);
					ItemInfo.setText("Item #" + orderNumber + " Info");
					OrderSubtotal.setText("Order Subtotal for " + orderNumber + " items");
					submitButton.setEnabled(true);
					orderButton.setEnabled(false);
					historyButton.setEnabled(true);
					 finalOrderCodes.add(codeTemp);
					 finalOrderNames.add(nameTemp);
					 finalOrderPrice.add(priceTemp);
					 finalOrderSubtotal.add(subTotalTemp);
					 finalOrderQuantity.add(quantityTemp);
					 bookID.setText(null);
					 ItemInfoBox.setText(null);
					 bookQuantity.setText(null);
					 
					 counter--;
					 if (counter == 0) {
						 finishOrderButton.setEnabled(true);
						 submitButton.setEnabled(false);
						 orderButton.setEnabled(false);
						 bookIDLabel.setVisible(false);
						 bookQuantityLabel.setVisible(false);
						 bookID.setText(null);
						 bookID.setEditable(false);
						 bookQuantity.setEditable(false);
						 bookQuantity.setText(null);
						 
					 }
					
					
		
				}
				
			});
				///view order button
			historyButton = new JButton("View Order");
			historyButton.setEnabled(false);
			historyButton.addActionListener(new ActionListener() {
				
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame myFrame = new JFrame("showOptionDialog() Test");
					StringBuilder sb = new StringBuilder();
					for(int i=0; i<totalQuantity - counter; i++) {
						sb.append(i+1 +"." + finalOrderCodes.get(i)+" " + finalOrderNames.get(i) + " $" + finalOrderPrice.get(i) + " " + finalOrderQuantity.get(i) + " $" + finalOrderSubtotal.get(i) +"\n");
					}
					JOptionPane.showMessageDialog(myFrame, sb);
					
					
				}
				
			});
				///finish order button
			finishOrderButton = new JButton("Finish Order");
			finishOrderButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					SimpleDateFormat ft = new SimpleDateFormat("ddMMyyyyHHmm");
					Date datestamp = new Date();
					SimpleDateFormat ft2 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss zzz");
					Date finaldate = new Date();
					
					try(FileWriter fw = new FileWriter("transactions.txt", true);
						    BufferedWriter bw = new BufferedWriter(fw);
						    PrintWriter out = new PrintWriter(bw))
						{
							for (int i=0; i<totalQuantity; i++) {
								 out.println(ft.format(datestamp) + "," + finalOrderCodes.get(i) + "," + finalOrderNames.get(i) + "," + finalOrderPrice.get(i)+ "," + finalOrderQuantity.get(i) + ", Total:" + finalOrderSubtotal.get(i)+" "+ft2.format(finaldate));
							}
						   
						} catch (IOException e1) {
						}
					
					
					JFrame myFrame = new JFrame("showOptionDialog() Test");
					StringBuilder sb = new StringBuilder();
					sb.append("Date:" + finaldate +"\n\n");
					sb.append("Number of line items: "+ totalQuantity +"\n\n");
					sb.append("Item#/ID/Title/Price/Qty/Subtotal\n\n");
				
					for(int i=0; i<totalQuantity; i++) {
						sb.append(i+1 +"." + finalOrderCodes.get(i)+" " + finalOrderNames.get(i) + " $" + finalOrderPrice.get(i) + " " + finalOrderQuantity.get(i) + " $" + finalOrderSubtotal.get(i) +"\n");
					}
					sb.append("Order subtotal: $"+subTotal + "\n\n");
					sb.append("Tax rate: 6%\n\n");
					double taxAmount = subTotal*.06;
					sb.append("Tax amount: $"+taxAmount+"\n\n");
					subTotal+=taxAmount;
					sb.append("Order total: $"+ subTotal +"\n\n");
					sb.append("Thanks for shopping at Tyler's Book Store");
					JOptionPane.showMessageDialog(myFrame, sb);
					finishOrderButton.setEnabled(false);
					
					
				}
				
			});
				///New order button
			newOrderButton = new JButton("New Order");
			newOrderButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					EnterpriseGui labelFrame = new EnterpriseGui();
					labelFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					labelFrame.setSize( 650, 650 );
					labelFrame.setVisible( true );
					labelFrame.setLocationRelativeTo(null);
				}
				
			});
				///Exit Button
			exitButton = new JButton("Exit");
			exitButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
				
			});
			
			add(submitButton);
			add(orderButton);
			add(historyButton);
			add(finishOrderButton);
			add(newOrderButton);
			add(exitButton);
			
///////////// button and button listeners END
		}

	
	
	
	
}



