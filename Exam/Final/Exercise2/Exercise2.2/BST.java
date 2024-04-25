package Exercise22;


public class BST {
	public Node root;
	public BST()
	{
		root = null;
	}
	public BST(Node n)
	{
		root = n;
	}
	
	public boolean isBST(Node root, int min, int max)
	{
		if(root == null)
		{
			return true;
		}
		if(root.iData < min || root.iData > max)
		{
			return false;
		}
		return isBST(root.leftChild, min, root.iData) && isBST(root.rightChild, root.iData, max);
	}
	
	public boolean ISBST(BST tree)
	{
		return isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public void printBST(boolean tf)
	{
		if(tf)
		{
			System.out.println("This is a BST");
		}
		else
		{
			System.out.println("This is not a BST");
		}
	}
	public void inorder(Node localRoot)
	{
		if(localRoot!=null)
		{
			inorder(localRoot.leftChild);
			System.out.print(localRoot.iData+" ");
			inorder(localRoot.rightChild);
		}
	}
	public void printTraverse()
	{
		inorder(root);
	}
	
	
}
