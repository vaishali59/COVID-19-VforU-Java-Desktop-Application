	package application;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import javax.swing.JTextArea;
import javax.swing.JButton;

public class RequesterUI implements UI {

	private JFrame frame;
	private JRadioButton groceryRadioButton;
	private JRadioButton pharmacyRadioButton;
	private JRadioButton medicalRadioButton;
	private JTextArea grocerytextArea;
	private JTextArea pharmacytextArea;
	private JTextArea medicaltextArea;
	private JButton requestButton;
	private JButton cancelButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	
	private String requesterEmail;
	private RequestDescriptionData.RequestDescriptionBuilder requestDescriptionBuilder;
	private RequestDescriptionData requestDescriptionData;
	private MediatorInterface mediator;
	
	private UI presentUI;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	
	private String notification;

	public String getNotification() {
		return notification;
	}

	public void setNotification(String not) {
		this.notification = not;
	}

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					createrEvents();
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
	public RequesterUI(MediatorInterface mediator, String email) {
		this.mediator = mediator;
		this.presentUI = this;
		this.requesterEmail = email;
		requestDescriptionBuilder = new RequestDescriptionData.RequestDescriptionBuilder();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 645, 495);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String [] req=requesterEmail.split("@");
		JLabel heading1 = new JLabel("WELCOME  " +  req[0].toUpperCase()  + "  WE ARE HERE FOR U");
		JLabel heading2 = new JLabel("Let us know how we can assist you");
		
		groceryRadioButton = new JRadioButton("Grocery");
		
		pharmacyRadioButton = new JRadioButton("Pharmacy");
		
		medicalRadioButton = new JRadioButton("Medical Assistance");
		
		grocerytextArea = new JTextArea("");
		grocerytextArea.setToolTipText("List here the Grocery items you need with quanity.");
		grocerytextArea.setColumns(25);
		
		pharmacytextArea = new JTextArea("");
		pharmacytextArea.setToolTipText("List here the Pharmacy items you need with quantity.");
		pharmacytextArea.setColumns(25);
		pharmacytextArea.setWrapStyleWord(true);
		pharmacytextArea.setLineWrap(true);
		
		medicaltextArea = new JTextArea("");
		medicaltextArea.setToolTipText("Kindly describe the type of medical assistance you need.");
		medicaltextArea.setColumns(30);
		medicaltextArea.setWrapStyleWord(true);
		medicaltextArea.setLineWrap(true);
		
		requestButton = new JButton("Request");
		
		cancelButton = new JButton("Cancel");
		
		
		lblNewLabel = new JLabel("");
		
		lblNewLabel_1 = new JLabel("");
		
		btnNewButton = new JButton("Logout");
		
		
		btnNewButton_1 = new JButton("My Notifications");
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(heading2)
					.addPreferredGap(ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
					.addComponent(btnNewButton_1))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(groceryRadioButton)
						.addComponent(pharmacyRadioButton)
						.addComponent(medicalRadioButton)
						.addComponent(requestButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(cancelButton)
						.addComponent(pharmacytextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(grocerytextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(medicaltextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(155)
					.addComponent(heading1)
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(heading1)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(heading2)
						.addComponent(btnNewButton_1))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel)
							.addGap(2)
							.addComponent(grocerytextArea, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(groceryRadioButton)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel_1)
							.addGap(1)
							.addComponent(pharmacytextArea, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(pharmacyRadioButton)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(medicaltextArea, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addComponent(medicalRadioButton)))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(requestButton)
						.addComponent(cancelButton))
					.addGap(78))
		);
		grocerytextArea.setVisible(false);
		pharmacytextArea.setVisible(false);
		medicaltextArea.setVisible(false);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private void createrEvents() {
		groceryRadioButton.addItemListener(new ItemListener() { 
		    @Override
		    public void itemStateChanged(ItemEvent event) {
		        int state = event.getStateChange();
		        if (state == ItemEvent.SELECTED) {
		        	grocerytextArea.setVisible(true);
		        } else if (state == ItemEvent.DESELECTED) {
		        	grocerytextArea.setVisible(false);
		        }
		    }
		});
		
		pharmacyRadioButton.addItemListener(new ItemListener() { 
		    @Override
		    public void itemStateChanged(ItemEvent event) {
		        int state = event.getStateChange();
		        if (state == ItemEvent.SELECTED) {
		        	pharmacytextArea.setVisible(true);
		        } else if (state == ItemEvent.DESELECTED) {
		        	pharmacytextArea.setVisible(false);
		        }
		    }
		});
		
		medicalRadioButton.addItemListener(new ItemListener() { 
		    @Override
		    public void itemStateChanged(ItemEvent event) {
		        int state = event.getStateChange();
		        if (state == ItemEvent.SELECTED) {
		        	medicaltextArea.setVisible(true);
		        } else if (state == ItemEvent.DESELECTED) {
		        	medicaltextArea.setVisible(false);
		        }
		    }
		});
		
		
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediator.notifyMediator(presentUI, "cancel");
				frame.dispose();
			}
		});
		
		
		
		requestButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				StringBuilder description = new StringBuilder();
				StringBuilder title = new StringBuilder();
				boolean flag = false;
				if(!grocerytextArea.getText().isEmpty()) {
					description.append("------Grocery------" + '\n')
					.append(grocerytextArea.getText() + '\n');
					title.append("Grocery");
					flag=true;
					}
				if(!pharmacytextArea.getText().isEmpty()) {
					description.append("------Pharmacy------" +'\n')
					.append(pharmacytextArea.getText() + '\n');
					title.append("Pharmacy");
					flag=true;
					}
				if(!medicaltextArea.getText().isEmpty()) {
					description.append("------Medical------" + '\n')
					.append(medicaltextArea.getText() + '\n');
					title.append("Medical");
					flag=true;
					}
				
				if(!flag) {
					JOptionPane.showMessageDialog(frame, "Please provide the details of service required");
				}
				else {
					requestDescriptionData = requestDescriptionBuilder.withRequesterEmail(requesterEmail)
							.withReqDescription(description.toString())
							.withReqTitle(title.toString())
							.build();
					mediator.notifyMediator(presentUI, "addDescription");
					frame.dispose();
				}	
			}	
		});	
		
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediator.notifyMediator(presentUI, "notification");
				String n=getNotification();
				
				if(n.length()==0) {
					JOptionPane.showMessageDialog(frame, "There are no recent Notifications"); 
				}
				else {
					JOptionPane.showMessageDialog(frame,n); 
				}
			}
		});
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mediator.notifyMediator(presentUI,"HomeUI");
				
				frame.dispose();
			}
		});
			
	}
	
	public RequestDescriptionData getData() {
		return requestDescriptionData;
	}
	
	public String getEmail() {
		return requesterEmail;
	}
	
}
