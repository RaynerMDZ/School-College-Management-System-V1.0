package CoreJava.DAO;

import CoreJava.Models.Course;
import CoreJava.Util.FileHandler;

import java.io.IOException;
import java.util.List;

public class CourseDAO {
	
	/**
	 * Grabs all the courses from the Courses file
	 * @return an array of Course objects
	 * @throws IOException
	 */
    public List<Course> getAllCourses() throws IOException {
    	
    	return FileHandler.courseToList("Courses.csv", "course");

    }
}
