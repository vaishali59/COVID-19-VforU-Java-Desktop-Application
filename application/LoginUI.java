package application;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import validators.ValidatorFactory;
import validators.Violations;
import validators.LoginFormValidatorFactory;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginUI implements UI{
	private JFrame frame;
	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;
	private JButton login;
	private LoginData loginData;
	private ValidatorFactory validatorfactory;
	private Violations loginviolations;
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
	 * Create the UI.
	 */
	public LoginUI(MediatorInterface mediator) {
		this.mediator=mediator;
		this.presentUI = this;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(18, 66, 115, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(18, 124, 115, 39);
		contentPane.add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(140, 71, 134, 28);
		contentPane.add(email);
		email.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(140, 129, 134, 28);
		contentPane.add(password);
		
		login = new JButton("Login");
		
		login.setBounds(67, 185, 117, 29);
		contentPane.add(login);	
	}
	
	private void setlogInFormData() {
		((LoginData) loginData).setEmail(email.getText());
		((LoginData) loginData).setPassword(password.getText());
		}
	
	private void createEvents() {
		login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				loginData = new LoginData();
				setlogInFormData();
				validatorfactory = new LoginFormValidatorFactory();
				loginviolations = new Violations();
				validatorfactory.validate(loginData,loginviolations);
				if(loginviolations.numberOfErrors()!=0) {
					JOptionPane.showMessageDialog(frame, loginviolations);  
				}
				else {
					JOptionPane.showMessageDialog(frame,"Login Successful");
					mediator.notifyMediator(presentUI,"login");
					frame.dispose();
				}
			}
		});	
	}
	
	public LoginData getData() {
		return loginData;
	}
			
}				
				

	

