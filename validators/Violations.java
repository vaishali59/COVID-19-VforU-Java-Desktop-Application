package validators;

import java.util.ArrayList;

import java.util.List;

public class Violations {
	//HashMap<String,Object> errorList = new HashMap<String,Object>();
	List<Object> errorList = new ArrayList<Object>();
	
	List<Object> addError(Object error){
		//errorList.put(field, error);
		errorList.add(error);
		return errorList;
	}
	
	public int numberOfErrors() {
		return errorList.size();
	}
	
	public String toString() {
		String results = "";
	    for(Object error : this.errorList) {
	        results += error.toString() + '\n';
	    }
	    return results;
		
	}
}


