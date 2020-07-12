package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class EmailValidator extends Validator{
	private String email;
	
	EmailValidator(Object obj) {
		this.email=(String) obj;
	}

	@Override
	void validate(Violations violations) {
		Pattern regex = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher m = regex.matcher(this.email);    
		if(!m.matches()) {
			violations.addError("Enter a valid e-mail address");
		}
	}
	
}