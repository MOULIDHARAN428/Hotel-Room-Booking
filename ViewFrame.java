package numbers;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class ViewFrame extends JFrame implements ActionListener {
	private JFrame f = new JFrame("View");
	public JButton sub;
	private Container c;
	private JLabel title;
	 public ViewFrame(){
	        setTitle("Search");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	 
	        c = getContentPane();
	        c.setLayout(null);
	        
	        title = new JLabel("View");
	        title.setFont(new Font("Arial", Font.PLAIN, 30));
	        title.setSize(300, 30);
	        title.setLocation(200, 30);
	        c.add(title);
	        
	        int jungle[] = new int[10];
	        int sea[] = new int[10];
	        for(int i=0;i<10;i++) {jungle[i]=0;sea[i]=0;}
			File file = new File("D:\\Java\\Programms\\numbers\\room.txt");
	        BufferedReader br = null;
			try {br = new BufferedReader(new FileReader(file));}
			catch (FileNotFoundException e) {e.printStackTrace();}
	        String line;
	        int flag=0,flag1=0;
	        String room = "",view = "";
	        try {
				while ((line = br.readLine()) != null) {
					for(int i=0;i<line.length();i++) {
						if(line.charAt(i)==',') {flag++;}
						else if(flag==0) {room+=line.charAt(i);}
						else if(flag==1) {view+=line.charAt(i);}
					}
					int temp = Integer.parseInt(room);
					if(view.equalsIgnoreCase("jungle")) {jungle[temp-1]++;}
					else {sea[temp-1]++;}
					flag=0;room = new String("");view = new String("");
				}
			}
	        catch (NumberFormatException | IOException e) {e.printStackTrace();}
			String content="Booked rooms : ";
			String content1="Jungle : ";
			for(int i=0;i<10;i++) {if(jungle[i]!=0) {content1+=Integer.toString(i+1);content1+=" ";flag1=1;}}
			if(flag1==0) {content1+="All rooms available!";}
			flag1=0;
			String content2="Sea    : ";
			for(int i=0;i<10;i++) {if(sea[i]!=0) {content2+=Integer.toString(i+1);content2+=" ";flag1=1;}}
			if(flag1==0) {content2+="All rooms available!";}
			System.out.println();
	        
			title = new JLabel(content);
	        title.setFont(new Font("Arial", Font.PLAIN, 20));
	        title.setSize(300, 30);
	        title.setLocation(200, 100);
	        c.add(title);
	        
	        title = new JLabel(content1);
	        title.setFont(new Font("Arial", Font.PLAIN, 20));
	        title.setSize(500, 30);
	        title.setLocation(200, 150);
	        c.add(title);
	        
	        title = new JLabel(content2);
	        title.setFont(new Font("Arial", Font.PLAIN, 20));
	        title.setSize(500, 30);
	        title.setLocation(200, 200);
	        c.add(title);
	        
	        sub = new JButton("Back");
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
			f.dispose();
			new GUI_Assignment("");
		}
	}
}
