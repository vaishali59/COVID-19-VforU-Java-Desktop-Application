package validators;

class ConfirmPasswordValidator extends Validator{
	private String password;
	private String confirmPassword;
	
	ConfirmPasswordValidator(Object obj, Object obj1) {
		this.password = (String) obj;
		this.confirmPassword = (String) obj1;
	}

	@Override
	void validate(Violations violations) {
		if(!this.password.equals(this.confirmPassword)){
			violations.addError("Confirm Password should match Password given");
		}
	}
	
}
