package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddressUI implements UI {

	private JFrame frame;
	private JButton submit;
	private JTextField nametextField;
	private JTextField addresstextField_1;
	private JTextField addresstextField_2;
	private JTextField citytextField;
	private JTextField statetextField;
	private JTextField ziptextField;
	private JTextField countrytextField;
	private JTextField phonetextField;
	
	private AddressData.AddressDataBuilder addressDatabuilder;
	private AddressData addressData;
	private MediatorInterface mediator;
	
	private UI presentUI;
	private JButton cancel;
	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AddressUI window = new AddressUI(requestDatabuilder);
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
	 * @param mediator 
	 * @param requestDatabuilder 
	 */
	public AddressUI(MediatorInterface mediator) {
		this.mediator = mediator;
		this.presentUI = this;
		this.addressDatabuilder = new AddressData.AddressDataBuilder();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 739, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel heading1 = new JLabel("Provide Address where you want services to be delivered");
		
		JLabel name = new JLabel("Full Name");
		
		nametextField = new JTextField();
		nametextField.setColumns(10);
		
		JLabel addressline1 = new JLabel("Address Line 1");
		
		addresstextField_1 = new JTextField();
		addresstextField_1.setToolTipText("Street address, Company Name, c/o");
		addresstextField_1.setColumns(10);
		
		JLabel addressline2 = new JLabel("Address Line 2");
		
		addresstextField_2 = new JTextField();
		addresstextField_2.setToolTipText("Apartment, Suite, Unit, Building, Floor, etc. ");
		addresstextField_2.setColumns(10);
		
		JLabel city = new JLabel("City");
		
		citytextField = new JTextField();
		citytextField.setColumns(10);
		
		JLabel state = new JLabel("State/Province/Region");
		
		statetextField = new JTextField();
		statetextField.setColumns(10);
		
		JLabel zip = new JLabel("Zip");
		
		ziptextField = new JTextField();
		ziptextField.setColumns(10);
		
		JLabel country = new JLabel("Country");
		
		countrytextField = new JTextField();
		countrytextField.setColumns(10);
		
		JLabel phone = new JLabel("Phone");
		
		phonetextField = new JTextField();
		phonetextField.setText("");
		phonetextField.setColumns(10);
		
		submit = new JButton("Submit");
		
		
		cancel = new JButton("Cancel");
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(heading1)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(name)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(nametextField, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(addressline1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(addresstextField_1, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(addressline2)
							.addGap(18)
							.addComponent(addresstextField_2, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(city)
							.addGap(18)
							.addComponent(citytextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(state)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(statetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(zip)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ziptextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(phone)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(phonetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(submit)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cancel))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(country)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(countrytextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(259, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(heading1)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(name)
						.addComponent(nametextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addressline1)
						.addComponent(addresstextField_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addressline2)
						.addComponent(addresstextField_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(city)
						.addComponent(citytextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(state)
						.addComponent(statetextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(zip)
						.addComponent(ziptextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(country)
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(phone)
								.addComponent(phonetextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
						.addComponent(countrytextField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(submit)
						.addComponent(cancel))
					.addGap(26))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void createEvents() {
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addressDatabuilder =addressDatabuilder.withName(nametextField.getText())
						.withAddressField1(addresstextField_1.getText())
						.withAddressField2(addresstextField_2.getText())
						.withCity(citytextField.getText())
						.withState(statetextField.getText())
						.withCountry(countrytextField.getText())
						.withZipCode(ziptextField.getText())
						.withPhone(phonetextField.getText());
				
				if(addressDatabuilder.toString().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please fill all the fields");
					}
				else {
					addressData = addressDatabuilder.build();
					JOptionPane.showMessageDialog(frame, "You will shortly receive the details of the volunteer who will help you. \n THANK YOU !");
					mediator.notifyMediator(presentUI,"submitRequest");
					frame.dispose();
					}
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediator.notifyMediator(presentUI,"cancel");
				frame.dispose();
			}
		});
	}
	
	public AddressData getData() {
		return this.addressData;
	}
}
