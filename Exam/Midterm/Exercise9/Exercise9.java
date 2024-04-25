package cs102Midterm;

public class Exercise9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {3,7,5,9,0};
		findPair(a);
		int[] a2 = binaryPair(a);
		for(int i=0; i<a2.length; i++)
		{
			System.out.print(a2[i]+" ");
		}
	}
	//
	public static void findPair(int[] a)
	{
		int diff=Math.abs(a[1]-a[0]);
		int i1=0;
		int i2=1;
		for(int i=0; i<a.length-1;i++)
		{
			for(int j=i+1; j<a.length;j++)
			{
				int d=Math.abs(a[i]-a[j]);
				if(d<diff)
				{
					diff=d;
					i1=i;
					i2=j;
				}
			}
		}
		System.out.println(a[i1]+" "+a[i2]);
	}
	public static int[] binaryPair(int[] a)
	{
		int[] x = binarySort(a, 0, a.length-1);
		int diff = Math.abs(x[0]-x[1]);
		int i=1;
		int index=0;
		while(i<a.length-1)
		{
			int d = Math.abs(x[i]-x[i+1]);
			if(d<diff)
			{
				diff=d;
				index=i;
			}
			i++;
		}
		int[] pair = {x[index], x[index+1]};
		return pair;
	}
	public static int[] binarySort(int[] a, int s, int e)
	{
		if(s==e)
		{
			int[] x = {a[s]};
			return x;
 		}
		
		int m = (s+e)/2;
		int[] x1 = binarySort(a, s, m);
		int[] x2 = binarySort(a, m+1, e);
		return mergeSort(x1,x2);
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
