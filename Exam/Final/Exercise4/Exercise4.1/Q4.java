package Exercise41;

public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentList l = new StudentList();
		Student a = new Student("a", 100);
		Student b = new Student("b", 0);
		Student c = new Student("c", 90);
		Student d = new Student("d", 60);
		l.insertFirst(a);
		l.insertFirst(b);
		l.insertFirst(c);
		l.insertFirst(d);
		System.out.println("Original list");
		l.displayList();
		//sort
		System.out.println("Sorted list");
		l.sort();
		l.displayList();
	}

}
