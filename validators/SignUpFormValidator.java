package validators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import application.SignUpFormData;



class SignUpFormValidator extends Validator{
	private SignUpFormData signUpFormData;
	private List<Validator> validatorList;
	private Iterator iterator;
	
	SignUpFormValidator(Object obj){
		this.signUpFormData = (SignUpFormData) obj;
		this.validatorList = new ArrayList<Validator>();
	}
	
	Iterator createIterator() {
		return this.validatorList.iterator();
	}

	@Override
	void validate(Violations signupviolations) {
		addValidator();
		iterator = createIterator();
		while(iterator.hasNext()){
			Validator v = (Validator)iterator.next();
			v.validate(signupviolations);
		//for(Validator v : validatorList) {
			//v.validate(signupviolations);
			}
		}
	
	void addValidator() {
		validatorList.add(new CustomerTypeValidator(this.signUpFormData.getCustomerType()));
		validatorList.add(new EmailValidator(this.signUpFormData.getEmail()));
		validatorList.add(new EmailDuplicationValidator(this.signUpFormData.getEmail()));
		validatorList.add(new ConfirmPasswordValidator(this.signUpFormData.getPassword(),this.signUpFormData.getConfirmPassword()));
		validatorList.add(new PasswordPatternValidator(this.signUpFormData.getPassword()));
		validatorList.add(new MobileNumberValidator(this.signUpFormData.getMobile()));
	}
			
}




