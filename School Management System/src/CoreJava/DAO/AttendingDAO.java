package CoreJava.DAO;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Util.FileHandler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AttendingDAO {

    public List<Attending> getAttending() throws IOException {
    	
    	return FileHandler.attendingToList("Attending.csv", "attending");
    }

    /**
     * Registers a new course associated with the Student
     * @param attendings
     * @param studentEmail
     * @param courseID
     * @throws IOException
     */
    public void registerStudentToCourse (List<Attending> attendings, String studentEmail, String courseID) throws IOException {
    	
    	Boolean isFound = false;
    	
    	CourseDAO courses = new CourseDAO();
    	List<Course> courseList = courses.getAllCourses(); 
    	
    	// Check if the student is already enrolled in this course
    	for (Attending attending : attendings) {
			if (attending.getCourseID().equals(courseID) &&    attending.getStudentEmail().equalsIgnoreCase(studentEmail)) {
				
				isFound = true;
				break;
			}
		}
    	
    	// If the course is not found, write it to the Attending file
    	if (isFound == false) {
    		
    		// Check if the provided ID is in the main course ID
    		for (Course course : courseList) {
    			
    			if (course.getCourseID().equals(courseID)) {
    				
    				FileWriter writer = new FileWriter("Attending.csv", true);
    	    		
    	    		writer.append(courseID);
    	    		writer.append(",");
    	    		writer.append(studentEmail);
    	    		writer.append("\n");
    	    		
    	    		writer.close();
    			}	
			}
    	}
    	
    	// Otherwise, the course is not valid.
    }

    /**
     * Returns all the student courses
     * @param courseList
     * @param attending
     * @param studentEmail
     * @return
     * @throws IOException
     */
    public List<Course> getStudentCourses (List<Attending> attending, String studentEmail) throws IOException {
    	
		List<String> coursesId = new ArrayList<>();
		
		// Grab all the coursesId you are attending and store them into an arrayList
		for (int i = 0; i < attending.size(); i++) {
			
			if (attending.get(i).getStudentEmail().equalsIgnoreCase(studentEmail)) {
				coursesId.add(attending.get(i).getCourseID());
			}
		}
		
		CourseDAO courses = new CourseDAO();
		
		List<Course> coursesList = courses.getAllCourses();
		List<Course> studentCourses = new ArrayList<>();
		
		// Grab the full information of the courses based on the ID and store them
		for (Course course : coursesList) {
			
			if (coursesId.contains(course.getCourseID())) {
				studentCourses.add(course);
			}
		}
		
		return studentCourses;

    }

    public void saveAttending (List<Attending> attending){

    }

}
