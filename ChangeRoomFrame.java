package numbers;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

import javax.swing.*;

public class ChangeRoomFrame extends JFrame implements ActionListener {
		private JFrame f = new JFrame("Modify");
		private Container c;
	    private JLabel title;
	    private JLabel room;
	    private JTextField troom;
	    private JLabel nroom;
	    private JTextField tnroom;
	    private JLabel view;
	    private JTextField tview;
	    private JButton sub;
	    
	    public ChangeRoomFrame()
	    {
	        setTitle("Modify");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	 
	        c = getContentPane();
	        c.setLayout(null);
	 
	        title = new JLabel("Change Room");
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
	        
	        nroom = new JLabel("New Room Number");
	        nroom.setFont(new Font("Arial", Font.PLAIN, 20));
	        nroom.setSize(200, 20);
	        nroom.setLocation(100, 200);
	        c.add(nroom);
	 
	        tnroom = new JTextField();
	        tnroom.setFont(new Font("Arial", Font.PLAIN, 15));
	        tnroom.setSize(190, 20);
	        tnroom.setLocation(200, 200);
	        c.add(tnroom);
	 
	        sub = new JButton("Change");
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
		        String line,room1="",view1="";int flag1=0;
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
						
						if(troom.getText().compareTo(room1)==0 && tview.getText().equalsIgnoreCase(view1)) {
							
							flag1=1;
							String filePath = "D:\\Java\\Programms\\numbers\\room.txt";
						    Scanner sc = null;
							try {sc = new Scanner(new File(filePath));}
							catch (FileNotFoundException e1) {e1.printStackTrace();}
						    StringBuffer buffer = new StringBuffer();
						    while (sc.hasNextLine()) {
						    	buffer.append(sc.nextLine()+System.lineSeparator());
						    }
						    String fileContents = buffer.toString();
						    sc.close();
						    int loc = -1;
						    flag=0;
						    room1 = new String("");
						    view1 = new String("");
					    	for(int i=0;i<fileContents.length();i++) {
					    		if(line.charAt(i)==',') {flag++;}
					    		else if(flag==0 && line.charAt(i)!=' ' && line.charAt(i)!='\n') {room1+=line.charAt(i);loc=i;}
					    		else if(flag==1) {view1+=line.charAt(i);}
					    		else if(line.charAt(i)==' '){room1=new String("");view1=new String("");flag=0;}
					    		else if(troom.getText().compareTo(room1)==0 && tview.getText().equalsIgnoreCase(view1)) {
					    			fileContents=fileContents.substring(0, loc) +tnroom.getText()+ fileContents.substring(loc+1);
					    			FileWriter writer = null;
									try {writer = new FileWriter(filePath);}
									catch (IOException e1) {e1.printStackTrace();}
					    			try {writer.append(fileContents);}
					    			catch (IOException e1) {e1.printStackTrace();}
					    			try {writer.flush();}
					    			catch (IOException e1) {e1.printStackTrace();}
					    			content="Updated!";
					    		    break;
					    		}
					    	}
							break;
						}
					}
					if(flag1==0) {content="Wrong Input!";}
				}
		        catch (IOException e1) {e1.printStackTrace();}
		        f.dispose();
				new ChangeRoomDisplayFrame(content);
		 }
		 
	}
}

