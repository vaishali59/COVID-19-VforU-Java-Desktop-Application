package validators;

public class SignUpFormValidatorFactory extends ValidatorFactory{

	@Override
	public Validator createValidator(Object obj) {
		return new SignUpFormValidator(obj);
	}

}
