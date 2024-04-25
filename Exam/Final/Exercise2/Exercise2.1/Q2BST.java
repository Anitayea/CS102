package Exercise21;
import java.util.*;

public class Q2BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentTree t = new StudentTree();
		Scanner input = new Scanner(System.in);
		boolean tf = true;
		//int n = 3;
		while(tf == true) 
		{
			System.out.println(
		    		  "Please enter integer number of your choice:"
		      		+ "\n 1. create tree"
		      		+ "\n 2. insert a new student"
		      		+ "\n 3. delete a student"
		      		+ "\n 4. search and display student grade and name"
		      		+ "\n 5. display id sorted"
		      		+ "\n 6. display grades sorted"
		      		+ "\n 7. display students above a grade"
		      		+ "\n 8. exit");
			String name;
			int id;
			int grade;
			int c = input.nextInt();
			switch(c)
			{
				case 1:
					//System.out.println("How many students to you want to input?");
					//int n = input.nextInt();
					int n = 10;
					t.create(n);
					break;
				case 2:
					//insert
					Student s = new Student();
					System.out.println("Insert a new student");
					System.out.println("Please input the id:");
					id = input.nextInt();
					s.id = id;
					
					System.out.println("Please input the name:");
					name = input.next();
					s.name = name;
					
					//System.out.println();
					System.out.println("Please input the grade:");
					grade = input.nextInt();
					s.grade = grade;
					
					t.insert(s);
					System.out.println("student " + name +" is inserted!");
					break;
				case 3:
					//delete
					System.out.println("Delete a student:");
					System.out.println("Please input the id:");
					id = input.nextInt();
					while(t.find(id)==null)
					{
						System.out.println("Could not find student! Please re enter!");
						id = input.nextInt();
					}
					while(t.find(id)!=null)
					{
						t.delete(id);
						System.out.println("Deleted!");
						break;
					}
					
					break;
					
				case 4:
					//display one
					System.out.println("Search for student (please input student id):");
					id = input.nextInt();
					/*
					Student stu = t.find(id);
					System.out.println("Find student:");
					stu.display();
					*/
					t.findID(id);
					break;
				case 5:
					//display id sorted
					System.out.println("Display id sorted:");
					t.displayID(t.getRoot());
					break;
					
				case 6:
					//display grade sorted
					System.out.println("Display grade sorted");
					t.displayGrade();
					break;
				case 7:
					//display students above cetain grade
					System.out.println("Display students above certain grade");
					System.out.println("Please enter the grade:");
					grade = input.nextInt();
					t.displayAboveGrade(t.getRoot(), grade);
					break;
				case 8:
					//exit
					System.out.println("exit");
					tf=false;
					break;
				default:
					System.out.print("Please input integers 1 - 8!");
			}
		}
	}

}
