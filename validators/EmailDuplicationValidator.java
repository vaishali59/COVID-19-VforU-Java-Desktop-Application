package validators;

import dataBase.DatabaseQuery;

public class EmailDuplicationValidator extends Validator {
	private DatabaseQuery database = new DatabaseQuery();
    private String email;
    
    
    EmailDuplicationValidator(Object obj) {
        this.email = (String) obj;
    }

	@Override
	void validate(Violations violation) {
		if (database.hasEmail(email)) {
            violation.addError("This email is already registered!");
        }
		
	}

}
