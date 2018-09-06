package CoreJava.Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import CoreJava.Models.Attending;
import CoreJava.Models.Course;
import CoreJava.Models.Student;

public class FileHandler {
	
	@SuppressWarnings("unused")
	public static List<Student> studentsToList(String file, String type) throws IOException { 
		
	    int count = 0;
	    
	    List<Student> content = new ArrayList<Student>();
	    
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = "";
	        
	        br.readLine();
	        
	        while ((line = br.readLine()) != null) {
	        	
	        	// Split the line to generate a list from it
	        	List<String> asArr = Arrays.asList(line.split(","));
	        	
	        	// Add the students to the List of students
	            content.add(new Student(asArr.get(0), asArr.get(2), asArr.get(1)));
	           
	        }
	        
	    } catch (FileNotFoundException e) {
	    	
	      file = createFile(file);
	      
	      PrintWriter writer = new PrintWriter(file);
	      
	      /**
	       * Write header to the CSV file based on the type of file
	       */
	      if (type.equalsIgnoreCase("student")) {
	    	  writeHeader(writer, new String[] {"Name", ",", "Email", ",", "Password"});

	      }
	      
	      else if (type.equalsIgnoreCase("course")) {
	    	  writeHeader(writer, new String[] {"CourseID", ",", "Name", ",", "Instructor"});
	      }
	      
	      else if (type.equalsIgnoreCase("attending")) {
	    	  writeHeader(writer, new String[] {"CourseID", ",", "Email"});
	      }
	      
	      writer.close();
	      
	      BufferedReader br = new BufferedReader(new FileReader(file));
	      
		  String line = "";
		        
		  while ((line = br.readLine()) != null) {
			// Split the line to generate a list from it
	        List<String> asArr = Arrays.asList(line.split(","));
	        	
	        // Add the students to the List of students
	        content.add(new Student(asArr.get(0), asArr.get(2), asArr.get(1)));  
		  }
		    
		  br.close();
	      
	    }
	    
	    return content;
	}
	
	@SuppressWarnings("unused")
	public static List<Course> courseToList(String file, String type) throws IOException { 
		
	    int count = 0;
	    
	    List<Course> content = new ArrayList<Course>();
	    
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = "";
	        
	        br.readLine();
	        
	        while ((line = br.readLine()) != null) {
	        	
	        	// Split the line to generate a list from it
	        	List<String> asArr = Arrays.asList(line.split(","));
	        	
	        	// Add the students to the List of students
	            content.add(new Course(asArr.get(0), asArr.get(1), asArr.get(2)));
	           
	        }
	        
	    } catch (FileNotFoundException e) {
	    	
	      file = createFile(file);
	      
	      PrintWriter writer = new PrintWriter(file);
	      
	      /**
	       * Write header to the CSV file based on the type of file
	       */
	      if (type.equalsIgnoreCase("student")) {
	    	  writeHeader(writer, new String[] {"Name", ",", "Email", ",", "Password"});

	      }
	      
	      else if (type.equalsIgnoreCase("course")) {
	    	  writeHeader(writer, new String[] {"CourseID", ",", "Name", ",", "Instructor"});
	      }
	      
	      else if (type.equalsIgnoreCase("attending")) {
	    	  writeHeader(writer, new String[] {"CourseID", ",", "Email"});
	      }
	      
	      writer.close();
	      
	      BufferedReader br = new BufferedReader(new FileReader(file));
	      
		  String line = "";
		        
		  while ((line = br.readLine()) != null) {
			// Split the line to generate a list from it
	        List<String> asArr = Arrays.asList(line.split(","));
	        	
	        // Add the students to the List of students
	        content.add(new Course(asArr.get(0), asArr.get(1), asArr.get(2)));
		  }
		    
		  br.close();
	      
	    }
	    
	    return content;
	}
	
	@SuppressWarnings("unused")
	public static List<Attending> attendingToList(String file, String type) throws IOException { 
		
	    int count = 0;
	    
	    List<Attending> content = new ArrayList<Attending>();
	    
	    try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	    	
	        String line = "";
	        
	        br.readLine();
	        
	        while ((line = br.readLine()) != null) {
	        	
	        	// Split the line to generate a list from it
	        	List<String> asArr = Arrays.asList(line.split(","));
	        	
	        	// Add the students to the List of students
	            content.add(new Attending(asArr.get(0), asArr.get(1)));
	           
	        }
	        
	    } catch (FileNotFoundException e) {
	    	
	      file = createFile(file);
	      
	      PrintWriter writer = new PrintWriter(file);
	      
	      /**
	       * Write header to the CSV file based on the type of file
	       */
	      if (type.equalsIgnoreCase("student")) {
	    	  writeHeader(writer, new String[] {"Name", ",", "Email", ",", "Password"});

	      }
	      
	      else if (type.equalsIgnoreCase("course")) {
	    	  writeHeader(writer, new String[] {"CourseID", ",", "Name", ",", "Instructor"});
	      }
	      
	      else if (type.equalsIgnoreCase("attending")) {
	    	  writeHeader(writer, new String[] {"CourseID", ",", "Email"});
	      }
	      
	      writer.close();
	      
	      BufferedReader br = new BufferedReader(new FileReader(file));
	      
		  String line = "";
		        
		  while ((line = br.readLine()) != null) {
			// Split the line to generate a list from it
	        	List<String> asArr = Arrays.asList(line.split(","));
	        	
	        	// Add the students to the List of students
	            content.add(new Attending(asArr.get(0), asArr.get(1)));
		  }
		    
		  br.close();
	      
	    }
	    
	    return content;
	}
	
	/**
	 * Method to create a new file given a filename
	 * @param fileName: Name of the file
	 * @return a string with the filename
	 * @throws IOException
	 */
	private static String createFile(String fileName) throws IOException {
		
		File file = new File(fileName);
		file.createNewFile(); // if file already exists will do nothing 
		FileOutputStream oFile = new FileOutputStream(file, false);
		return fileName;
	}
	
	/**
	 * Method to write headers to a CSV file
	 * @param writer: PrintWriter object with the CSV file
	 * @param fields: Fields to write in the header.
	 */
	private static void writeHeader(PrintWriter writer, String[] fields) {
		
		for (String string : fields) {
			writer.print(string);
    	}
		writer.println();
	}

}
