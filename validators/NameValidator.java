package validators;

import java.util.regex.Pattern;

public class NameValidator extends Validator{
	private String firstName;
	private String lastName;
	
	
	NameValidator(Object obj, Object obj1) {
		this.firstName=(String) obj;
		this.lastName = (String) obj1;
	}

	@Override
	void validate(Violations violation) {
		String name_pattern_regex = "[A-Z][a-z]*";
		if(!Pattern.matches(name_pattern_regex,this.firstName) || !Pattern.matches(name_pattern_regex, lastName)) {
			violation.addError("Enter all Name fields");
			}
		}
		
}


