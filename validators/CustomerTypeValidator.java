package validators;

import application.SignUpFormData.Type;

public class CustomerTypeValidator extends Validator{
	private Type customerType;

	CustomerTypeValidator(Object obj) {
		this.customerType = (Type) obj;
	}

	@Override
	void validate(Violations violation) {
		if(this.customerType.equals(Type.NULL)) {
			violation.addError("Select a Customer Type");
			}
		}
		
}