package CoreJava.MainEntryPoint;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import CoreJava.DAO.AttendingDAO;
import CoreJava.DAO.CourseDAO;
import CoreJava.DAO.StudentDAO;
import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Student;

public class TestRunner {
	
    public static void main(String[] args) throws IOException {
    	
    	System.out.println("Are you a(n)" + "\n1. Student" + "\n2. Quit");
        System.out.print("Answer: ");
        
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in); 
        int answer = in.nextInt();
        
        if (answer == 1) {
        	
            StudentDAO studentDAO = new StudentDAO();
            
            List<Student> studentList = studentDAO.getStudents();
            
            System.out.print("Enter your email: ");
            String email = in.next();
            
            System.out.print("Enter your password: ");
            String password = in.next();

            if (studentDAO.validateUser(studentList, email, password)) {
            	
            	CourseDAO courseDAO = new CourseDAO();
            	
                AttendingDAO attendingDAO = new AttendingDAO();
                
                Student student = studentDAO.getStudentByEmail(studentList, email);
                
                List<Course> courseList = courseDAO.getAllCourses();
                List<Attending> attendingList = attendingDAO.getAttending();

                myClasses(student, courseList, attendingList);

                System.out.println("What would you like to do?");
                System.out.println("1. Register for a new Class");
                System.out.println("2. Log Out");
                System.out.print("Answer: ");
                answer = in.nextInt();

                if (answer == 1) {
                	
                    //Display a list of all Classes
                    allClasses(courseList);
                    
                    System.out.print("Select Course by ID Number: ");
                    String courseID = in.next(); // This ID cannot be an int since the course ID can be CIS101 (as stated in the instructions)
                    
                    System.out.println("Attempting to Register...");
                    attendingDAO.registerStudentToCourse(attendingList, student.getEmail(), courseID);
                }

                System.out.println("Logging Out...");
            }
            else {
                System.out.println("Invalid Email or Password.");
            }
        }

        System.out.println("Closing Program. Goodbye.");
    }

    public static void myClasses (Student student, List<Course> courseList, List<Attending> attendingList) throws IOException {
    	
        System.out.println("My Classes: ");
        
        System.out.printf("%-5s|%-25s|%-25s", "#", "COURSE NAME", "INSTRUCTOR NAME");
        
        AttendingDAO attendingDAO = new AttendingDAO();
        
        // Why three parameters when the program specifications asked for 2.
        List<Course> courses = attendingDAO.getStudentCourses(attendingList, student.getEmail());
        
        for (Course course : courses) {
            System.out.printf("%-5s|%-25s|%-25s", course.getCourseID(), course.getCourseName(), course.getInstructor());
        }
    }

    public static void allClasses (List<Course> courseList) {
    	
        System.out.println("My Classes: ");
        
        System.out.printf("%-5s|%-25s|%-25s", "#", "COURSE NAME", "INSTRUCTOR NAME");
        
        for (Course course : courseList) {
            System.out.printf("%-5s|%-25s|%-25s", course.getCourseID(), course.getCourseName(), course.getInstructor());
        }
    }
    	
}

