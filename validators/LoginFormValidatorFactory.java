package validators;

public class LoginFormValidatorFactory extends ValidatorFactory{

	@Override
	public Validator createValidator(Object obj) {
		return new LoginFormValidator(obj);
	}

}


