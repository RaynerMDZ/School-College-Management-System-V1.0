package CoreJava.Models;

public class Attending {

    private String courseID, studentEmail;
    
    // Default constructor.
    public Attending() {
		
	}
      
    // Constructor with parameters.
    public Attending(String courseID, String studentEmail) {
		this.courseID = courseID;
		this.studentEmail = studentEmail;
	}
    
    // Getters and Setters.
	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}  
    
}
