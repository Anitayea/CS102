package Exercise42;

public class Q42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList l1 = new LinkList();
		LinkList l2 = new LinkList();
		l1.insertFirst(8);
		l1.insertFirst(3);
		l1.insertFirst(2);
		l1.insertFirst(0);
		l2.insertFirst(10);
		l2.insertFirst(9);
		l2.insertFirst(6);
		l2.insertFirst(5);
		l2.insertFirst(3);
		l2.insertFirst(1);
		System.out.print("list1:");
		l1.displayList();
		System.out.println();
		System.out.print("list2:");
		l2.displayList();
		LinkList list3=mergeSort(l1,l2);
		System.out.println();
		System.out.print("list3:");
		list3.displayList();
	}
	
	public static LinkList mergeSort(LinkList a, LinkList b)
	{
		LinkList l = new LinkList();
		Link an = a.getFirst();
		Link bn = b.getFirst();
		while(an!= null || bn != null)
		{
			if(an != null && bn != null)
			{
				if(an.iData < bn.iData)
				{
					if(l.isEmpty())
					{
						l.insertFirst(an.iData);
					}
					else
					{
						Link cur = l.getFirst();
						Link t = new Link(an.iData);
						while(cur.next != null)
						{
							cur = cur.next;
						}
						cur.next = t;
					}
					an = an.next;
				}
				else
				{
					if(l.isEmpty())
					{
						l.insertFirst(bn.iData);
					}
					else
					{
						Link cur = l.getFirst();
						Link t = new Link(bn.iData);
						while(cur.next != null)
						{
							cur = cur.next;
						}
						cur.next = t;
					}
					bn = bn.next;
				}
			}
			else if(an == null)
			{
				Link cur = l.getFirst();
				Link t = new Link(bn.iData);
				while(cur.next!=null)
				{
					cur = cur.next;
				}
				cur.next = t;
				bn = bn.next;
			}
			else
			{
				Link cur = l.getFirst();
				Link t = new Link(an.iData);
				while(cur.next!=null)
				{
					cur = cur.next;
				}
				cur.next = t;
				an = an.next;
			}
		}
		return l;
	}
}
