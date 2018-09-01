/* Name: Tyler Carouthers-Childs
 * Course: CNT 4714 - Fall 2018
 * Assignment Title: Program 1- Event-driven Programming
 * Date: Sunday September 9, 2018
 */
package enterprise1;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Driver extends EnterpriseGui{
public static void main(String args[]) {
////	
EnterpriseGui labelFrame = new EnterpriseGui();
labelFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
labelFrame.setSize( 625, 650 );
labelFrame.setVisible( true );
labelFrame.setLocationRelativeTo(null);
////

}
}
