package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import application.AddressData;
import application.RequestDescriptionData;
import application.SignUpFormData;
import application.SignUpFormData.Type;


public class DatabaseQuery {
	Connection c;
	
	public DatabaseQuery(){
	DatabaseConnection db=DatabaseConnection.getInstance();
	c=db.getConnection();
	}
	public boolean hasEmail(String email) {
		boolean b=false;
		try {
		PreparedStatement pst = c.prepareStatement("Select * from usertable where email=?");
		pst.setString(1, email);
		
		ResultSet rs=pst.executeQuery();
		if(!rs.next()) {
			b=false;     //email is not present
		}
		else {
			b=true;      //email is present
		}
		
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Exception:"+e1);
		}
		return b;
		
	}
	
	public boolean isValidLogin(String email, String password) {
		boolean b=true;
		try {
		PreparedStatement pst = c.prepareStatement("Select * from usertable where email=?");
		pst.setString(1, email);
		
		ResultSet rs=pst.executeQuery();
		if(!rs.next()) {
			b=false;     //email is not present
		}
		else {
			if(rs.getString(4).equals(password)) {
				b=true;      //email and password match-> Valid user
			}
			else {
				b=false;     //wrong password
			}
		}
		
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Exception:"+e1);
		}
		return b;
	}
	
	public String getType(String email) {
		String type=null;
		
		try {
			PreparedStatement pst = c.prepareStatement("Select * from usertable where email=?");
			pst.setString(1, email);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				type=rs.getString(5);
			}
			
			
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("Exception:"+e1);
		}
		return type;
	
	}
	
	public void RegisterUser(SignUpFormData msignUpFormData) {
		PreparedStatement statement;
		SignUpFormData signUpFormData = msignUpFormData;
		try {
			statement = c.prepareStatement("Insert into usertable(firstname,lastname,email,password,usertype,phone,notification,city) values(?,?,?,?,?,?,?,?)");
			statement.setString(1,signUpFormData.getFirstName());
			statement.setString(2,signUpFormData.getLastName());
			statement.setString(3,signUpFormData.getEmail());
			statement.setString(4,signUpFormData.getPassword());
			statement.setString(5,signUpFormData.getCustomerType().toString());
			statement.setString(6,signUpFormData.getMobile());
			statement.setString(7,"");
			statement.setString(8,signUpFormData.getCity());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public ArrayList<String> getRequest(String city) {
		ArrayList<String> s=new ArrayList<String>();
		try {
			PreparedStatement pst = c.prepareStatement("Select * from requesttable where city=?");
			pst.setString(1, city);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				String str=""+rs.getString(2)+","+rs.getString(3)+","+rs.getString(5)+","+rs.getString(6);
				s.add(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
		
	}
	
	public String getRequestDetails(String id) {
		String str = null;
		
		try {
			PreparedStatement pst = c.prepareStatement("Select name, phone, fulladdress from requesttable where reqId=?");
			pst.setString(1, id);
			ResultSet rs=pst.executeQuery();
			
//			System.out.println(rs.next());
			while(rs.next()) {

				str=rs.getString(1)+"\n";
				str+=rs.getString(2)+"\n ";
				str+=rs. getString(3);
				System.out.println(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
	}
	
	public void notifyVolunteers(String city, String reqTitle, String reqid) {
		
		
		
		PreparedStatement pst4;
		try {
			pst4 = c.prepareStatement("Select * from usertable where city=? and usertype=?");
			pst4.setString(1, city);
			pst4.setString(2, Type.volunteer.toString());
			ResultSet rs2=pst4.executeQuery();
			while(rs2.next()) {
				String notification="There is a new Request with "+reqid+" for "+ reqTitle+ "\n";
				String n2=rs2.getString(7);
				if(n2!=null) {
					notification+=n2;
					
					//n2+=reqId + " has been
				}
				PreparedStatement pst3=c.prepareStatement("Update usertable set notification =? where email=?");
				pst3.setString(1, notification);
				
				pst3.setString(2,rs2.getString(3));
				pst3.executeUpdate();
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	
	
	public void updateRNotification(String email, String reqID) {
		String n1="";
		String notification;
		
		
		try {
			PreparedStatement pst1 = c.prepareStatement("Select notification from usertable where email=?");
			pst1.setString(1, email);
			ResultSet rs1=pst1.executeQuery();
			while(rs1.next()) {
				n1=rs1.getString(1);
				
			}
			notification=reqID+" is raised by you.\n";
			if(n1!=null) {
				notification+=n1;
			}
			
			PreparedStatement pst3=c.prepareStatement("Update usertable set notification =? where email=?");
			
			pst3.setString(1, notification);
			pst3.setString(2,email);
			pst3.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public String getNotified(String id, String mail) {
		
		String str = null;
		try {
			PreparedStatement pst = c.prepareStatement("Select * from requesttable where reqId=?");
			pst.setString(1, id);
			ResultSet rs=pst.executeQuery();
			String email="";
			String rcontent=" ";
			String vcontent=" ";
			String n1=" ";
			String n2=" ";
//			System.out.println(rs.next());
			while(rs.next()) {
				email=rs.getString(1);
				vcontent=id+" is assigned to you. Contact Requester. "+"Name: "+rs. getString(8)+" Phone Number: "+rs. getString(9);
				str=rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(7)+","+rs.getString(8)+","+rs.getString(9);
			}
			
			
			PreparedStatement p = c.prepareStatement("Delete from requesttable where reqId=?");
			p.setString(1, id);
			p.executeUpdate();
			
		
			PreparedStatement pst1 = c.prepareStatement("Select * from usertable where email=?");
			pst1.setString(1, mail);
			ResultSet rs1=pst1.executeQuery();
			while(rs1.next()) {
				n1=rs1.getString(7);
				rcontent=id+" is assigned to a volunteer. Here are the details. Name: "+rs1.getString(1)+" PhoneNumber: "+rs1.getString(6);
			}
			
			PreparedStatement pst2=c.prepareStatement("Update usertable set notification =? where email=?");
			vcontent+="\n";
			if(n1!=null) {
				vcontent+=n1;
			}
			
			pst2.setString(1, vcontent);
			pst2.setString(2,mail);
			pst2.executeUpdate();
			
			
			PreparedStatement pst4 = c.prepareStatement("Select * from usertable where email=?");
			pst4.setString(1, email);
			ResultSet rs2=pst4.executeQuery();
			while(rs2.next()) {
				n2=rs2.getString(7);
				
			}
			
			
			PreparedStatement pst3=c.prepareStatement("Update usertable set notification =? where email=?");
			rcontent+="\n";

			if(n2!=null) {
				rcontent+=n2;
			}
			pst3.setString(1, rcontent);
			pst3.setString(2,email);
			pst3.executeUpdate();
				
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return str;
	}
	public String getUserContent(String email) {
		String n="";
		
		try {
			PreparedStatement pst = c.prepareStatement("Select * from usertable where email=?");
			pst.setString(1, email);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				n=rs.getString(7);
				
			}
			if(n==null) {
				n="";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	
	
	
	
	
	
	
	public void AddRequest(RequestDescriptionData reqdesData, AddressData adrsData) {
		PreparedStatement statement;
		try {
			statement = c.prepareStatement("Insert into requesttable(requesterEmail, reqId, reqTitle, reqDescription, city, zipcode, fulladdress, name, phone)"
					+ " values(?,?,?,?,?,?,?,?,?)");
			statement.setString(1,reqdesData.getRequesterEmail());
			statement.setString(2,reqdesData.getReqId());
			statement.setString(3,reqdesData.getReqTitle());
			statement.setString(4,reqdesData.getReqDescription());
			statement.setString(5,adrsData.getCity());
			statement.setString(6,adrsData.getZipCode());
			statement.setString(7,adrsData.fullAddress());
			statement.setString(8,adrsData.getName());
			statement.setString(9,adrsData.getPhone());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}	

//	public boolean isVolunteer(String email) {
//		boolean b=true;
//		try {
//			PreparedStatement pst = c.prepareStatement("Select * from usertable where email=?");
//			pst.setString(1, email);
//
//			ResultSet rs=pst.executeQuery();
//			if(!rs.getString(6).equals("volunteer")) {
//				b=false;			//Not a volunteer
//			}
//			
//		}catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			System.out.println("Exception:"+e1);
//		}
//		return b;
//	}
//	
//	public boolean isRequester(String email) {
//		boolean b=true;
//		try {
//			PreparedStatement pst = c.prepareStatement("Select * from usertable where email=?");
//			pst.setString(1, email);
//
//			ResultSet rs=pst.executeQuery();
//			if(!rs.getString(6).equals("requester")) {
//				b=false;			//Not a requester
//			}
//			
//		}catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			System.out.println("Exception:"+e1);
//		}
//		return b;
//	}
	
	


