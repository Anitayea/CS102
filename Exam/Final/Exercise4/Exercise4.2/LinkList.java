package Exercise42;


public class LinkList {
	private Link first;
	public Link getFirst()
	{
		return first;
	}
	public LinkList()
	{
		first = null;
	}
//-------------------------------------------------------------
	public boolean isEmpty()
	{
		return (first==null);
	}
//-------------------------------------------------------------
//insert at start of list
	public void insertFirst(int id)
	{                           
		Link newLink = new Link(id);
		newLink.next = first;
		first = newLink;
	}  
//-------------------------------------------------------------
	public Link deleteFirst()     
	{                           
		Link t = first;
		first = first.next;
		return t;
	}	  
//-------------------------------------------------------------
	public void displayList()
	{
	//display all the elements in the lists
		//System.out.println("List: ");
		Link cur = first;
		while(cur!=null)
		{
			cur.displayLink();
			cur = cur.next;
		}
		System.out.println("");
	}

}
