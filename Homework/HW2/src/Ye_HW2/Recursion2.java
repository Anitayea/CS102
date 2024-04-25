package Ye_HW2;

public class Recursion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(binary(3));
		//System.out.println(binary(18));
		System.out.println(zero(3));
		System.out.println(zero(2));
		System.out.println(zero(20322));
		
	}
	/*
	 * This recursive algorithm tested divides and return the number of zeros
	 * therefore return binary reresentation of an int
	 */
	public static int zero(int a)
	{
		if(a==1)
		{
			return 0;
		}
		else
		{
			if(a%2==0)
			{
				return 1+zero(a/2);
			}
			else
			{
				return zero(a/2);
			}
		}
	}
	/*
	public static int zero(int a)
	{
		int b = binary(a);
		int n=0;
		if(a==0)
		{
			return 1;
		}
		else if (b==1)
		{
			return 0;
		}
		else
		{
			return n+zero(b/10);
		}
	}
	
	public static int binary(int b)
	{
		if(b==0)
		{
			return 0;
		}
		return (b%2+10*binary(b/2));
	}*/
}
