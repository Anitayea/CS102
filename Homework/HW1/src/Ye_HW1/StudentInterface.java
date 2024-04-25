package Ye_HW1;
import java.io.IOException;
import java.util.ArrayList;
public interface StudentInterface {
	public ArrayList <Course> getCourseList();
	public void register(String course, int section, String fullname) throws IOException;
	public void withdraw(String course, String fullname) throws IOException;
	public ArrayList<Course> notFullCourses() throws IOException;
	public void viewStudentCourse (ArrayList<Course> c);
}
