package numbers;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class ReceiptDisplayFrame extends JFrame implements ActionListener {
	public static String staff="";
	private JFrame f = new JFrame("Log In");
		private Container c;
	    private JLabel title;
	    private JLabel email;
	    private JTextField temail;
	    private JLabel password;
	    private JTextField tpassword;
	    private JButton sub;
	    
	    public ReceiptDisplayFrame(String str)
	    {
	        setTitle("Receipt");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	 
	        c = getContentPane();
	        c.setLayout(null);
	 
	        title = new JLabel("Receipt");
	        title.setFont(new Font("Arial", Font.PLAIN, 30));
	        title.setSize(300, 30);
	        title.setLocation(200, 30);
	        c.add(title);
	        
	        String temp="";
	        int temp1=0,yes=0;
	        for(int i=0;i<str.length();i++) {
	        	if(str.charAt(i)==',') {
	        		yes=1;
	        		password = new JLabel(temp);
	    	        password.setFont(new Font("Arial", Font.PLAIN, 20));
	    	        password.setSize(1000, 20);
	    	        password.setLocation(100, 100+temp1);
	    	        c.add(password);
	        		temp = new String("");
	        		temp1+=30;
	        	}
	        	else {temp+=str.charAt(i);}
	        }
	        if(yes==0) {
	        	password = new JLabel(temp);
    	        password.setFont(new Font("Arial", Font.PLAIN, 20));
    	        password.setSize(1000, 20);
    	        password.setLocation(100, 100+temp1);
    	        c.add(password);
	        }
	 
	        sub = new JButton("Back");
	        sub.setFont(new Font("Arial", Font.PLAIN, 15));
	        sub.setSize(100, 20);
	        sub.setLocation(200, 500);
	        sub.addActionListener(this);
	        c.add(sub);
	 
	        setVisible(true);
	        
	        setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == sub) {
			f.dispose();
			new GUI_Assignment("");
		 }
	}
}
