package application;

public class AddressData{
	
	private String name;
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String phone;
	
	private AddressData(AddressDataBuilder addressDataBuilder) {
		this.name = addressDataBuilder.name;
		this.addressline1 = addressDataBuilder.addressline1;
		this.addressline2 = addressDataBuilder.addressline2;
		this.city = addressDataBuilder.city;
		this.state = addressDataBuilder.state;
		this.country = addressDataBuilder.country;
		this.zipCode = addressDataBuilder.zipCode;
		this.phone = addressDataBuilder.phone;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getZipCode() {
		return zipCode;
	}

	public String getPhone() {
		return phone;
	}
	
	public String fullAddress() {
		StringBuilder builder = new StringBuilder();
        builder.append(this.addressline1 + '\n')
                .append(this.addressline2 + '\n')
                .append(this.city + '\n')
                .append(this.state + ", " + this.country +'\n')
                .append(this.zipCode + '\n');
        return builder.toString();
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
        builder.append(this.name + '\n')
                .append(this.addressline1 + '\n')
                .append(this.addressline2 + '\n')
                .append(this.city + '\n')
                .append(this.state + ", " + this.country +'\n')
                .append(this.zipCode + '\n')
                .append(this.phone + '\n');
        return builder.toString();
	}
	
	static class AddressDataBuilder{
		private String name;
		private String addressline1;
		private String addressline2;
		private String city;
		private String state;
		private String country;
		private String zipCode;
		private String phone;
		
		public AddressDataBuilder withName(String name) {
			this.name = name;
			return this;
		}
		
		public AddressDataBuilder withAddressField1(String addressline1) {
			this.addressline1 = addressline1;
			return this;
		}

		public AddressDataBuilder withAddressField2(String addressline2) {
			this.addressline2 = addressline2;
			return this;
		}
		
		public AddressDataBuilder withCity(String city) {
			this.city = city.toUpperCase().replace(" ", "");
			return this;
		}

		public AddressDataBuilder withState(String state) {
			this.state = state;
			return this;
		}

		public AddressDataBuilder withCountry(String country) {
			this.country=country;
			return this;
		}
		
		
		public AddressDataBuilder withZipCode(String zipcode) {
			this.zipCode = zipcode;
			return this;
		}
		
		public AddressDataBuilder withPhone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public AddressData build() {
			return new AddressData(this);
		}
		
		public String toString() {
			StringBuilder builder = new StringBuilder();
	        builder.append(this.name)
	                .append(this.addressline1)
	                .append(this.addressline2)
	                .append(this.city)
	                .append(this.state)
	                .append(this.country)
	                .append(this.zipCode)
	                .append(this.phone);
	        return builder.toString(); 
		}
				
	}

}
