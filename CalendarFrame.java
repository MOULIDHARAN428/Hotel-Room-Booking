package numbers;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class CalendarFrame {
	public CalendarFrame(){}
	public void actionPerformed(ActionEvent e) {
		JFrame frame = new JFrame("JXPicker Example");
        JPanel panel = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
	}
}
