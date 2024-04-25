package Ye_HW1;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class MainMethod2 implements Serializable {
	
	public static void main(String[] args) throws IOException{
		//TODO again
		File mycourse = new File("course.ser");
		File mystudent = new File("student.ser");
		FileOperation f = new FileOperation();
		/*
		 * Test if the courses are already loaded, 
		 *if not we read the file and load it into course.ser
		 */
		if (mycourse.exists())
		{
			f.deserializeCourse();
		}
		else
		{
			f.readFile();
		}
		
		if(mystudent.exists())
		{
			f.deserializeStudent();
		}
		
		//initialize the two lists and the admin
		ArrayList<Course> coursesList = FileOperation.getCourseList();
		ArrayList<Student> studentsList = FileOperation.getStudentList();
		Admin admin = new Admin("Admin", "Admin001", "A", "Y");
		
		/*
		 * Login the system, 
		 * take user input to see if the user is an admin or a student
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("University Course Registration System");
		System.out.println("Are you an admin or a student?");
		String ans = input.nextLine();
		
		/*
		 * use while loops to make user reenter if they did not input student or admin
		 */
		while(!(ans.equals("admin")||ans.equals("student")))
		{
			ans=input.nextLine();
			System.out.println("Please input admin or student!"); 
		}
		//Testing admin's username and password
		if(ans.equals("admin"))
		{
			System.out.println("Username:");
			String username = input.next();
			System.out.println("Password:");
			String password = input.next();
			//enter admin's menu if username and password are correct
			if(username.equals(admin.getUsername())&&password.equals(admin.getPassword()))
			{
				System.out.println("Welcome admin!");
				boolean exit=true;
				//use boolean to exit
				while (exit)
				{
					//This method call prints out the options for admin
					admin.adminMenu();
					int choice = input.nextInt();
					//use integer to keep track of the choices
					/*1. create new course
					 * Use print statements to guide the admin to input all variables to create a course
					 * createCourse will take all the variables and create the course
					 */
					if(choice==1)
					{
						input.nextLine();
						System.out.println("Please provide the information of the new course: ");
						System.out.println("Please input the name of the course: ");
						String courseName = input.nextLine();
						System.out.println("Please input the course id: ");
						String courseId = input.nextLine();
						System.out.println("Please input the instructor of the course: ");
						String instructor = input.nextLine();
						System.out.println("Please input the location: ");
						String location = input.nextLine();
						System.out.println("Please input the section number: ");
						int section = input.nextInt();
						System.out.println("Please input the maximum student: ");
						int max = input.nextInt();
						System.out.println("Please input the number of current students: ");
						int cur = input.nextInt();
						System.out.println("Please input the list of students: ");
						ArrayList<String> studentStringList = new ArrayList<String>();
						input.nextLine();
						for(int i=0;i<cur; i++)
						{
							studentStringList.add(input.next());
						}
						System.out.print("currentstudent is ");
						System.out.println(cur);
						admin.createCourse(courseName, courseId, instructor, location, section, max, cur, studentStringList);
					}
					/*
					 * 2. Delete a course
					 * Use print statements to guide the admin to input
					 * id and course name to delete the course
					 * The method deleteCourse will delete the course
					 */
					else if(choice==2)
					{
						input.nextLine();
						System.out.println("Delete the course: ");
						System.out.println("Please input the course name:");
						String coursename = input.nextLine();
						System.out.println("Please input the course id");
						String courseid = input.next();
						admin.deleteCourse(coursename, courseid);
						System.out.println("Deletion complete!");
					}
					/*
					 * 3. Edit a course
					 * Use print statements to guide the admin to input course id or name
					 * Then in the editCourse method they can choose whatever information 
					 * they would like to edit
					 */
					else if(choice==3)
					{
						System.out.println("Editing the course:");
						System.out.println("Please input the course name:");
						String coursename = input.next();
						System.out.println("Please input the course id: ");
						String courseid = input.next();
						admin.editCourse(coursename, courseid);
					}
					/*
					 * 4. Display information of a course
					 * Use print statements to guide the admin to input course id
					 * the method displayCourse will display the information for this course
					 */
					else if(choice==4)
					{
						System.out.println("Display information of the course:");
						System.out.println("Please input the course id:");
						String courseid = input.next();
						admin.displayCourse(courseid);
					}
					/*
					 * 5. Register student
					 * Use print statements to guide the admin to input username, password, firstname and lastname of a student
					 * The student is then added to studentsList 
					 */
					else if(choice==5)
					{
						System.out.println("Register a student:");
						System.out.println("Please input the student's username: ");
						String userName = input.next();
						System.out.println("Please input the student's password: ");
						String Password = input.next();
						System.out.println("Please input the student's fristname: ");
						String firstname = input.next();
						System.out.println("Please input the student's lastname: ");
						String lastname = input.next();
						admin.registerStudent(userName, Password, firstname, lastname);
						Student s = new Student(userName, Password, firstname, lastname);
						studentsList.add(s);
						//prints the current studentsList to check
						System.out.println("This is the studentsList now: ");
						for(int i=0;i< studentsList.size();i++)
						{
							System.out.println(studentsList.get(i).getFirstname());
						}
						
						
					}
					/*
					 * 6. View all courses
					 * This viewAllCourses is called from the parent class User to print all courses in the list
					 */
					else if(choice==6)
					{
						System.out.println("View all courses");
						admin.viewAllCourses();
					}
					/*
					 * 7. View all courses that are full
					 * fullCourses prints all full courses 
					 */
					else if(choice==7)
					{
						System.out.println("View all courses that are full");
						admin.fullCourses();
					}
					/*
					 * 8. Write to file all full courses
					 * fileFullCourses will put full courses into file "fullCourseFile.txt"
					 */
					else if(choice==8)
					{
						System.out.println("Write to file all full courses");
						admin.fileFullCourses();
					}
					/*
					 * 9. Viewing the students being registered in a course
					 * viewStudentsRegistered will print the students registered in this course
					 */
					else if(choice==9)
					{
						System.out.println("Viewing the students being registered in a course");
						System.out.println("Please input the courseID:");
						String courseid = input.next();
						admin.viewStudentsRegistered(courseid);
					}
					/*
					 * 10. Viewing the list of courses that a given student is being registered on.
					 * viewCoursesRegistered will print the course a student is registered
					 */
					else if(choice==10)
					{
						System.out.println("Viewing the list of courses that a given student is being registered on.");
						System.out.println("Please input the lastname of the student: ");
						String lastname = input.next();
						System.out.println("Please input the firstname of the student: ");
						String firstname = input.next();
						admin.viewCoursesRegistered(lastname, firstname);
					}
					/*
					 * 11. Sort
					 * sorting courses in descending order of current students
					 */
					else if(choice ==11)
					{
						admin.sortCourses();
					}
					/*
					 * 12.exit
					 * boolean exit become false so we exit the while loop
					 */
					else if(choice==12)
					{
						System.out.println("Exit");
						exit=false;
					}
					/*
					 * this else prints when admin enters other than number 1 to 11
					 */
					else
					{
						System.out.println("Please input numbers from 1-11!");
					}
				}
			}
			//This else goes with the username and password check if
			else
			{
				System.out.println("Please double check your username or password!");
			}
		}
		
		
		
		
		
		//Student
		else if(ans.equals("student"))
		{
			boolean validusername = false;
			Student s = null;
			//use boolean and while loop to exit
			while(!validusername)
			{
				//testing student's username
				System.out.println("Username:");
				String username = input.next();
				for(int i=0; i<studentsList.size();i++)
				{
					
					String student = studentsList.get(i).getUsername();
					if(username.equals(student))
					{
						s=studentsList.get(i);
						validusername=true;
						break;
					}
				}
				if(validusername==false)
				{
					System.out.println("Please double check your username!");
				}
			}
			//testing the student's password
			boolean validpassword = false;
			while(!validpassword)
			{
				System.out.println("Password:");
				String password = input.next();
				if(s.getPassword().equals(password))
				{
					validpassword=true;
					System.out.println("Welcome, "+ s.getFirstname()+ "!");
				}
				if(validpassword==false)
				{
					System.out.println("Please double check your password!");
				}
			}
			//showing the student's menu
			boolean exit = true;
			while(exit)
			{
				admin.studentMenu();
				int choice = input.nextInt();
				/*
				 * 1. showing all the courses
				 * viewAllCourses is a method from the user super class
				 */
				if (choice==1)
				{
					System.out.println("Here are all the courses:");
					admin.viewAllCourses();
				}
				/*
				 * 2. showing all courses that are not full
				 * printing the notFullCourses method from Student class
				 */
				else if(choice==2)
				{
					System.out.println("Here are all the courses that are not full:");
					//print not full courses
					System.out.println(s.notFullCourses());
				}
				/*
				 * 3. register for course
				 * keep track of the course and section number and register the student
				 */
				else if(choice==3)
				{
					input.nextLine();
					System.out.println("Registering for course:");
					System.out.println("Please enter the course name:");
					String coursename = input.nextLine();
					System.out.println("Please enter the section number:");
					int sec = input.nextInt();
					System.out.println("Please enter your full name:");
					String fullname = input.next();
					s.register(coursename, sec, fullname);
				}
				/*
				 * 4. Withdrawing from the course
				 * Student can withdraw from course by putting course name and their full name
				 */
				else if(choice==4)
				{
					input.nextLine();
					System.out.println("Withdrawing from course: ");
					System.out.println("Please enter the course name:");
					String coursename = input.nextLine();
					System.out.println("Please enter your full name:");
					String fullname = input.nextLine();
					s.withdraw(coursename, fullname);
				}
				/*
				 * 5. View all courses that the current student is being registered in
				 */
				else if(choice==5)
				{
					System.out.println("View all courses that the current student is being registered in");
					s.viewStudentCourse(s.getStudentCourseList());
				}
				/*
				 * 6. exit
				 * use boolean to exit while
				 */
				else if(choice==6)
				{
					System.out.println("Exit");
					exit=false;
				}
				else
				{
					System.out.println("Please input numbers from 1-6!");
				}
			}
		}
		
		//Serialization of course and student
		FileOperation.serialize();
		FileOperation.serialize(studentsList);
			
		}
}
