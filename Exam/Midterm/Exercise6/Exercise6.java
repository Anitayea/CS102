package cs102Midterm;

public class Exercise6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("");
		int[] a = {1,1,8};
		int[] b = {1,3,6,7,9};
		int[] c = mergeSort(a,b);
		for(int i=0; i<(c.length); i++)
		{
			System.out.println(c[i]);
		}
	}
	public static int[] mergeSort(int[] a, int[] b)
	{
		int size = a.length+b.length;
		int[] c = new int[size];
		int an = 0;
		int bn = 0;
		for(int i=0; i<size; i++)
		{
			if(an<a.length&&bn<b.length)
			{
			
				if(a[an]<b[bn])
				{
					c[i]=a[an];
					an++;
				}
				else if(a[an]>b[bn])
				{
					c[i]=b[bn];
					bn++;
				}
				else
				{
					c[i]=a[an];
					c[i+1]=b[bn];
					i++;
					an++;
					bn++;
				}
			}
			else if(an==a.length && bn<b.length)
			{
				c[i]=b[bn];
				bn++;
			}
			else if(bn==b.length && an<a.length)
			{
				c[i]=a[an];
				an++;
			}
		}
		return c;
	}

}
