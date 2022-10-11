package numbers;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class SignUpFrame extends JFrame implements ActionListener {
	private JFrame f = new JFrame("Sign UP");
		private Container c;
	    private JLabel title;
	    private JLabel name;
	    private JTextField tname;
	    private JLabel email;
	    private JTextField temail;
	    private JLabel password;
	    private JTextField tpassword;
	    private JButton sub;
	    
	    public SignUpFrame()
	    {
	        setTitle("Sign-Up Form");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	 
	        c = getContentPane();
	        c.setLayout(null);
	 
	        title = new JLabel("Sign-Up Form");
	        title.setFont(new Font("Arial", Font.PLAIN, 30));
	        title.setSize(300, 30);
	        title.setLocation(200, 30);
	        c.add(title);
	 
	        name = new JLabel("Name");
	        name.setFont(new Font("Arial", Font.PLAIN, 20));
	        name.setSize(100, 20);
	        name.setLocation(100, 100);
	        c.add(name);
	 
	        tname = new JTextField();
	        tname.setFont(new Font("Arial", Font.PLAIN, 15));
	        tname.setSize(190, 20);
	        tname.setLocation(200, 100);
	        c.add(tname);
	        
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
			String content = tname.getText()+","+temail.getText()+","+tpassword.getText()+"\n";
			BufferedWriter out = null;
			try {out = new BufferedWriter(new FileWriter("D:\\Java\\Programms\\numbers\\users.txt", true));}
			catch (IOException e3) {e3.printStackTrace();}
			try {out.write(content);} 
			catch (IOException e2) {e2.printStackTrace();}
			try {out.close();}
			catch (IOException e1) {e1.printStackTrace();}
		    System.out.println("Registred!");
		    f.dispose();
			new GUI_Assignment("");
		 }
	}
}
