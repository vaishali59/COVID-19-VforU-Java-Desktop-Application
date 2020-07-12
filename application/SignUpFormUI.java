package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import application.SignUpFormData.*;
import validators.SignUpFormValidatorFactory;
import validators.ValidatorFactory;
import validators.Violations;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class SignUpFormUI implements UI {
	
	private SignUpFormData signUpFormData;
	private SignUpFormData.SignUpFormDataBuilder builder;
	private ValidatorFactory validatorfactory;
	private Violations signupviolations;

	private JFrame frame;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JLabel emailLabel;
	private JTextField emailField;
	private JLabel passwordLabel;
	private JLabel confirmPasswordLabel;
	private JLabel mobileLabel;
	private JPasswordField passwordField;
	private JTextField mobileField;
	private JButton signUpButton;
	private JRadioButton volunteerRadioButton;
	private JRadioButton requesterRadioButton_1;
	private JLabel signUpLabel;
	private JPasswordField confirmPasswordField;
	
	private MediatorInterface mediator;
	
	private UI presentUI;
	private JTextField citytextField;

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
	public SignUpFormUI(MediatorInterface mediator) {
		this.mediator = mediator;
		this.presentUI =this;
		this.builder = new SignUpFormData.SignUpFormDataBuilder();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("SignUp ");
		frame.setBounds(100, 100, 666, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel firstNameLabel = new JLabel("First Name: ");
		firstNameLabel.setBounds(6, 75, 76, 16);
		
		JLabel lastNameLabel = new JLabel("Last Name: ");
		lastNameLabel.setBounds(6, 115, 74, 16);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(88, 75, 572, 28);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(88, 115, 572, 28);
		lastNameField.setColumns(10);
		
		emailLabel = new JLabel("Email: ");
		emailLabel.setBounds(6, 165, 42, 16);
		
		emailField = new JTextField();
		emailField.setBounds(89, 159, 571, 28);
		emailField.setColumns(10);
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(6, 193, 67, 16);
		
		confirmPasswordLabel = new JLabel("Confirm Password: ");
		confirmPasswordLabel.setBounds(6, 241, 122, 16);
		
		mobileLabel = new JLabel("Mobile: ");
		mobileLabel.setBounds(6, 281, 50, 16);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 193, 217, 28);
		
		mobileField = new JTextField();
		mobileField.setBounds(104, 275, 134, 28);
		mobileField.setColumns(10);
		
		signUpButton = new JButton("SignUp");
		signUpButton.setBounds(6, 392, 88, 29);
		
		
		signUpLabel = new JLabel("SignUp NOW");
		signUpLabel.setBounds(210, 6, 79, 16);
		
		volunteerRadioButton = new JRadioButton("Volunteer");
		volunteerRadioButton.setBounds(103, 40, 92, 23);
		
		requesterRadioButton_1 = new JRadioButton("Requester");
		requesterRadioButton_1.setBounds(292, 40, 94, 23);
		
		JLabel signUpAsLabel = new JLabel("SignUp As: ");
		signUpAsLabel.setBounds(6, 44, 72, 16);
		
		ButtonGroup G1 = new ButtonGroup();
		 G1.add(volunteerRadioButton); 
		 G1.add(requesterRadioButton_1); 
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(148, 235, 188, 28);
		
		JLabel cityLabel = new JLabel("City");
		cityLabel.setBounds(6, 321, 67, 16);
		
		citytextField = new JTextField();
		citytextField.setBounds(103, 315, 134, 28);
		citytextField.setColumns(10);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(emailLabel);
		frame.getContentPane().add(emailField);
		frame.getContentPane().add(confirmPasswordLabel);
		frame.getContentPane().add(confirmPasswordField);
		frame.getContentPane().add(passwordLabel);
		frame.getContentPane().add(passwordField);
		frame.getContentPane().add(lastNameLabel);
		frame.getContentPane().add(firstNameLabel);
		frame.getContentPane().add(signUpAsLabel);
		frame.getContentPane().add(firstNameField);
		frame.getContentPane().add(volunteerRadioButton);
		frame.getContentPane().add(requesterRadioButton_1);
		frame.getContentPane().add(lastNameField);
		frame.getContentPane().add(mobileLabel);
		frame.getContentPane().add(mobileField);
		frame.getContentPane().add(cityLabel);
		frame.getContentPane().add(signUpLabel);
		frame.getContentPane().add(signUpButton);
		frame.getContentPane().add(citytextField);
	}
	
	private void createEvents() {
		signUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUpFormData = buildSignUpFormData();
				validatorfactory = new SignUpFormValidatorFactory();
				signupviolations = new Violations();
				validatorfactory.validate(signUpFormData,signupviolations);
				if(signupviolations.numberOfErrors()!=0) {
					JOptionPane.showMessageDialog(frame, signupviolations);  
				}
				else {
					mediator.notifyMediator(presentUI,"signup");
					frame.dispose();
				}
			}
		});
		
	}
	
	public SignUpFormData getData() {
		return signUpFormData;
	}
	
	private SignUpFormData buildSignUpFormData() {
		if(volunteerRadioButton.isSelected()) {
			builder =builder.withCustomerType(Type.volunteer);
		}
		else if(requesterRadioButton_1.isSelected()) {
			builder =builder.withCustomerType(Type.requester);
		}
		else{builder =builder.withCustomerType(Type.NULL);
		}
		builder =builder.withFirstName(firstNameField.getText())
		.withLastName(lastNameField.getText())
		.withEmail(emailField.getText())
		.withPassword(passwordField.getText())
		.withConfirmPassword(confirmPasswordField.getText())
		.withMobile(mobileField.getText())
		.withCity(citytextField.getText());
		return builder.build();
	}
}
