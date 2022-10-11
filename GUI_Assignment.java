package numbers;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Assignment extends JFrame implements ActionListener{
	public JButton b,b1,b2,b3,b4,b5,b6;
	private static JLabel staff_name;
	public static String staff="";
	public static void home() {
		JFrame f=new JFrame("Home");
		
		staff_name = new JLabel(staff);
		staff_name.setFont(new Font("Arial", Font.PLAIN, 20));
		staff_name.setSize(80, 20);
		staff_name.setLocation(300, 20);
        f.add(staff_name);
		
	    JButton b=new JButton("Sign Up");  
	    b.setBounds(70,30,110,30);
	    b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new SignUpFrame();
			}
		});
	    
	    JButton b1=new JButton("Log In");  
	    b1.setBounds(70,80,110,30);
	    b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new LogInFrame();
			}
		});
	    
	    
	    JButton b3=new JButton("Book Room");  
	    b3.setBounds(70,130,110,30);
	    b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new BookRoomFrame();
			}
		});
	    
	    JButton b4=new JButton("Manage");  
	    b4.setBounds(70,180,110,30);
	    b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new ManageFrame();
			}
		});
	    
	    JButton b5=new JButton("Receipt");  
	    b5.setBounds(70,230,110,30);
	    b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new ReceiptFrame();
			}
		});
	    
	    JButton b6=new JButton("Exit");  
	    b6.setBounds(70,280,110,30);
	    
	    f.add(b);f.add(b1);f.add(b3);f.add(b4);f.add(b5);f.add(b6);
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);
	}
	public GUI_Assignment(String staff1) {
		staff=staff1;
		home();
	}
	public static void main(String args[]) {
		GUI_Assignment g = new GUI_Assignment("");
		g.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
	} 
}
