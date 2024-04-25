package Quiz3;

public class Quiz3
{
	public static void main(String[] args)
	{
		LinkList theList = new LinkList();  // make new list
//this code is for you to use to test you code
//feel free to modify it. 

	theList.insertFirst(22, 2.99);      // insert four items
	theList.insertFirst(44, 4.99);
	theList.insertFirst(66, 6.99);
	theList.insertFirst(88, 8.99);
//... add more elements if you want..

//CALL and TEST YOUR METHODS HERE 
	System.out.println("test display");
	theList.displayList();
	//System.out.println(theList.);
	System.out.println("test count");
	System.out.println(theList.countNodes());
	System.out.println("test find");
	System.out.println(theList.find(44).dData);
	
	System.out.println("test display last node");
	theList.displaytheLastNODEiData();
	theList.insertFirst(11, 1.99);
	theList.displaytheLastNODEiData();
	
	System.out.println("test find min");
	System.out.println(theList.findMin());
	
	//System.out.println("//");
	theList.insertFirst(88, 9.99);
	System.out.println("test delete");
	theList.DeleteElementwithiData(88);
	//theList.DeleteElementwithiData(88);
	theList.displayList();
	
	theList.insertFirst(88, 8.99);
	theList.insertFirst(66, 5.99);
	theList.insertFirst(88, 9.99);
	theList.displayList();
	
	//System.out.println("!");
	System.out.println("test remove duplicate");
	theList.removeDuplicates();
	theList.displayList();
	
	theList.insertFirst(88, 7.99);
	
	System.out.println("test sort");
	theList.sortList();
	theList.displayList();

	}  // end main()
}  // end class LinkListApp
////////////////////////////////////////////////////////////////
