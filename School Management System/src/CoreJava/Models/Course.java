package CoreJava.Models;

public class Course {

	private String courseID, courseName, instructor;
	
	// Default constructor.
	public Course() {
		
	}
	
	// Constructor with parameters.
	public Course(String courseID, String courseName, String instructor) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.instructor = instructor;
	}

	// Getters and Setters.
	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
}
