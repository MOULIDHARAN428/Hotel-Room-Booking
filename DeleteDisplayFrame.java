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

public class DeleteDisplayFrame extends JFrame implements ActionListener {
	public static String staff="";
	private JFrame f = new JFrame("Log In");
		private Container c;
	    private JLabel title;
	    private JLabel info;
	    private JButton sub;
	    
	    public DeleteDisplayFrame(String str)
	    {
	        setTitle("Delete");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	 
	        c = getContentPane();
	        c.setLayout(null);
	 
	        title = new JLabel("Delete");
	        title.setFont(new Font("Arial", Font.PLAIN, 30));
	        title.setSize(300, 30);
	        title.setLocation(200, 30);
	        c.add(title);
	        
        	info = new JLabel(str);
        	info.setFont(new Font("Arial", Font.PLAIN, 20));
        	info.setSize(1000, 20);
        	info.setLocation(100, 100);
	        c.add(info);
	 
	        sub = new JButton("Back");
	        sub.setFont(new Font("Arial", Font.PLAIN, 15));
	        sub.setSize(100, 20);
	        sub.setLocation(200, 150);
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
