package application;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class VolunteerUI implements UI{
private String volunteermail;
private MediatorInterface mediator;
private UI presentUI;
//private CityData cdata;
private String city;
private JButton logout;
private JFrame volunteerframe;
private JTextField citytext;
private JButton search;
private boolean flag;
private JButton nButton;
private String notification;
	public String getNotification() {
	return notification;
}

public void setNotification(String not) {
	this.notification = not;
}

	public boolean isFlag() {
	return flag;
}

public void setFlag(boolean flag) {
	this.flag = flag;
}

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
//initVolunteer()
	@Override
	public void display() {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//VolunteerUI window = new VolunteerUI();
					initialize();
					createEvents();
					volunteerframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	/**
	 * Create the application.
	 */
	public VolunteerUI(MediatorInterface mediator,String email) {
		this.mediator=mediator;
		this.volunteermail=email;
		this.presentUI=this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String [] vol=volunteermail.split("@");
		setFlag(false);
		volunteerframe = new JFrame();
		volunteerframe.setBounds(100, 100, 450, 300);
		volunteerframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		volunteerframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   WELCOME      " +  vol[0].toUpperCase());
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setBounds(98, 6, 302, 28);
		volunteerframe.getContentPane().add(lblNewLabel);
		
		logout = new JButton("Logout");
		
		logout.setBounds(327, 44, 117, 29);
		volunteerframe.getContentPane().add(logout);
		
		JLabel lblNewLabel_1 = new JLabel("City");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(21, 80, 48, 16);
		volunteerframe.getContentPane().add(lblNewLabel_1);
		
		citytext = new JTextField();
		citytext.setBounds(92, 75, 134, 28);
		volunteerframe.getContentPane().add(citytext);
		citytext.setColumns(10);
		
		search = new JButton("Search");
		
		search.setBounds(98, 110, 117, 29);
		volunteerframe.getContentPane().add(search);
		
		nButton = new JButton("My Notifications");
		
		nButton.setBounds(296, 88, 148, 29);
		volunteerframe.getContentPane().add(nButton);
		
			
		
	}
	
	public void createEvents() {
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediator.notifyMediator(presentUI,"HomeUI");
				
				volunteerframe.dispose();
				
			}
		});
		
		
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				city=citytext.getText().toUpperCase().replace(" ", "");
				//cdata=new CityData(city);
				System.out.println(city);

				mediator.notifyMediator(presentUI,"requestUI");
				if(isFlag()) {
					JOptionPane.showMessageDialog(volunteerframe, "No volunteer oppurtunities in the city. Thank you"); 
					
				}
				else {
					volunteerframe.dispose();
				}
			}
		});
		
		
		nButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mediator.notifyMediator(presentUI, "notification");
				String n=getNotification();
				
				if(n.length()==0) {
					JOptionPane.showMessageDialog(volunteerframe, "There are no recent Notifications"); 
				}
				else {
					JOptionPane.showMessageDialog(volunteerframe,n); 
				}
				
			}
		});
		
	}
	public String getEmail() {
		return this.volunteermail;
	}
	public String getCity() {
		return city;
	}
}
