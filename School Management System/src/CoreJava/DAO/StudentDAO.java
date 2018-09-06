package CoreJava.DAO;

import CoreJava.Models.Student;
import CoreJava.Util.FileHandler;

import java.io.IOException;
import java.util.List;

public class StudentDAO {
	
	/**
	 * Reads the Students.csv file and returns the data as a List
	 * @return a list of students
	 * @throws IOException
	 */
    public List<Student> getStudents() throws IOException {
    	
    	return FileHandler.studentsToList("Students.csv", "student");

    }

    /**
     * Reads the Students.csv file and returns the specified student
     * @param studentEmail: Email of the student you are looking for
     * @return a Student object
     * @throws IOException
     */
    public Student getStudentByEmail (List<Student> students, String studentEmail) throws IOException {
		
		Student found = null;
		
		// Linear search for the student until they both match the email.
		for (Student student : students) {
			
			// When the Student is found, break the loop and store its object.
			if (student.getEmail().equalsIgnoreCase(studentEmail)) {
				found = student;
				break;
			}
		}
		
		return found;
    }

    /**
     * Verifies if the credentials are correct
     * @param studentEmail: Email of the student
     * @param studentPassword: Password of the student
     * @return a boolean statement
     * @throws IOException
     */
    public boolean validateUser (List<Student> students, String studentEmail, String studentPassword) throws IOException {
		
    	// Iterate over the students list and check if the email and password are correct
		for (Student student : students) {
			if (student.getEmail().equalsIgnoreCase(studentEmail) && 
				student.getPassword().equals(studentPassword)) {
				return true;
			}
		}
		
		return false;

    }
    
    public Student removeStudent (List<Student> student) throws IOException {
    	
		return null;
    	
    	
    	
    }
}
