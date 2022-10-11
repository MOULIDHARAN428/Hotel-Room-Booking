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

public class ChangeStayFrame extends JFrame implements ActionListener {
		private JFrame f = new JFrame("Modify");
		private Container c;
	    private JLabel title;
	    private JLabel room;
	    private JTextField troom;
	    private JLabel view;
	    private JTextField tview;
	    private JLabel day;
	    private JTextField tday;
	    private JButton sub;
	    
	    public ChangeStayFrame()
	    {
	        setTitle("Modify");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	 
	        c = getContentPane();
	        c.setLayout(null);
	 
	        title = new JLabel("Change Days");
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
	 
	        day = new JLabel("Days");
	        day.setFont(new Font("Arial", Font.PLAIN, 20));
	        day.setSize(100, 20);
	        day.setLocation(100, 200);
	        c.add(day);
	 
	        tday = new JTextField();
	        tday.setFont(new Font("Arial", Font.PLAIN, 15));
	        tday.setSize(190, 20);
	        tday.setLocation(200, 200);
	        c.add(tday);
	        
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
				catch (FileNotFoundException e3) {e3.printStackTrace();}
		        String line,room1="",view1="";
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
						
						if(troom.getText().compareTo(room1)==0 && tview.getText().equalsIgnoreCase(view1)) {
							
							flag1=1;
							String filePath = "D:\\Java\\Programms\\numbers\\room.txt";
						    Scanner sc = null;
							try {sc = new Scanner(new File(filePath));}
							catch (FileNotFoundException e2) {e2.printStackTrace();}
						    StringBuffer buffer = new StringBuffer();
						    while (sc.hasNextLine()) {
						    	buffer.append(sc.nextLine()+System.lineSeparator());
						    }
						    String fileContents = buffer.toString();
						    sc.close();
						    int loc = -1,loc1 = -1;
						    flag=0;
						    room1 = new String("");
						    view1 = new String("");
					    	int b=0;
					    	int temp_stay = Integer.parseInt(tday.getText());
					    	int amount = (temp_stay*350)+(temp_stay*10);
							amount +=amount/10;
							for(int i=0;i<fileContents.length();i++) {
					    		if(fileContents.charAt(i)==',') {flag++;System.out.println("1");}
					    		else if(flag==0) {room1+=fileContents.charAt(i);System.out.println("2");}
					    		else if(flag==1) {view1+=fileContents.charAt(i);System.out.println("3 "+fileContents.charAt(i));}
					    		else if(fileContents.charAt(i)=='\n'){room1=new String("");view1=new String("");flag=0;System.out.println("4");}
					    		else if(troom.getText().compareTo(room1)==0 && tview.getText().compareTo(view1)==0) {
					    			System.out.println("5");
					    			for(int j=i;j<fileContents.length();j++) {
					    				if(line.charAt(j)==',') {flag++;if(flag==9) {loc1=j;}else if(flag==7) {loc=j+1;}}
					    				else if(loc!=-1 && loc1!=-1) {
					    					fileContents=fileContents.substring(0, loc) +temp_stay+","+amount+ fileContents.substring(loc1);
						        			FileWriter writer = null;
											try {writer = new FileWriter(filePath);}
											catch (IOException e1) {e1.printStackTrace();}
						        			try {writer.append(fileContents);}
						        			catch (IOException e1) {e1.printStackTrace();}
						        			try {writer.flush();}
						        			catch (IOException e1) {e1.printStackTrace();}
						        			content="Updated!";
						        			b=1;
					        				break;
					    			}
					    			System.out.println(loc+" "+loc1);
					    		}
					    		if(b==1) {break;}
					    	}
						}
						
					}
					if(flag1==0) {content="No such record found!";}
					
				}
			}
		    catch (NumberFormatException e1) {e1.printStackTrace();}
		    catch (IOException e1) {e1.printStackTrace();}
		    f.dispose();
			new ChangeRoomDisplayFrame(content);
		 }
	}
		 
}


