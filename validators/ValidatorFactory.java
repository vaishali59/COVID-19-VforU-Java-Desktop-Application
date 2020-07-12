package validators;

public abstract class ValidatorFactory {
	
	abstract Validator createValidator(Object obj);
	
	public  void validate(Object obj, Violations violations) {
		Validator v;
		v = createValidator(obj);
		v.validate(violations);
	}

}

