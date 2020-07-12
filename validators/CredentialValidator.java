package validators;

import dataBase.DatabaseQuery;

public class CredentialValidator extends Validator{
	DatabaseQuery database = new DatabaseQuery();
	
	String email;
	String password;
	   
	CredentialValidator(Object obj, Object obj1) {
		this.email = (String) obj;
	    this.password = (String) obj1;
	    }
	
	@Override
	void validate(Violations violation) {
	    if (!database.isValidLogin(email, password)) {
	    	violation.addError("Email or Password entered is not correct");
	    }
	        
	 }

}

