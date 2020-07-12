package validators;

import java.util.Iterator;

abstract class Validator {
	void addValidator() {}
	Iterator createIterator() {return null;}
	abstract void validate(Violations violation);
}
