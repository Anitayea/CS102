
package Ye_HW1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;
import java.util.Scanner;

public class Admin extends User implements AdminInterface, Serializable{
	
	private String username = "Admin";
	private String password = "Admin001";
	private ArrayList <Course> courseList= FileOperation.getCourseList();
	private ArrayList <Student> studentList= FileOperation.getStudentList();
	public Admin(String username, String password, String firstname, String lastname) throws IOException
	{
		super(username, password, firstname, lastname);
	}
	//getter methods
	public String getUsername()
	{
		return super.getUsername();
	}
	public String getPassword()
	{
		return super.getPassword();
	}
	public String getFirstName()
	{
		return super.getFirstName();
	}
	public String getLastName()
	{
		return super.getLastName();
	}
	public ArrayList <Student> getStudentList()
	{
		return studentList;
	}
	public ArrayList <Course> getCourseList()
	{
		return courseList;
	}
	//setter methods
	//not allowed to change username and password!!
	/*public void setUsername(String username)
	{
		super.setUsername(username);
	}
	public void setPassword(String password)
	{
		super.setPassword(password);
	}*/
	public void setFirstname(String firstname)
	{
		super.setFirstName(firstname);
	}
	public void setLastname(String lasname)
	{
		super.setLastName(lasname);
	}
	
	//course management
	public void createCourse(String courseName, String courseID, String instructor, 
			String courseLocation, int courseSection, int maxStudent, int curStudent,
			ArrayList <String> registeredStudent)
	{
		FileOperation.createCourse(courseName, courseID, instructor, courseLocation, courseSection, maxStudent, curStudent, registeredStudent);;
	}
	
	//delete courses
	public void deleteCourse(String courseName, String courseID)
	{	
		//was printed to test the list
		//System.out.println(FileOperation.getCourseList().size());
		for(int i=0; i<FileOperation.getCourseList().size(); i++)
		{
			Course a = FileOperation.getCourseList().get(i);
			if(courseName.equals(a.getCourse())||courseID.equals(a.getCourseId()))
			{
				FileOperation.getCourseList().remove(a);
				break;
			}
		}
	}
	
	//edit courses: all data except ID and name
	public void editCourse(String courseName, String courseID)
	{
		Course c = new Course();
		//testing if this course is in the list
		for(int i=0; i<FileOperation.getCourseList().size();i++)
		{
			if(courseName.equals(FileOperation.getCourseList().get(i).getCourse())||
					courseID.equals(FileOperation.getCourseList().get(i).getCourseId()))
			{
				c=FileOperation.getCourseList().get(i);
				break;
			}
		}
		//printing small menu for editing course of all the choices in integers
		System.out.println("You are currently editing information for course: "+c.getCourse());
		System.out.println("What do you want to edit? \n"
				+ "1.Instructor of the course; \n"
				+ "2. Location; \n"
				+ "3. Section number; \n"
				+ "4. Maximum number of students; \n"
				+ "5. Current number of students; \n"
				+ "6. Student list. \n");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt();
		//if the admin entered stuff other than 1-6, use a while loop to ask them to reenter
		while(choice!=1||choice!=2||choice!=3||choice!=4||choice!=5||choice!=6)
		{
			System.out.println("Please input your choice as number 1 to 6");
			choice = input.nextInt();
		}
		//according to the choice, use setter methods to change information
		if(choice==1)
		{
			System.out.println("The current instructor is: " + c.getInstructor());
			System.out.println("Please input the new instructor");
			String newInstructor = input.next();
			c.setInstructor(newInstructor);
		}
		else if(choice==2)
		{
			System.out.println("The current location is: "+c.getcourseLocation());
			System.out.println("Please input the new location");
			String newLocation = input.next();
			c.setCourseLocation(newLocation);
		}
		else if (choice==3)
		{
			System.out.println("The current section is: "+c.getCourseSection());
			System.out.println("Please input the new section number");
			int newSection = input.nextInt();
			c.setCourseSection(newSection);
		}
		else if (choice==4)
		{
			System.out.println("The current maximum number is: "+c.getMax());
			System.out.println("Please input the new maximum number");
			int newMax = input.nextInt();
			while(newMax<c.getcurStudent())
			{
				System.out.println("Maximum exceeds current number! "
						+ "Please input a valid maximum number.");
				newMax=input.nextInt();
			}
			c.setMax(newMax);
		}
		else if (choice==5)
		{
			System.out.println("The current number of student is: "+c.getcurStudent());
			System.out.println("Please input the new current number of student");
			int newCurrent = input.nextInt();
			c.setCourseSection(newCurrent);
		}
		else if(choice==6)
		{
			System.out.println("The current student list is: \n" + c.getstudentStringList());
			System.out.println("Which student would you like to edit?");
			String student = input.next();
			System.out.println("Would you like to: \n"
					+ "1. Add a student to the list; \n"
					+ "2. Delete a student from the list.");
			int a = input.nextInt();
			while(a!=1||a!=2)
			{
				System.out.println("Please input your choice as 1 or 2!");
				a=input.nextInt();
			}
			if(a==1)
			{
				c.getstudentStringList().add(student);
			}
			else if(a==2)
			{
				c.getstudentStringList().remove(student);
			}
		}
		else
		{
			System.out.println("Please input your choices as number 1 to 6!");
		}
		
		
	}
	
	//display information by course ID of a given course
	//notice it is overloading the 
	public void displayCourse(String courseID)
	{
		//finding target course
		for(int i=0; i<FileOperation.getCourseList().size(); i++)
		{
			Course c = FileOperation.getCourseList().get(i);
			if (courseID.equals(c.getCourseId()))
			{
				printInfo(c);
			}
		}
	}
	
	//register a student to the list
	public void registerStudent(String username, String password, 
			String firstname, String lastname)
	{
		Student s = new Student(username, password, firstname, lastname);
		FileOperation.getStudentList().add(s);
		System.out.println(s.getFirstname()+" "+ s.getLastname()+" is added to the list!");
	}
	
	
	//reports
	//view all courses that are full
	public ArrayList<Course> fullCourses()
	{
		//using an empty course list to store full courses
		ArrayList <Course> FullCourse = new ArrayList <Course>(); 
		for(int i=0; i<FileOperation.getCourseList().size(); i++)
		{
			Course a = FileOperation.getCourseList().get(i);
			if(a.isFull())
			{
				FullCourse.add(a);
			}
		}
		//printing full courses
		for(int i=0; i<FullCourse.size(); i++)
		{
			{
				Course c = FullCourse.get(i); 
				printInfo(c);
			}
		}
		//print if none is full
		if(FullCourse.size()==0)
		{
			System.out.println("None of the courses are full");
		}
		return FullCourse;
	}
	
	//write to a file the list of courses that are full
	public void fileFullCourses()
	{
		//write file to a txt file 
		String fullcourseFile = "fullCourseFile.txt";
		try
		{
			FileWriter filewriter = new FileWriter(fullcourseFile);
			BufferedWriter bufferedWriter = new BufferedWriter(filewriter);
			ArrayList <Course> c = fullCourses();
			for(int i=0; i<c.size(); i++)
			{
				bufferedWriter.write(c.get(i).toString());
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			filewriter.close();
		}
		catch(IOException exk)
		{
			System.out.println("Error writing course file "+ fullcourseFile + " !");
			exk.printStackTrace();
		}
	}
	
	//view the names of students being registered in a course
	public void viewStudentsRegistered(String courseID)
	{
		boolean courseDNE=true;
		ArrayList<Course> c = FileOperation.getCourseList();
		for(int i=0; i<c.size(); i++)
		{
			//finding the target course
			if(c.get(i).getCourseId().equals(courseID))
			{
				courseDNE=false;
				//printing the target students
				for(int j=0; j<c.get(j).getstudentStringList().size();j++)
				{
					String s = c.get(i).getstudentStringList().get(j);
					System.out.println(s);
				}
				break;
			}
			break;
			
		}
		if(courseDNE)
		{
			System.out.println("Please input a correct course ID!");
		}
	}
	
	//view the list of courses that a given student is being registered on
	public void viewCoursesRegistered(String lastname, String firstname)
	{
		ArrayList<Student> s = FileOperation.getStudentList();
		boolean nameDNE=true;
		for(int i=0; i<s.size(); i++)
		{
			if(lastname.equals(s.get(i).getLastName())&&
					firstname.equals(s.get(i).getFirstName()))
			{
				//Student student = s.get(i);
				nameDNE=false;
				for(int j=0; j<s.get(i).getStudentCourseList().size();j++)
				{
					System.out.println(s.get(i).getStudentCourseList().get(j).getCourse());
				}
				//System.out.println(FileOperation.getStudentList().get(i).getCourseList());
				//break;
			}
			break;
		}
		if(nameDNE)
		{
			System.out.println("Please input a correct name!");
		}

	}
	//sort courses
	public void sortCourses()
	{
		FileOperation.sort();
	}
}


