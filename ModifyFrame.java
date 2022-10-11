package numbers;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModifyFrame extends JFrame implements ActionListener {
	JFrame f=new JFrame("Modify");
	public ModifyFrame(){
		JLabel title = new JLabel("Modify");
		title.setFont(new Font("Arial", Font.PLAIN, 20));
		title.setSize(80, 20);
		title.setLocation(100, 20);
        f.add(title);
		
	    JButton modify=new JButton("Change Room");  
	    modify.setBounds(70,50,200,30);
	    modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new ChangeRoomFrame();
			}
		});
	    
	    JButton delete=new JButton("Change Stay Days");  
	    delete.setBounds(70,100,200,30);
	    delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new ChangeStayFrame();
			}
		});
	    
	    JButton sub=new JButton("Back");  
	    sub.setBounds(70,150,200,30);
	    sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new GUI_Assignment("");
			}
		});
	    
	    f.add(modify);f.add(delete);f.add(sub);
	    f.setSize(400,400);  
	    f.setLayout(null);  
	    f.setVisible(true);
	    
        setVisible(true);
        
        setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {}
}
