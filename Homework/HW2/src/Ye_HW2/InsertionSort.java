package Ye_HW2;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = {4,77,98,30,20,50,77,22,49,2};
		insertion(x);
		System.out.println("Sorted Array:");
		for(int n:x)
		{
			System.out.println(n);
		}
	}
	/* this insertion sort uses t to keeps track of 
	 * the element need to be swapped, and loop through the array
	 */
	public static void insertion(int[] a)
	{
		for(int i=1; i<a.length; i++)
		{
			System.out.println("i:" + i);
			int j = i;
			int t = a[i];
			System.out.println("t: "+t);
			while(j>0 && t<a[j-1])
			{
				System.out.println("j: "+j);
				a[j]=a[j-1];
				System.out.println("a ["+j+"] = " + a[j]);
				j--;
				for(int x:a)
				{
					System.out.print(x+" ");
				}
				System.out.println();
				System.out.println("j--: "+j);
				System.out.println("*********");
			}
			a[j] = t;
			for(int x:a)
			{
				System.out.print(x+" ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}
}
