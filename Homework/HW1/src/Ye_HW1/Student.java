package Ye_HW1;

import java.util.ArrayList;
import java.io.*;

public class Student extends User implements StudentInterface, Serializable{
	private ArrayList<Course> studentCourseList = new ArrayList<Course>();
	//constructor
	public Student()
	{
		super("","","","");
		//CourseList=new ArrayList<Course>();
		//fileop = new FileOperation();
	}
	public Student(String username, String password,
			String firstName, String lastName)
	{
		super(username, password, firstName, lastName);
		//CourseList=new ArrayList<Course>();
		//fileop = new FileOperation();
	}
	//getter
	public String getUsername()
	{
		return super.getUsername();
	}
	public String getPassword()
	{
		return super.getPassword();
	}
	public String getFirstname()
	{
		return super.getFirstName();
	}
	public String getLastname()
	{
		return super.getLastName();
	}
	
	public ArrayList<Course> getCourseList()
	{
		return FileOperation.getCourseList();
	}
	public ArrayList<Course> getStudentCourseList()
	{
		return studentCourseList;
	}
	//setter
	public void setUsername(String username)
	{
		super.setUsername(username);
	}
	public void setPassword(String password)
	{
		super.setPassword(password);
	}
	public void setFirstName(String firstname)
	{
		super.setFirstName(firstname);
	}
	public void setLastName(String lastname)
	{
		super.setLastName(lastname);
	}
	//view all courses
	
	/*
	 * View not full courses:
	 * Use an empty list of course to keep track
	 * use a for loop to track through the coursesList, 
	 * test if the course is not full, then add to the empty list
	 * print the list
	 */
	public ArrayList<Course> notFullCourses() throws IOException
	{
		ArrayList <Course> notFullCourses = new ArrayList <Course>(); 
		//used to keep track of not full courses
		ArrayList<Course> CoursesList = FileOperation.getCourseList();
		for(int i=0; i<CoursesList.size(); i++)
		{
			Course a = CoursesList.get(i);
			if(!a.isFull())
			{
				notFullCourses.add(a);
			}
		}
		//printing the information from the not full courses list
		for(int i=0; i<notFullCourses.size(); i++)
		{
			Course c = notFullCourses.get(i);
			printInfo(c);
		}
		return notFullCourses;
	}
	
	/*
	 * Register:
	 * use a for loop to search for the target course
	 */
	public void register(String course, int section, String fullname) throws IOException
	{
		ArrayList<Course> CoursesList =FileOperation.getCourseList();
		boolean t=true;
		for(int i=0; i<CoursesList.size();i++)
		{
			Course a = CoursesList.get(i);
			//finding the target course
			if(a.getCourse().equals(course)&&a.getCourseSection()==section)
			{
				if(!a.isFull())
				//test if it is full
				{
					a.addStudent(fullname);
					//add student to the list
					a.setCurrentNumber(a.getcurStudent()+1);
					//increment number of current student
					System.out.println(a.getcurStudent());
					studentCourseList.add(a);
					t=false;
				}
				//when target course is full:
				else
				{
					System.out.println("Sorry, class full!");
				}
			}
		}
		//when no course is found
		if(t)
		{
			System.out.println("Please enter the correct course name and ID!");
		}
		else
		{
			System.out.println("Registered successfully!");
		}
	}
	
	/*
	 * Withdraw
	 * Use for loop to find the target course
	 */
	public void withdraw(String course, String fullname) throws IOException
	{
		ArrayList<Course> CoursesList =FileOperation.getCourseList();
		boolean t=true;
		for(int i=0; i<CoursesList.size(); i++)
		{
			Course a=FileOperation.getCourseList().get(i);
			if(a.getCourse().equals(course))
			{
				//remove student from course
				a.deleteStudent(fullname);
				a.setCurrentNumber(a.getcurStudent()-1);
				//de increment the number of current student
				studentCourseList.remove(a);
				t=false;
			}
		}
		//when no course is found
		if(t)
		{
			System.out.println("Please enter the correct course name!");
		}
		else
		{
			System.out.println("Withdrawn successfully!");
		}
	}
	public void viewStudentCourse(ArrayList<Course> c)
	{
		for(int i=0; i<c.size();i++)
		{
			System.out.println(c.get(i).getCourse());
		}
	}
	
	
}
