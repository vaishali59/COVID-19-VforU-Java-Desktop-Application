package application;

public class SignUpFormData {
	
	public static enum Type {volunteer, requester, NULL};
	
	private Type customerType;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String confirmPassword;
	private String mobile;
	private String city;
	
	public SignUpFormData(SignUpFormDataBuilder signUpFormDataBuilder) {
		this.firstName = signUpFormDataBuilder.firstName;
		this.lastName = signUpFormDataBuilder.lastName;
		this.customerType = signUpFormDataBuilder.customerType;
		this.email = signUpFormDataBuilder.email;
		this.password = signUpFormDataBuilder.password;
		this.confirmPassword = signUpFormDataBuilder.confirmPassword;
		this.mobile = signUpFormDataBuilder.mobile;
		this.city=signUpFormDataBuilder.city;
	}

	
	public String getCity() {
		return city;
	}


	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public Type getCustomerType() {
		return customerType;
	}
	
	static class SignUpFormDataBuilder{
		private Type customerType;
		private String firstName;
		private String lastName;
		private String email;
		private String password;
		private String confirmPassword;
		private String mobile;
		
		private String city;
		
		
		public SignUpFormDataBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public SignUpFormDataBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public SignUpFormDataBuilder withEmail(String email) {
			this.email = email;
			return this;
		}
		
		public SignUpFormDataBuilder withPassword(String password) {
			this.password = password;
			return this;
		}
		
		public SignUpFormDataBuilder withConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
			return this;
		}
		
		public SignUpFormDataBuilder withMobile(String mobile) {
			this.mobile = mobile;
			return this;
		}
		
		public SignUpFormDataBuilder withCity(String city) {
			this.city = city.toUpperCase().replace(" ", "");
			
			return this;
		}
		
		
		public SignUpFormDataBuilder withCustomerType(Type customerType) {
			this.customerType = customerType;
			return this;
		}
		
		public SignUpFormData build() {
			return new SignUpFormData(this);
		}
	}
		
	public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.firstName);
        builder.append(this.lastName);
        builder.append(this.email);
        builder.append(this.password);
        builder.append(this.getConfirmPassword());
        builder.append(this.mobile);
        builder.append(this.city);
        return builder.toString();
    }
	
	
	
	

	
	
	

}
