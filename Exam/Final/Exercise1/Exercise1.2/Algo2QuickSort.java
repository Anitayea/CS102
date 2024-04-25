package Ye_Final;

public class Algo2QuickSort {
	//quick sort

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = {4,77,98,30,20,50,77,22,49,2};
		quick(x,0,x.length-1);
		System.out.println();
		//quick2(x,0,x.length-1);
		for(int n : x)
		{
			System.out.println(n);
		}
	}

	public static void quick(int a[], int x, int y)
	{
		if(x<y)
		{
			//use partition to pick the best pivot
			int pivot = partition(a, x, y);
			System.out.println(pivot);
			quick(a, x, pivot-1);
			quick(a, pivot+1, y);
		}
	}
	/*
	 * partition selects the median as the pivot of quick sort
	 */
	public static int partition(int[] a, int x, int y)
	{
		int i1 = x+1;
		int i2 = y;
		while(i2>i1)
		{
			//change index when passes test cases
			while(i1<a.length && a[x]>a[i1])
			{
				i1++;
			}
			while(a[x]<a[i2])
			{
				i2--;
			}
			if(i1<i2)
			{
				int t = a[i1];
				a[i1]=a[i2];
				a[i2] = t;
			}
		}
		if(a[x]>a[i2])
		{
			int t = a[i2];
			a[i2]=a[x];
			a[x] = t;
		}
		return i2;
	}
}
