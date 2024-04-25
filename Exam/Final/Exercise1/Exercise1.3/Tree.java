package Ye_Final;

public class Tree
{
	private Node root;
	public Tree()
	{ 
		root = null; 
	}
	
	public void insert(int id)
	{
		Node node = new Node();
		node.iData = id;
		if(root==null)
		{
			root = node;
		}
		else
		{
			Node cur = root;
			Node parent;
			while(true)
			{
				parent = cur;
				if(id < cur.iData)
				{
					cur = cur.leftChild;
					if(cur == null)
					{
						parent.leftChild = node;
						return;
					}
				}
				else
				{
					cur = cur.rightChild;
					if(cur == null)
					{ 
						parent.rightChild = node;
						return;
					}
				}
			}
		}
	}
	
	private void inorder(Node localRoot)
	{
		if(localRoot != null)
		{
			inorder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inorder(localRoot.rightChild);
		}
	}
	/*
	public void create(int[] a)
	{
		for(int i=0; i<a.length; i++)
		{
			insert(a[i]);
		}
	}
	
	public void sort(int[] a)
	{
		Tree t = new Tree();
		for(int i=0; i<a.length; i++)
		{
			t.insert(a[i]);
		}
		t.inorder(root);
	}
	*/
	public void sort(Tree t, int[] a)
	{
		for(int i=0; i<a.length; i++)
		{
			insert(a[i]);
		}
		inorder(root);
	}
}
