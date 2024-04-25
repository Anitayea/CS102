package Quiz4;
import java.io.*;
import java.util.*;

public class Tree
{
	private Node root;
	public Tree()
	{ 
		root = null; 
	}
	public Tree(Node n)
	{
		root = n;
	}
	public Node getRoot()
	{
		return root;
	}
	public void setRoot(Node r)
	{
		root = r;
	}
	public Node find(int key)
	{
		Node cur = root;
		while(cur.iData != key)
		{
			if(key < cur.iData)
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
	public void insert(int id, double dd)
	{
		Node node = new Node(id, dd);
		node.iData = id;
		node.dData = dd;
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
	public boolean delete(int key)
	{
		Node cur = root;
		Node parent = root;
		
		boolean isLeftChild = true;
	
		while(cur.iData != key)
		{
			parent = cur;
			if(key < cur.iData)
			{
				isLeftChild = true;
				cur = cur.leftChild;
			}
			else
			{
				isLeftChild = false;
				cur = cur.rightChild;
			}
			if(cur == null)
			{
				return false;
			}
		}
		if(cur.leftChild==null && cur.rightChild==null)
		{
			if(cur == root)
			{
				root = null;
			}
			else if(isLeftChild)
			{
				parent.leftChild = null;
			}
			else
			{
				parent.rightChild = null;
			}
		}
	
		else if(cur.rightChild==null)
		{
			if(cur == root)
			{
				root = cur.leftChild;
			}
			else if(isLeftChild)
			{
				parent.leftChild = cur.leftChild;
			}
			else
			{
				parent.rightChild = cur.leftChild;
			}
		}
		
		else if(cur.leftChild==null)
		{
			if(cur == root)
			{
				root = cur.rightChild;
			}
			else if(isLeftChild)
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
			Node successor = getSuccessor(cur);
			
			if(cur == root)
			{
				root = successor;
			}
			else if(isLeftChild)
			{
				parent.leftChild = successor;
			}
			else
			{
				parent.rightChild = successor;
			}
			//successor.leftChild = cur.leftChild;
		}
		return true;
	}
	
	private Node getSuccessor(Node delNode)
	{
		Node successorParent = delNode;
		Node successor = delNode;
		Node cur = delNode.rightChild;
		while(cur != null)
		{
			successorParent = successor;
			successor = cur;
			cur = cur.leftChild;
		}
		if(successor != delNode.rightChild)
		{
			//System.out.println(successorParent.leftChild.iData);
			//System.out.println(successor.rightChild.iData);
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
			successor.leftChild = delNode.leftChild;
			//System.out.println(successor.leftChild.iData);
		}
		return successor;
	}
	public void traverse(int type)
	{
		switch(type)
		{
			case 1: 
				System.out.println("Preorder traversal: ");
				preorder(root);
				break;
			case 2: 
				System.out.println("Inorder traversal:  ");
				inorder(root);
				break;
			case 3: 
				System.out.println("Postorder traversal: ");
				postorder(root);
				break;
		}
		System.out.println();
	}
	private void preorder(Node localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.iData + " ");
			preorder(localRoot.leftChild);
			preorder(localRoot.rightChild);
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
	private void postorder(Node localRoot)
	{
		if(localRoot != null)
		{
			postorder(localRoot.leftChild);
			postorder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}
	//This is taken from the sample code using stack
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");
		while(isRowEmpty==false)
		{
			Stack localStack = new Stack();
			isRowEmpty = true;
			
			for(int i=0; i<nBlanks; i++)
			{
				System.out.print(' ');
			}
			while(globalStack.isEmpty()==false)
			{
				Node temp = (Node)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					
					if(temp.leftChild != null || temp.rightChild != null)
					{
						isRowEmpty = false;
					}
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int i=0; i<nBlanks*2-2; i++)
				{
					System.out.print(' ');
				}
			}
			
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
			{
				globalStack.push( localStack.pop() );
			}
		}
		System.out.println("......................................................");
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
		//System.out.println("min: "+ min);
		//System.out.println("max: "+max);
		return isBST(root.leftChild, min, root.iData) && isBST(root.rightChild, root.iData, max);
	}
	public boolean ISBST(Tree tree)
	{
		return isBST(tree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	
}

