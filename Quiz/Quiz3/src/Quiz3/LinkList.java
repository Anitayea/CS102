package Quiz3;

public class LinkList
{
	private Link first;            // ref to first link on list

//-------------------------------------------------------------
	public LinkList()              // constructor
	{
		first = null;               // no links on list yet
	}
//-------------------------------------------------------------
	public boolean isEmpty()       // true if list is empty
	{
		return (first==null);
	}
//-------------------------------------------------------------
//insert at start of list
	public void insertFirst(int id, double dd)
	{                           
		Link newLink = new Link(id, dd);
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
		System.out.println("List: ");
		Link cur = first;
		while(cur!=null)
		{
			cur.displayLink();
			cur = cur.next;
		}
		System.out.println("");
	}

// ------------------------------------------------------------- 
	public int countNodes()
	{
		int count = 0;
		//System.out.print("List(first --> last): ");
		Link cur = first;
		while(cur != null)
		{
			cur.displayLink();
			cur = cur.next;
			count += 1;
		}
		System.out.println("");
		return count;
	}
	
	public Link find(int key)
	{
		Link cur = first;
		while(cur.iData != key)
		{
			if(cur.next == null)
			{
				return null;
			}
			else
			{
				cur = cur.next;
			}
		}
		return cur;
	}
//-------------------------------------------------------------
	public void displaytheLastNODEiData()
	{
	//
	//display the last node's iData
		
		Link cur = first;
		while(cur.next!=null)
		{
			//cur.displayLink();
			cur = cur.next;
		}
		
		if(first == null)
		{
			System.out.println(first);
		}
		System.out.println("last node: "+cur.iData);
	
	}

//------------------------------------------------------------- 

	public int findMin()
	{
	//
	//Math.min
	//returns the minimum iData in the list
		Link cur = first;
		int min = first.iData;
		while(cur!=null)
		{
			if(min>cur.iData)
			{
				min = cur.iData;
			}
			cur = cur.next;
		}
		return min;
	
	} 

//------------------------------------------------------------- 


//------------------------------------------------------------- 

	public void DeleteElementwithiData(int a)
	{
	
	//this method will delete any node with iData == a. 
	//if there are many, the method will have to delete all of them.
		Link cur = first;
		Link pre = null;
		while(cur!=null)
		{
			if(cur == first && cur.iData == a)
			{
				first = cur.next;
				cur = first;
			}
			else if(cur.iData == a)
			{
				pre.next = cur.next;
				cur = cur.next;
			}
			else if(cur.iData != a)
			{
				pre = cur;
				cur = cur.next;
			}
		}
	} 

//------------------------------------------------------------- 

	public void removeDuplicates()
	//
	{
	//this method will scan through the list and remove 
	//duplicates. (if the list is: 2->3->2->4->3->5->90 the method should
	//keep on copy of each duplicate, so the list become:
	//2->3->4->5-90
	//if there are no duplicates then the method does not need do anything
		/*
		Link cur = first;
		Link pre = first;
		while(cur != null && cur.next != null)
		{
			pre = first;
			while(pre != null)
			{
				if(first.iData == pre.next.iData)
				{
					pre.next = pre.next.next;
				}
				else
				{
					pre = pre.next;
				}
			}
			first = first.next;
		}
		*/
		Link cur = first;
		Link pre;
		while(cur.next != null)
		{
			pre = cur;
			Link it = cur.next;
			int n = cur.iData;
			while(it!=null)
			{
				if(n == it.iData)
				{
					pre.next = it.next;
					it = it.next;
				}
				else
				{
					pre = it;
					it = it.next;
				}
			}
			cur = cur.next;
		}
		
	} 

//-------------------------------------------------------------

	public void sortList()
	{
	//write an algorithm that I will sort the list in-place
	//do not use arrays. 
		Link cur = first;
		Link it; 
		int t;
		while(cur != null)
		{
			it = cur.next;
			while(it != null)
			{
				if(cur.iData > it.iData)
				{
					t = cur.iData;
					cur.iData = it.iData;
					it.iData = t;
				}
				it = it.next;
			}
			cur = cur.next;
		}
	}
}  // end class LinkList
////////////////////////////////////////////////////////////////
