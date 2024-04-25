package Exercise42;

public class Link {
	public int iData;
	public Link next;
	public Link(int i)
	{
		iData = i;
	}
	public void displayLink()      // display ourself
	{
		System.out.print(iData+ " ");
	}
}
