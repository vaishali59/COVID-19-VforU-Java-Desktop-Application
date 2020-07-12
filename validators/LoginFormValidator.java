package validators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import application.LoginData;



public class LoginFormValidator extends Validator {
	private LoginData loginData;
	private List<Validator> validatorList;
	private Iterator iterator;
	
	LoginFormValidator(Object obj){
		this.loginData = (LoginData) obj;
		this.validatorList = new ArrayList<Validator>();
	}
	
	void addValidator() {
		this.validatorList.add(new CredentialValidator(this.loginData.getEmail(), this.loginData.getPassword()));
	}
	
	Iterator createIterator() {
		return this.validatorList.iterator();
	}
	
	@Override
	void validate(Violations loginViolation) {
		addValidator();
		iterator = createIterator();
		while(iterator.hasNext()){
			Validator v = (Validator)iterator.next();
			v.validate(loginViolation);
			//for(Validator v : validatorList) {
				//v.validate(loginViolation);
			}
	}
	
	

}
