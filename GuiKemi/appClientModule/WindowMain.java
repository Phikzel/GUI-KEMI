import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class WindowMain {

	private JFrame frame;
	private JTextField textField;
	private enum State { None, Start, Stop};
	private State state; // 0, 1, 2
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowMain window = new WindowMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		state = State.Start;
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("What are you working on?");
		lblNewLabel.setBounds(10, 24, 177, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(10, 49, 309, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Start");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				mouseButtonPressed(arg0);
			}
		});
		btnNewButton.setBounds(335, 48, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
	
	private void mouseButtonPressed(MouseEvent ev) {
		toggleState();
		btnNewButton.setText(state.toString());
	}
	
	private void toggleState() {
		if(state == State.None) return;
		if (state == State.Start) {
			state = State.Stop; return; 
		}
		if (state == State.Stop) {
			state = State.Start; return; 
		}
	}
}
