package Ye_HW2;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = {4,77,98,30,20,50,77,22,49,2};
		int[] a = binarySort(x,0,x.length-1);
		System.out.println("Sorted Array:");
		for(int n : a)
		{
			System.out.println(n);
		}

	}
	public static int[] binarySort(int[] a, int s, int e)
	{
		if(s==e)
		{
			int[] x = {a[s]};
			return x;
 		}
		
		int m = (s+e)/2;
		//use the mergeSort to merge first half and last half of the arrays
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
			//when length are same, compare and swap
			if(an<a.length&&bn<b.length)
			{
			//increment indexes once it is tested smaler
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
			//when length is not the same, simple increment the index
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
