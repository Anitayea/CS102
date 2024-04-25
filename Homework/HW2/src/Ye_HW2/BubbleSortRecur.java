package Ye_HW2;

public class BubbleSortRecur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = {4,77,98,30,20,50,77,22,49,2};
		bubble(x, x.length);
		System.out.println();
		System.out.println("Sorted Array:");
		for(int n : x)
		{
			System.out.println(n);
		}
	}
	//n is the length of a since this algo traces from backwards
	public static void bubble(int[] a, int n)
	{
		System.out.println(n);
		/*
		if(n==1)
		{
			return;
		}*/
		//compares the element and swap
		for(int i=0; i<n-1; i++)
		{
			if(a[i]>a[i+1])
			{
				int t = a[i];
				a[i] = a[i+1];
				a[i+1] = t;
			}
			for(int b : a)
			{
				System.out.print(b+" ");
			}
			System.out.println();
			
		}
		if(n>2)
		{
			//recursive call
			bubble(a, n-1);
		}
		//bubble(a, n-1);
		
	}
	

}
