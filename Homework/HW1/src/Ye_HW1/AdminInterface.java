package Ye_HW1;
import java.util.ArrayList;
public interface AdminInterface 
{
	public abstract void createCourse (String courseName, String courseID, String instructor, 
			String courseLocation, int courseSection, int maxStudent, int curStudent,
			ArrayList <String> registeredStudent);
	public abstract void deleteCourse(String courseName, String courseID);
	public abstract void editCourse(String courseName, String courseID);
	public abstract void displayCourse(String courseID);
	public abstract void registerStudent(String username, String password, 
			String firstname, String lastname);
	public abstract ArrayList<Course> fullCourses();
	public abstract void fileFullCourses();
	public abstract void viewStudentsRegistered(String courseID);
	public abstract void viewCoursesRegistered(String lastname, String firstname);
	public void sortCourses();
}
