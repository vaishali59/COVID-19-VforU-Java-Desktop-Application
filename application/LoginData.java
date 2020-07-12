package application;

public class LoginData {
	
	private String email;
	private String password;
	
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	void setEmail(String email) {
		this.email = email;
	}
	
	void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		//return this.email.toString() + this.password.toString();
        StringBuilder builder = new StringBuilder();
        builder.append("email: " + this.email + "\n");
        builder.append("password: " + this.password + "\n");
        return builder.toString();
    }

}
