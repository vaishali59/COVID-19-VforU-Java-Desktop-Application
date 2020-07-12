package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
//import javax.swing.JTextField;
//import javax.swing.JTextArea;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeUI implements UI{

	private JFrame frame;
	private JButton loginbutton;
	private JButton signupbutton;
	private MediatorInterface mediator;
	
	private UI presentUI;

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					createEvents();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeUI(MediatorInterface mediator) {
		this.mediator =mediator;
		this.presentUI =this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("  VforU");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel.setBounds(180, 6, 117, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Find the Best Volunteer for You");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(130, 40, 229, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(18, 68, 411, 67);
		frame.getContentPane().add(textPane);
		String text="VforU matches you with volunteers who can help you when ever and where ever you are in need.";
		text=text+" We assure you to provide your required assistance. Connect with our volunteers and get your job done";
		textPane.setText(text);
		textPane.setEditable(false);
		
		loginbutton = new JButton("Login");
		
		loginbutton.setBounds(86, 167, 117, 29);
		frame.getContentPane().add(loginbutton);
		
		signupbutton = new JButton("Signup");
		
		signupbutton.setBounds(242, 167, 117, 29);
		frame.getContentPane().add(signupbutton);
		
	}
	
	private void createEvents() {
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediator.notifyMediator(presentUI,"login");
				frame.dispose();	
			}
		});
		
		signupbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediator.notifyMediator(presentUI,"signup");
				frame.dispose();
			}
		});
	}
}
