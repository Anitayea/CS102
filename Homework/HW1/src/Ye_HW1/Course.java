package Ye_HW1;
import java.util.ArrayList;
import java.io.Serializable;

public class Course implements Serializable, Comparable<Course> {
	//private 
	private String courseName;
	private String courseID;
	private String instructor;
	private String courseLocation;
	private int courseSection;
	private int maxStudent;
	private int curStudent = 0;
	//TODO: ArrayList student
	private ArrayList <String> studentStringList = new ArrayList <String>();
	public Course()
	{
		courseName="";
		courseID="";
		instructor="";
		courseLocation="";
		courseSection=0;
		maxStudent=0;
		curStudent = 0;
		studentStringList=new ArrayList<String>();
	}
	//TODO: constructor
	public Course (String course, String id, int max, int cur, 
			ArrayList<String> registeredStudents, String prof, int section,
			String location)
	{
		courseName = course;
		courseID = id;
		instructor = prof;
		courseLocation = location;
		courseSection = section;
		maxStudent = max;
		curStudent = cur;
		studentStringList=registeredStudents;
	}
	
	//getter methods
	public String getCourse()
	{
		return courseName;
	}
	public String getCourseId()
	{
		return courseID;
	}
	public String getInstructor()
	{
		return instructor;
	}
	public String getcourseLocation()
	{
		return courseLocation;
	}
	public int getCourseSection()
	{
		return courseSection;
	}
	public int getMax()
	{
		return maxStudent;
	}
	public int getcurStudent() 
	{
		return curStudent;
	}
	public ArrayList <String> getstudentStringList()
	{
		return studentStringList;
	}
	
	public int compareTo(Course course)
	{
		if (this.getcurStudent()>course.getcurStudent())
			return 1;
		else if(this.getcurStudent()==course.getcurStudent())
			return 0;
		else
			return -1;
	}
	//test if the class is full
	public boolean isFull() 
	{
		return curStudent == maxStudent;
	}
	
	//setter methods
	public void setCourse(String course)
	{
		courseName = course;
	}
	public void setCourseID(String id)
	{
		courseID = id;
	}
	public void setInstructor(String prof)
	{
		instructor = prof;
	}
	public void setCourseLocation(String location)
	{
		courseLocation = location;
	}
	public void setCourseSection(int section)
	{
		courseSection = section;
	}
	public void setMax(int max)
	{
		maxStudent = max;
	}
	public void setCurrentNumber(int cur)
	{
		curStudent = cur;
	}
	public void setCourseList(ArrayList<String> studentlist)
	{
		studentStringList = studentlist;
	}
	
	//add/delete students
	public void addStudent(String name)
	{
		studentStringList.add(name);
		curStudent++;
	}
	public void deleteStudent(String name)
	{
		studentStringList.remove(name);
		curStudent--;
	}
	
}
