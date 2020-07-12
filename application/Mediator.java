package application;

import java.util.ArrayList;

import dataBase.DatabaseQuery;

//Role of this Mediator is to act as a hub between UIs and DB
//  UIs ----(gives Data class objs)---->Mediator------(pass Data objs to DB to store Data) -----> DB
public class Mediator implements MediatorInterface{
	DatabaseQuery databaseQuery;
	RequestDescriptionData requestDescriptionData;
	AddressData addressData;
	UI nextUI;
	UI previousUI;

	public Mediator() {
		databaseQuery = new DatabaseQuery();
	}

	public void notifyMediator(UI sender, String event){

		if(sender instanceof HomeUI && event.equalsIgnoreCase("login")) {

			this.nextUI = new LoginUI(this);
			this.previousUI=sender;

		}

		if(sender instanceof HomeUI && event.equalsIgnoreCase("signup")) {
			this.nextUI = new SignUpFormUI(this);
			this.previousUI=sender;

		}

		if (sender instanceof SignUpFormUI && event.equalsIgnoreCase("signup")) {
			SignUpFormData signUpFormData = ((SignUpFormUI) sender).getData();
			databaseQuery.RegisterUser(signUpFormData);
			this.nextUI = new LoginUI(this);
			this.previousUI=sender;

		}

		if (sender instanceof LoginUI && event.equalsIgnoreCase("login")) {
			LoginData loginData = ((LoginUI) sender).getData();
			String email = loginData.getEmail();
			String userType;
			userType = databaseQuery.getType(email);

			if(userType.equalsIgnoreCase("Volunteer")){
				this.nextUI = new VolunteerUI(this, email);
				this.previousUI=sender;

			}
			else if(userType.equalsIgnoreCase("Requester")){
				this.nextUI = new RequesterUI(this, email);	
				this.previousUI=sender;

			}
			else ;;
		}

		if(sender instanceof VolunteerUI) {

			if(event.equalsIgnoreCase("requestUI")) {

				String city=((VolunteerUI) sender).getCity();
				ArrayList<String> s=new ArrayList<String>();

				s=databaseQuery.getRequest(city);
				if(s.size()==0) {
					((VolunteerUI) sender).setFlag(true);
					this.nextUI=new NullUI();
				}
				else {
					this.nextUI =new RequestUI(this,s);
					this.previousUI=sender;

				}
			}


			if(event.equalsIgnoreCase("HomeUI")) {
				this.nextUI =new HomeUI(this);
				this.previousUI=sender;

			}

			if(event.equalsIgnoreCase("notification")) {

				String notification=databaseQuery.getUserContent(((VolunteerUI) sender).getEmail());


				((VolunteerUI) sender).setNotification(notification);
				this.nextUI=new NullUI();
			}

		}

		if(sender instanceof RequestUI) {
			if(event.equalsIgnoreCase("request")) {
				RequestData r=((RequestUI) sender).getData();
				String details=databaseQuery.getRequestDetails(r.toString());

				r.setInfo(details);
				//((RequestUI) sender).setRequestData(r);
				this.nextUI=new NullUI();


			}

			if(event.equalsIgnoreCase("jobselect")) {
				RequestData r=((RequestUI) sender).getData();
				//				VolunteerUI u=((VolunteerUI) this.previousUI);
				//				String mail=u.getEmail();
				//				r.toString(),mail
				String details=databaseQuery.getNotified(r.toString(),((VolunteerUI) this.previousUI).getEmail());
				r.setInfo(details);
				this.nextUI=new NullUI();
			}

			if(event.equalsIgnoreCase("goback")) {
				this.previousUI.display();
				this.nextUI=new NullUI();
			}


		}


		if(sender instanceof RequesterUI && event.equalsIgnoreCase("addDescription") ) {
			this.nextUI = new AddressUI(this);
			this.previousUI=sender;

			this.requestDescriptionData = ((RequesterUI) sender).getData();
			//System.out.println(this.requestDescriptionData);

		}
		if(sender instanceof RequesterUI  && event.equalsIgnoreCase("cancel")) {

			this.nextUI=sender;


		}
		if(sender instanceof RequesterUI  && event.equalsIgnoreCase("notification")) {

			String notification=databaseQuery.getUserContent(((RequesterUI) sender).getEmail());


			((RequesterUI) sender).setNotification(notification);
			this.nextUI=new NullUI();
		}

		if(sender instanceof RequesterUI  && event.equalsIgnoreCase("HomeUI")) {
			this.nextUI =new HomeUI(this);
			this.previousUI=sender;

		}


		if(sender instanceof AddressUI && event.equalsIgnoreCase("submitRequest")) {



			this.addressData = ((AddressUI) sender).getData();
			databaseQuery.AddRequest(requestDescriptionData, addressData);
			databaseQuery.updateRNotification(requestDescriptionData.getRequesterEmail(), requestDescriptionData.getReqId());
			databaseQuery.notifyVolunteers(addressData.getCity(), requestDescriptionData.getReqTitle(), requestDescriptionData.getReqId()) ;



			this.previousUI.display();
			this.nextUI=new NullUI();



		}
		if(sender instanceof AddressUI  && event.equalsIgnoreCase("cancel")) {

			this.nextUI=sender;


		}



		this.nextUI.display();

	}





	public UI getNextUI() {
		return this.nextUI;
	}
	public UI getPreviousUI() {
		return this.previousUI;
	}


}
