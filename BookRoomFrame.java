package numbers;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class BookRoomFrame extends JFrame implements ActionListener {
	
	private JFrame f = new JFrame("Sign Up");
		private Container c;
	    private JLabel title;
	    private JLabel name;
	    private JTextField tname;
	    private JLabel roomID;
	    private JTextField troomID;
	    private JLabel view;
	    private JTextField tview;
	    private JLabel age;
	    private JTextField tage;
	    private JLabel passport;
	    private JTextField tpassport;
	    private JLabel contact_number;
	    private JTextField tcontact_number;
	    private JLabel email;
	    private JTextField temail;
	    private JLabel days;
	    private JTextField tdays;
	    private JButton sub;
	    
	    public BookRoomFrame()
	    {
	        setTitle("Room Booking Form");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	 
	        c = getContentPane();
	        c.setLayout(null);
	 
	        title = new JLabel("Room Booking Form");
	        title.setFont(new Font("Arial", Font.PLAIN, 30));
	        title.setSize(300, 30);
	        title.setLocation(250, 30);
	        c.add(title);
	 
	        name = new JLabel("Name");
	        name.setFont(new Font("Arial", Font.PLAIN, 20));
	        name.setSize(100, 20);
	        name.setLocation(100, 100);
	        c.add(name);
	 
	        tname = new JTextField();
	        tname.setFont(new Font("Arial", Font.PLAIN, 15));
	        tname.setSize(190, 20);
	        tname.setLocation(250, 100);
	        c.add(tname);
	        
	        email = new JLabel("Email");
	        email.setFont(new Font("Arial", Font.PLAIN, 20));
	        email.setSize(100, 20);
	        email.setLocation(100, 150);
	        c.add(email);
	 
	        temail = new JTextField();
	        temail.setFont(new Font("Arial", Font.PLAIN, 15));
	        temail.setSize(190, 20);
	        temail.setLocation(250, 150);
	        c.add(temail);
	        
	        age = new JLabel("Age");
	        age.setFont(new Font("Arial", Font.PLAIN, 20));
	        age.setSize(100, 20);
	        age.setLocation(100, 200);
	        c.add(age);
	 
	        tage = new JTextField();
	        tage.setFont(new Font("Arial", Font.PLAIN, 15));
	        tage.setSize(190, 20);
	        tage.setLocation(250, 200);
	        c.add(tage);
	 
	        roomID = new JLabel("Room ID");
	        roomID.setFont(new Font("Arial", Font.PLAIN, 20));
	        roomID.setSize(100, 20);
	        roomID.setLocation(100, 250);
	        c.add(roomID);
	 
	        troomID = new JTextField();
	        troomID.setFont(new Font("Arial", Font.PLAIN, 15));
	        troomID.setSize(190, 20);
	        troomID.setLocation(250, 250);
	        c.add(troomID);
	        
	        view = new JLabel("View");
	        view.setFont(new Font("Arial", Font.PLAIN, 20));
	        view.setSize(100, 20);
	        view.setLocation(100, 300);
	        c.add(view);
	 
	        tview = new JTextField();
	        tview.setFont(new Font("Arial", Font.PLAIN, 15));
	        tview.setSize(190, 20);
	        tview.setLocation(250, 300);
	        c.add(tview);
	        
	        passport = new JLabel("Passport");
	        passport.setFont(new Font("Arial", Font.PLAIN, 20));
	        passport.setSize(100, 20);
	        passport.setLocation(100, 350);
	        c.add(passport);
	 
	        tpassport = new JTextField();
	        tpassport.setFont(new Font("Arial", Font.PLAIN, 15));
	        tpassport.setSize(190, 20);
	        tpassport.setLocation(250, 350);
	        c.add(tpassport);
	        
	        contact_number = new JLabel("Contact Number");
	        contact_number.setFont(new Font("Arial", Font.PLAIN, 20));
	        contact_number.setSize(150, 20);
	        contact_number.setLocation(100, 400);
	        c.add(contact_number);
	 
	        tcontact_number = new JTextField();
	        tcontact_number.setFont(new Font("Arial", Font.PLAIN, 15));
	        tcontact_number.setSize(190, 20);
	        tcontact_number.setLocation(250, 400);
	        c.add(tcontact_number);
	        
	        days = new JLabel("Days of Stay");
	        days.setFont(new Font("Arial", Font.PLAIN, 20));
	        days.setSize(150, 20);
	        days.setLocation(100, 450);
	        c.add(days);
	 
	        tdays = new JTextField();
	        tdays.setFont(new Font("Arial", Font.PLAIN, 15));
	        tdays.setSize(190, 20);
	        tdays.setLocation(250, 450);
	        c.add(tdays);
	        
	        sub = new JButton("Submit");
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
			int amount = Integer.parseInt(tdays.getText());
			amount=(amount*350)+(350/10)+(amount*10);
			String content = "\n"+troomID.getText()+","+tview.getText()+","+tname.getText()+","+tage.getText()+","+tpassport.getText()+","+tcontact_number.getText()+","+temail.getText()+","+tdays.getText()+","+amount+",User ";
//			System.out.print(content);
			BufferedWriter out = null;
			try {out = new BufferedWriter(new FileWriter("D:\\Java\\Programms\\numbers\\room.txt", true));}
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
