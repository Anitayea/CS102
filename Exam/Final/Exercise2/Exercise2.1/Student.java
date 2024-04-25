package Exercise21;

public class Student {
	public int id;
	public String name;
	public int grade;
	public Student leftChild;
	public Student rightChild;
	/*
	public Student(int i, String n, int g)
	{
		id = i;
		name = n;
		grade = g;
	}*/
	public void display()
	{
		System.out.print("name: " + name +"; ");
		System.out.print("id: " + id +"; ");
		System.out.print("grade: " + grade +"; ");
		System.out.println();
	}
}
