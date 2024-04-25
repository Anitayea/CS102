package Exercise22;

public class IsBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   Node n1 = new Node(5);
	   Node n2 = new Node(2);
	   Node n3 = new Node(8);
	   Node n4 = new Node(0);
	   Node n5 = new Node(4);
	   Node n6 = new Node(1);
	   BST t = new BST(n1);
	   n1.setLeft(n2);
	   n1.setRight(n3);
	   n2.setLeft(n4);
	   n2.setRight(n5);
	   n5.setLeft(n6);
	   t.printTraverse();
	   System.out.println();
	   boolean isBST = t.ISBST(t);
	   t.printBST(isBST);
	}

}
