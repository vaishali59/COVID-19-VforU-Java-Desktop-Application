package application;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RequestUI implements UI{

	private JFrame frame;
	private JTable table;
	private ArrayList<String> requests;
	private MediatorInterface mediator;
	private JButton detailButton;
	private RequestData d;
	private JButton select ;
	private javax.swing.table.DefaultTableModel mymodel;
	private UI presentUI;
	private JButton btnNewButton;
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
	public RequestUI(MediatorInterface mediator, ArrayList<String> requests) {
		this.mediator=mediator;
		this.requests=requests;
		this.presentUI=this;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		String [] colNames= {"ID", "Title", "City", "Zipcode"};
		mymodel = new javax.swing.table.DefaultTableModel(colNames, 0);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 51, 341, 167);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		detailButton = new JButton("Show Details");
		
		detailButton.setBounds(265, 12, 135, 29);
		frame.getContentPane().add(detailButton);
		
		select = new JButton("Select Job");
		select.setBounds(164, 228, 117, 29);
		frame.getContentPane().add(select);
		
	

		for(String s:requests) {
			String arr[]=s.split(",");
			mymodel.addRow(arr);   
		}
		
		table.setModel(mymodel);
		
		btnNewButton = new JButton("Go Back<---");
		
		btnNewButton.setBounds(313, 228, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
	}
	
	
	public void createEvents() {
		
		
		
		
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//if clicked then the row selected will be chosen 
				//else display error message to select a row
				
				int tableIndex = table.getSelectedRow();
				if (tableIndex > -1) {
					String value=mymodel.getValueAt(tableIndex, 0)+"";
					d=new RequestData(value);
					
					mediator.notifyMediator(presentUI, "jobselect");
					
					JOptionPane.showMessageDialog(frame, "You are assigned to this Job, Requester will be informed about you");
				}
				else {
					JOptionPane.showMessageDialog(frame, "Select a row to choose your Job");
				}
				
			}
		});
		
		
		detailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// check if there are any selections
				// if 1 selection present - show details in the popup
				
				// else display error msg "select a single row to show details"
				
				
				int tableIndex = table.getSelectedRow();
				if (tableIndex > -1) {
					String value=mymodel.getValueAt(tableIndex, 0)+"";
					//System.out.println(mymodel.getValueAt(tableIndex, 0));
					d=new RequestData(value);
					mediator.notifyMediator(presentUI, "request");
					JOptionPane.showMessageDialog(frame, "Address: \n"+getData().getInfo());
				}
				else {
					JOptionPane.showMessageDialog(frame, "Select a row to display details");
				}
				
		
				
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mediator.notifyMediator(presentUI, "goback");
				//mediator.getPreviousUI().display();
				frame.dispose();
			}
		});
		
		
		
	}
	
	
	
	public RequestData getData() {
		return d;
	}
	public void  setRequestData(RequestData d) {
		this.d=d;
	}
}
