package Ye_HW1;
import java.util.ArrayList;
import java.io.*;

public abstract class User implements Serializable{
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private ArrayList <Course> courseList;
	//private FileOperation fileop = new FileOperation();
	
	public User(String username, String password, 
			String firstName, String lastName)
	{
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	//getter
	public String getUsername()
	{
		return this.username;
	}
	public String getPassword()
	{
		return this.password;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	//setter
	public void setUsername(String username)
	{
		this.username = username;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	//methods for both student and Admin
	//view all courses
	//should we return or print the entire courselists
	public void viewAllCourses()throws IOException
	{
		int a = FileOperation.getCourseList().size();
		System.out.println(a);
		for(int i=0; i<a; i++)
		{
			Course c = FileOperation.getCourseList().get(i); 
			printInfo(c);
		}
	}
	//admin menu
	public void adminMenu()
	{
		System.out.println("Would you like to: \n"
				+ "1. Create a new course; \n"
				+ "2. Delete a course; \n"
				+ "3. Edit a course; \n"
				+ "4. Display information for a given course; \n"
				+ "5. Register a student; \n"
				+ "6. View all courses; \n"
				+ "7. View all courses that are full; \n"
				+ "8. Write to a file all full courses; \n"
				+ "9. View the students being registered in a course; \n"
				+ "10. View the list of courses that a given student is being registered on; \n"
				+ "11. Sort courses \n"
				+ "12. Exit \n"
				+ "Please input the number of your choice!");
	}
	public void studentMenu()
	{
		System.out.println("Would you like to: \n"
				+ "1. View all courses; \n"
				+ "2. View all courses that are not full; \n"
				+ "3. Register a course; \n"
				+ "4. Withdraw from a course; \n"
				+ "5. View all courses that the current student is being registered in; \n"
				+ "6. Exit. \n"
				+ "Please input the number of your choice!");
	}
	//this method is for printing course information
	public void printInfo(Course c)
	{
		System.out.print(c.getCourse()+"  ");
		System.out.print(c.getCourseId()+"  ");
		System.out.print(c.getMax()+"  ");
		System.out.print(c.getcurStudent()+"  ");
		System.out.print(c.getstudentStringList()+"  ");
		System.out.print(c.getInstructor()+"  ");
		System.out.print(c.getCourseSection()+"  ");
		System.out.print(c.getcourseLocation()+"  ");
		System.out.println();
	}
}
