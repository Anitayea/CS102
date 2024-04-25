package Lab1;

public class Rectangle {
	//private int
	private int length;
	private int width;
	
	//default constructor, length=1, width=1
	public Rectangle ()
	{
		length=1;
		width=1;
	}
	//constructor 2 int length/width
	public Rectangle(int len, int wid)
	{
		length = len;
		width = wid;
	}
	//2 getter 
	public int getLen()
	{
		return length;
	}
	public int getWid()
	{
		return width;
	}
	//2 setter
	public void setLen(int len)
	{
		length = len;
	}
	public void setWid(int wid)
	{
		width = wid;
	}
	//method: area
	public int getArea()
	{
		for(int i=0; i<10; i++)
		{
			System.out.println(length*width);
		}
		return length*width;
	}
	//method: isSquare
	public boolean isSquare()
	{
		return (width==length);
	}


}
