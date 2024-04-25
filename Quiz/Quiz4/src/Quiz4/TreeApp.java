package Quiz4;
import java.io.*;
import java.util.*;
class TreeApp
{
	public static void main(String[] args) throws IOException
	{
	   Tree Tree = new Tree();
	   Tree.insert(15, 1.5);
	   Tree.insert(8, 1.2);
	   Tree.insert(20, 1.2);
	   Tree.insert(2, 1.2);
	   Tree.insert(11,1.2);
	   Tree.insert(6, 1.5);
	   Tree.insert(3, 1.2);
	   Tree.insert(7, 1.7);
	   Tree.insert(10, 1.5);
	   Tree.insert(12, 1.2);
	   Tree.insert(14, 1.7);
	   Tree.insert(27, 1.5);
	   Tree.insert(22, 1.2);
	   Tree.insert(30, 1.7);
	   //Tree.insert(20, 1.2);
	   
	   //This tree is used to test isBST
	   Node n1 = new Node(5, 5.0);
	   Node n2 = new Node(2, 2.0);
	   Node n3 = new Node(8, 8.0);
	   Node n4 = new Node(0, 0.0);
	   Node n5 = new Node(4, 4.0);
	   Node n6 = new Node(1, 1.0);
	   
	   Tree tree = new Tree(n1);
	   n1.setChild(n3, n2);
	   n2.setChild(n4, n5);
	   //boolean b = tree.isBST(n1, Integer.MIN_VALUE, Integer.MAX_VALUE);
	   boolean b = tree.ISBST(tree);
	   tree.traverse(2);
	   System.out.println(b);
	   
	   //used to record user input value
	   int x;
	   boolean tf = true;
	   while(tf)
	   {
		  Scanner input = new Scanner(System.in);
	      System.out.println("Please enter integer number of your choice:"
	      		+ "\n 1. display the tree"
	      		+ "\n 2. insert"
	      		+ "\n 3. find"
	      		+ "\n 4. delete"
	      		+ "\n 5. traverse"
	      		+ "\n 6. test if the tree is bst"
	      		+ "\n 7. exit");
	      int c = input.nextInt();
	      switch(c)
	      {
	         case 1:
	            Tree.displayTree();
	            break;
	         case 2:
	            System.out.print("Please enter value to insert: ");
	            x = input.nextInt();
	            Tree.insert(x, x+0.0);
	            System.out.println(x + " inserted!");
	            break;
	         case 3:
	            System.out.print("Please enter value to find: ");
	            x = input.nextInt();
	            Node found = Tree.find(x);
	            if(found != null)
	            {
	            	found.displayNode();
	            	System.out.print("found!");
	            	System.out.println();
	            	//break;
	            }
	            else
	            {
	            	System.out.print("Could not find "+x+"!");
	            	System.out.println();
		            break;
	            }
	            break;
	         case 4:
	            System.out.print("Enter value to delete: ");
	            x = input.nextInt();
	            boolean d = Tree.delete(x);
	            if(d)
            	{
	            	System.out.print("Deleted " + x + '\n');
            	}
	            else
	            {
	            	System.out.print("Could not delete "+ x+"!");
	            	System.out.println();
	            	break;
	            }
	            break;
	         case 5:
	            System.out.print("Enter type 1, 2 or 3: ");
	            x = input.nextInt();
	            Tree.traverse(x);
	            break;
	         case 6:
	        	 //boolean bst = Tree.isBST(Tree.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE);
	        	 boolean bst = Tree.ISBST(Tree);
	        	 if(bst)
	        	 {
	        		 System.out.println("this tree is a bst tree!");
	        	 }
	        	 else
	        	 {
	        		 System.out.println("this tree is not a bst tree!");
	        	 }
	        	 break;
	         case 7:
	        	 System.out.println("exit");
	        	 tf=false;
	        	 break;
	         default:
	            System.out.print("Please input integers 1 - 7!");
	         }
	      }
	   }
}