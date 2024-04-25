package Exercise41;

public class Student {
	public String name;
	public int grade;
	public Student next;
	
	public Student(String n, int g)
	{
		name = n;
		grade = g;
	}
	public void display()
	{
		System.out.print("name:" + name +"; ");
		System.out.print("grade:" + grade +"; ");
		System.out.println();
	}
}
