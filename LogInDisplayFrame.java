package numbers;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class LogInDisplayFrame extends JFrame implements ActionListener {
	public static String staff="";
	private JFrame f = new JFrame("Log In");
		private Container c;
	    private JLabel title;
	    private JLabel info;
	    private JButton sub;
	    
	    public LogInDisplayFrame(String str)
	    {
	        setTitle("Log In");
	        setBounds(300, 90, 900, 600);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);
	 
	        c = getContentPane();
	        c.setLayout(null);
	 
	        title = new JLabel("Log In");
	        title.setFont(new Font("Arial", Font.PLAIN, 30));
	        title.setSize(300, 30);
	        title.setLocation(200, 30);
	        c.add(title);
	        
        	info = new JLabel(str);
        	info.setFont(new Font("Arial", Font.PLAIN, 20));
        	info.setSize(1000, 20);
        	info.setLocation(100, 100);
	        c.add(info);
	 
	        sub = new JButton("Back");
	        sub.setFont(new Font("Arial", Font.PLAIN, 15));
	        sub.setSize(100, 20);
	        sub.setLocation(200, 150);
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
