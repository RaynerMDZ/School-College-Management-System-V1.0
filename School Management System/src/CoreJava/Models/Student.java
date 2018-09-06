package CoreJava.Models;

public class Student {
	
	private String email, password, name;
	
	// Default constructor.
	public Student() {
		
	}
	
	// Constructor with parameters.
	public Student(String name, String password, String email) {
		this.email = email;
		this.password = password;
		this.name = name;
	}

	// Getters and Setters.
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
