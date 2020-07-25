import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIDemo {
	
	private JFrame frame;
	private JButton button;
	private int width;
	private int height;
	
	public GUIDemo(int w, int h) {
		frame = new JFrame();
		button = new JButton("CLICK ME");
		width = w;
		height = h;
	}
	
	public void setUpGUI() {
		frame.setSize(width, height);
		frame.setTitle("GUI Demo");
		frame.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void setUpButtonListeners() {
		ActionListener buttonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				System.out.println("click!");
			}
		};
		
		button.addActionListener(buttonListener);
	}

}
