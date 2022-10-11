package numbers;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ManageFrame extends JFrame implements ActionListener {
	JFrame f=new JFrame("Manage");
	public ManageFrame(){
		JLabel title = new JLabel("Manage");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setSize(80, 20);
		title.setLocation(100, 20);
        f.add(title);
		
	    JButton modify=new JButton("Modify");  
	    modify.setBounds(70,50,110,30);
	    modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new ModifyFrame();
			}
		});
	    
	    JButton delete=new JButton("Delete");  
	    delete.setBounds(70,100,110,30);
	    delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new DeleteFrame();
			}
		});
	    
	    JButton view=new JButton("View");  
	    view.setBounds(70,150,110,30); 
	    view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new ViewFrame();
			}
		});
	    
	    JButton search=new JButton("Search");   
	    search.setBounds(70,200,110,30);
	    search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new SearchFrame();
			}
		});
	    
	    JButton sub=new JButton("Back");  
	    sub.setBounds(70,250,110,30);
	    sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new GUI_Assignment("");
			}
		});
	    
	    f.add(modify);f.add(delete);f.add(view);f.add(search);f.add(sub);
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);
	    
        setVisible(true);
        
        setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {}
}
