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

public class SearchFrame extends JFrame implements ActionListener {
		private JFrame f = new JFrame("Search");
		private Container c;
	    private JLabel title;
	    private JLabel room;
	    private JTextField troom;
	    private JLabel view;
	    private JTextField tview;
	    private JLabel password;
	    private JTextField tpassword;
	    private JButton sub;
	    
	    public SearchFrame()
	    {
	        setTitle("Search");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	 
	        c = getContentPane();
	        c.setLayout(null);
	 
	        title = new JLabel("Search");
	        title.setFont(new Font("Arial", Font.PLAIN, 30));
	        title.setSize(300, 30);
	        title.setLocation(200, 30);
	        c.add(title);
	 
	        room = new JLabel("Room");
	        room.setFont(new Font("Arial", Font.PLAIN, 20));
	        room.setSize(100, 20);
	        room.setLocation(100, 100);
	        c.add(room);
	 
	        troom = new JTextField();
	        troom.setFont(new Font("Arial", Font.PLAIN, 15));
	        troom.setSize(190, 20);
	        troom.setLocation(200, 100);
	        c.add(troom);
	        
	        view = new JLabel("View");
	        view.setFont(new Font("Arial", Font.PLAIN, 20));
	        view.setSize(100, 20);
	        view.setLocation(100, 150);
	        c.add(view);
	 
	        tview = new JTextField();
	        tview.setFont(new Font("Arial", Font.PLAIN, 15));
	        tview.setSize(190, 20);
	        tview.setLocation(200, 150);
	        c.add(tview);
	 
	        sub = new JButton("Search");
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
			 	String content="";
			 	File file = new File("D:\\Java\\Programms\\numbers\\room.txt");
		        BufferedReader br = null;
				try {br = new BufferedReader(new FileReader(file));}
				catch (FileNotFoundException e1) {e1.printStackTrace();}
		        String line;
		        int flag=0,flag1=0;
		        try {
					while ((line = br.readLine()) != null) {
						if(line.contains(tview.getText()) && line.contains(troom.getText())) {
							flag1=1;
							
							String temp="";
							for(int i=0;i<line.length();i++) {
								if(line.charAt(i)==',') {
									if(flag==0) {content+="Room ID :";}
									else if(flag==1) {content+="View : ";}
									else if(flag==2) {content+="Name : ";}
									else if(flag==3) {content+="Age : ";}
									else if(flag==4) {content+="Passport : ";}
									else if(flag==5) {content+="Contact Number : ";}
									else if(flag==6) {content+="Email : ";}
									else if(flag==7) {content+="Number of days stay : ";}
									else if(flag==8) {content+="Amount : ";}
									temp+=",";
									if(flag<=8) {content+=temp;}
									temp = new String("");
									flag++;
								}
								else {temp+=line.charAt(i);}
							}
						}
					}
				}
		        catch (IOException e1) {e1.printStackTrace();}
		        if(flag1==0) {content="Room is not booked yet!";}
		        f.dispose();
				new SearchDisplayFrame(content);
		}
	}
}

