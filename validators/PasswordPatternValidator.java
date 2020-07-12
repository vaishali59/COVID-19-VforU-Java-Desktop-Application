package validators;

import java.util.regex.Pattern;

class PasswordPatternValidator extends Validator{
	private String password;
	
	PasswordPatternValidator(Object obj) {
		this.password = (String) obj;
	}

	@Override
	void validate(Violations violations) {
		String password_pattern_regex = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,20})";
		if(!Pattern.matches(password_pattern_regex,this.password)){
			violations.addError("Enter a 8-20 character long Password with"
					+ "at least one digit," + 
					"one lower case," + 
					"one upper case ," + 
					"one special (@ # $ % ! _ ) character");
		}
	}


}
