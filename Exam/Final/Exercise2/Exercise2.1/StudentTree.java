package Exercise21;

import java.util.*;

public class StudentTree {
	private Student root;
	public Student getRoot()
	{
		return root;
	}
	public StudentTree()
	{
		root = null;
	}
	
	public void create(int n)
	{
		Scanner input = new Scanner(System.in);
		Student[] studentList = new Student[n];
		System.out.println("Create the tree");
		for(int i = 0; i<n; i++)
		{
			Student s = new Student();
			System.out.println("Please input the id:");
			int id = input.nextInt();
			s.id = id;
			
			System.out.println("Please input the name:");
			String name = input.next();
			s.name = name;
			
			System.out.println("Please input the grade:");
			int grade = input.nextInt();
			s.grade = grade;
			studentList[i] = s;
			//t.insert(s);
			System.out.println("student " + name +" is inserted!");
		}
		for(int i=0; i<n; i++)
		{
			insert(studentList[i]);
		}
	}
	//
	public Student find(int i)
	{
		Student cur = root;
		while(cur.id != i)
		{
			if(i < cur.id)
			{
				cur = cur.leftChild;
			}
			else
			{
				cur = cur.rightChild;
			}
			if(cur == null)
			{
				return null;
			}
		}
		return cur;
	}
	public void findID(int i)
	{
		Student s = find(i);
		if(s==null)
		{
			System.out.println("could not find student!");
		}
		else
		{
			System.out.println("Found:");
			s.display();
		}
	}
	
	public void insert(Student s)
	{
		if(root == null)
		{
			root = s;
		}
		else
		{
			Student cur = root;
			Student parent;
			while(true)
			{
				parent = cur;
				if(s.id < cur.id)
				{
					cur = cur.leftChild;
					if(cur == null)
					{
						parent.leftChild = s;
						return; 
					}
				}
				else
				{
					cur = cur.rightChild;
					if(cur == null)
					{
						parent.rightChild = s;
						return;
					}
				}
			}
		}
	}
	public boolean delete(int i)
	{
		Student cur = root;
		Student parent = root;
		
		boolean isLeft = true;
		while(cur.id != i)
		{
			parent = cur;
			if(i < cur.id)
			{
				
				cur = cur.leftChild;
				isLeft = true;
			}
			else
			{
				
				cur = cur.rightChild;
				isLeft = false;
			}
			
			if(cur == null)
			{
				return false;
			}
		}
		if(cur.leftChild == null && cur.rightChild == null)
		{
			if(cur == root)
			{
				root = null;
			}
			else if(isLeft)
			{
				//parent.leftChild = cur.leftChild;
				parent.leftChild = null;
			}
			else
			{
				//parent.rightChild = cur.rightChild;
				parent.rightChild = null;
			}
		}
		else if(cur.rightChild == null)
		{
			if(cur == root)
			{
				root = cur.leftChild;
			}
			else if(isLeft)
			{
				parent.leftChild = cur.leftChild;
			}
			else
			{
				parent.rightChild = cur.leftChild;
			}
		}
		else if(cur.leftChild == null)
		{
			if(cur == root)
			{
				root = cur.rightChild;
			}
			else if(isLeft)
			{
				parent.leftChild = cur.rightChild;
			}
			else
			{
				parent.rightChild = cur.rightChild;
			}
		}
		else
		{
			Student successor = getSuccessor(cur);
			
			if(cur == root)
			{
				root = successor;
			}
			else if(isLeft)
			{
				parent.leftChild = successor;
			}
			else
			{
				parent.rightChild = successor;
			}
			//
			//successor.leftChild = cur.leftChild;
		}
		
		return true;
	}
	private Student getSuccessor(Student dStu)
	{
		Student successorParent = dStu;
		Student successor = dStu;
		Student cur = dStu.rightChild;
		while(cur != null)
		{
			successorParent = successor;
			successor = cur;
			cur = cur.leftChild;
		}
		if(successor != dStu.rightChild)
		{
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = dStu.rightChild;
			//
			successor.leftChild = dStu.leftChild;
		}
		return successor;
	}
	public void displayID(Student s)
	{
		if(s != null)
		{
			displayID(s.leftChild);
			s.display();
			displayID(s.rightChild);
		}
	}
	public void displayGrade()
	{
		
		 ArrayList<Integer> gradeList = new ArrayList<Integer>();
		 grade(root, gradeList);
		 //System.out.println(gradeList);
		 //System.out.println(gradeList.size());
		 for(int i = 0; i < gradeList.size()-1; i++)
		 {
			 for(int j = i+1; j<gradeList.size(); j++)
			 {
				 if(gradeList.get(i) > gradeList.get(j))
				 {
					 int t = gradeList.get(j);
					 gradeList.set(j, gradeList.get(i));
					 gradeList.set(i, t);
				 }
			 }
		 }
		System.out.println(gradeList);
	}
	public void grade(Student s, ArrayList<Integer> l)
	{
		if(s!=null)
		{
			grade(s.leftChild, l);
			l.add(s.grade);
			grade(s.rightChild, l);
		}
	}
	public void displayAboveGrade(Student s, int g)
	{
		if(s != null)
		{
			displayAboveGrade(s.leftChild, g);
			if(s.grade>g)
			{
				s.display();
			}
			displayAboveGrade(s.rightChild, g);
		}
	}
	

}
