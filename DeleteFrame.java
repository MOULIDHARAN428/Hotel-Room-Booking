package numbers;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

import javax.swing.*;

public class DeleteFrame extends JFrame implements ActionListener {
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
	    
	    public DeleteFrame()
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
	 
	        sub = new JButton("Delete");
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
				catch (FileNotFoundException e2) {e2.printStackTrace();}
		        String line,room1="",view1="",temp="";
		        int flag1=0;
		        try {
					while ((line = br.readLine()) != null) {
						int flag=0;
						room1=new String("");
						view1=new String("");
						for(int i=0;i<line.length();i++) {
							if(line.charAt(i)==',') {flag++;}
							else if(flag==0) {room1+=line.charAt(i);}
							else if(flag==1) {view1+=line.charAt(i);}
							else {break;}
						}
						if(troom.getText().compareTo(room1)!=0 || tview.getText().equalsIgnoreCase(view1)==false) {
							temp+=line;
						}
						else {flag1=1;}
						
					}
				}
		        catch (IOException e2) {e2.printStackTrace();}
		        if(flag1==0) {content="No such record found!";}
		        else {
		        	String fileContents=temp;
	    			FileWriter writer = null;
					try {writer = new FileWriter("D:\\Java\\Programms\\numbers\\room.txt");}
					catch (IOException e1) {e1.printStackTrace();}
	    			try {writer.append(fileContents);}
	    			catch (IOException e1) {e1.printStackTrace();}
	    			try {writer.flush();} catch (IOException e1) {e1.printStackTrace();}
	    			content="Deleted!";
		        }
		        f.dispose();
				new DeleteDisplayFrame(content);
			}
		 
	}
}

