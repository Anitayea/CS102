package Ye_HW1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;

public class FileOperation implements Serializable{
	/*
	 * This class is used to serialize, deserialize and read files
	 */
	private static ArrayList<Course> courseList ;
	private static ArrayList<Student> studentList ;
	//private FileOperation f=new FileOperation();
	public static ArrayList<Course> getCourseList()
	{
		return courseList;
	}
	public static ArrayList<Student> getStudentList()
	{
		return studentList;
	}
	//this serves as setter of student in this class, similar to a add student for admin
	public void createStudent()
	{
		System.out.println("Creating students:");
	}
	//this serves as setter of course in this class
	public static void createCourse(String courseName, String courseID, String instructor, 
			String courseLocation, int courseSection, int maxStudent, int curStudent,
			ArrayList <String> registeredStudent)
	{
		//curStudent=0;
		Course a = new Course(courseName, courseID, maxStudent, curStudent, 
				registeredStudent,instructor, courseSection, courseLocation);
		courseList.add(a);
		System.out.println("Created course: " + a.getCourse());
	}
	
	//serves as a setter of student in this class
	public void registerStudent(String username, String password, 
			String firstname, String lastname)
	{
		Student s = new Student(username, password, firstname, lastname);
		studentList.add(s);
	}
	//sorting the courseList, see method in course
	public static void sort()
	{
		Collections.sort(courseList);
		System.out.println("Sorted");
	}
	
	//constructor
	public FileOperation()
	{
		courseList = new ArrayList<Course>();
		studentList = new ArrayList<Student>();
	}
	
	//Course
	 public static ArrayList<Course> courseOperation() throws IOException
	{
		//readFile();
		serialize();
		deserializeCourse();
		return courseList;
	}
	
	//Read file and store the csv into a string array
	public static void readFile()
	{
		try
		{
			courseList = new ArrayList <Course>();
			FileReader filereader = new FileReader("src/MyUniversityCourses (4) (2).csv");
			BufferedReader r = new BufferedReader(filereader);
			String line =r.readLine(); 
			line=r.readLine();
			while(line!=null)
			{
				String[] coursearray = line.split(",");
				Course course = new Course(coursearray[0], coursearray[1],
						Integer.valueOf(coursearray[2]),Integer.valueOf(coursearray[3]), 
						new ArrayList<String>(), coursearray[5],
						Integer.parseInt(coursearray[6]),coursearray[7]);
				courseList.add(course);
				line = r.readLine(); 
			}
			r.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("FIle not found when reading course");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			System.out.println("IOException when reading courses");
			e.printStackTrace();
		}
	}
	
	//serialization of course
	public static void serialize()
	{
		try
		{
			FileOutputStream courseFile = new FileOutputStream("course.ser");
			ObjectOutputStream courseObject = new ObjectOutputStream (courseFile);
			courseObject.writeObject(courseList);
			courseObject.close();
			courseFile.close();
			System.out.println("Serialization of course complete!");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Serialize course IOException!");
		}
	}
	//deserialize course
	public static void deserializeCourse()
	{
		ArrayList<Course> coursesList = new ArrayList<Course>();
		try
		{
			//System.out.println("What!!This is courselist now" + courseList);
			FileInputStream courseFile = new FileInputStream("course.ser");
			ObjectInputStream courseObject = new ObjectInputStream (courseFile);
			coursesList = (ArrayList <Course>) courseObject.readObject();
			courseList=coursesList;
			courseObject.close();
			courseFile.close();
			System.out.println("Deserialization of course complete!");
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Deserialize course IOException");
		}
		catch(ClassNotFoundException nfe) 
		{
			nfe.printStackTrace();
			System.out.println("Deserialize course ClassNotFoundException!");
		}
		//return courseList;

	}
	
	
	//students
	//deserialization for students
	public static void deserializeStudent()
	{
		ArrayList<Student> studentsList = new ArrayList<Student>();
		try
		{	
			FileInputStream studentFile = new FileInputStream("student.ser");
			ObjectInputStream studentObject = new ObjectInputStream (studentFile);
			studentsList = (ArrayList<Student>) studentObject.readObject();
			studentList=studentsList;
			studentObject.close();
			studentFile.close();
			System.out.println("Deserialization of student complete!");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Deserialize student IOException");
		}
		catch(ClassNotFoundException nfe) 
		{
			nfe.printStackTrace();
			System.out.println("Deserialize student ClassNotFoundException!");
		}
		
	}
	//serialization of student
	public static void serialize(ArrayList<Student> a)
	{
		try
		{
			FileOutputStream studentFile = new FileOutputStream("student.ser");
			//should this be the same list or where do I store this
			ObjectOutputStream studentObject = new ObjectOutputStream (studentFile);
			studentObject.writeObject(a);
			studentObject.close();
			studentFile.close();
			System.out.println("Serialization of student complete!");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Serialize student IOException!");
		}
	}


}
