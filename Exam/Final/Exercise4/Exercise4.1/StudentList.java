package Exercise41;

public class StudentList {
	private Student first;
	public StudentList()
	{
		first = null;
	}
	public boolean isEmpty()
	{
		return (first==null);
	}
	public void insertFirst(Student s)
	{                           
		//Student student = new Student(n, g);
		s.next = first;
		first = s;
	}
	public Student deleteFirst()     
	{                           
		Student s = first;
		first = first.next;
		return s;
	}
	public void displayList()
	{
	//display all the elements in the lists
		//System.out.println("List: ");
		Student cur = first;
		while(cur!=null)
		{
			cur.display();
			cur = cur.next;
		}
		System.out.println();
	}
	public void sort()
	{
	//sort the list
		Student cur = first;
		Student it; 
		int g;
		String n;
		while(cur != null)
		{
			it = cur.next;
			while(it != null)
			{
				if(cur.grade > it.grade)
				{
					g = cur.grade;
					cur.grade = it.grade;
					it.grade = g;
					
					n = cur.name;
					cur.name = it.name;
					it.name = n;
				}
				it = it.next;
			}
			cur = cur.next;
		}
	}
}
