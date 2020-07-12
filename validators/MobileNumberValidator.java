package validators;

import java.util.regex.Pattern;

class MobileNumberValidator extends Validator{
		private String mobile;
		
		MobileNumberValidator(Object obj) {
			this.mobile=(String) obj;
		}

		@Override
		void validate(Violations violations) {
			String mobile_pattern_regex = "^[1-9][0-9]{9}$";
			if(!Pattern.matches(mobile_pattern_regex,this.mobile)) {
				violations.addError("Enter Mobile Number in correct format");
			}
		}

}
