package Exercise22;


public class Node {
	public int iData;
	public Node leftChild;
	public Node rightChild;
	
	public Node(int id)
	{
		iData = id;
	}
	public void setLeft(Node l)
	{
		leftChild = l;
	}
	public void setRight(Node r)
	{
		rightChild = r;
	}
}
