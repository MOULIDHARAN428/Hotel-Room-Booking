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

public class LogInFrame extends JFrame implements ActionListener {
		public static String staff="";
		private JFrame f = new JFrame("Log In");
		private Container c;
	    private JLabel title;
	    private JLabel email;
	    private JTextField temail;
	    private JLabel password;
	    private JTextField tpassword;
	    private JButton sub;
	    
	    public LogInFrame()
	    {
	        setTitle("Log-In Form");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	 
	        c = getContentPane();
	        c.setLayout(null);
	 
	        title = new JLabel("Log-In Form");
	        title.setFont(new Font("Arial", Font.PLAIN, 30));
	        title.setSize(300, 30);
	        title.setLocation(200, 30);
	        c.add(title);
	        
	        email = new JLabel("Email");
	        email.setFont(new Font("Arial", Font.PLAIN, 20));
	        email.setSize(100, 20);
	        email.setLocation(100, 150);
	        c.add(email);
	 
	        temail = new JTextField();
	        temail.setFont(new Font("Arial", Font.PLAIN, 15));
	        temail.setSize(190, 20);
	        temail.setLocation(200, 150);
	        c.add(temail);
	        
	        password = new JLabel("Password");
	        password.setFont(new Font("Arial", Font.PLAIN, 20));
	        password.setSize(100, 20);
	        password.setLocation(100, 200);
	        c.add(password);
	 
	        tpassword = new JTextField();
	        tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
	        tpassword.setSize(190, 20);
	        tpassword.setLocation(200, 200);
	        c.add(tpassword);
	 
	        sub = new JButton("Submit");
	        sub.setFont(new Font("Arial", Font.PLAIN, 15));
	        sub.setSize(100, 20);
	        sub.setLocation(200, 250);
	        sub.addActionListener(this);
	        c.add(sub);
	 
	 
	        setVisible(true);
	        
	        setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == sub) {
			int flag=0;
			String content="";
			File file = new File("D:\\Java\\Programms\\numbers\\users.txt");
	        BufferedReader br = null;
			try {br = new BufferedReader(new FileReader(file));}
			catch (FileNotFoundException e2) {e2.printStackTrace();}
	        String line;
	        try {
				while ((line = br.readLine()) != null) {
					if(line.contains(tpassword.getText()) && line.contains(temail.getText())) {
						flag=1;
						content="Logged In!";
						for(int i=0;i<line.length();i++) {
							if(line.charAt(i)!=',') {staff+=line.charAt(i);}
							else {break;}
						}
						f.dispose();
						new LogInDisplayFrame(content);
						break;
					}
				}
			}
	        catch (IOException e1) {e1.printStackTrace();}
	        if(flag==0) {
	        	content="No such account found!";
	        	f.dispose();
	        	new LogInDisplayFrame(content);
	        }
	        
		 }
	}
}
