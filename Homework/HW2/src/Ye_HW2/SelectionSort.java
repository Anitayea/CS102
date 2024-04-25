package Ye_HW2;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = {4,77,98,30,20,50,77,22,49,2};
		selection(x);
		System.out.println("Sorted Array:");
		for(int n:x)
		{
			System.out.println(n);
		}
		
	}
	public static void selection(int[] a)
	{
		for(int i=0; i<a.length-1; i++)
		{
			System.out.println("i: "+i);
			int mi = i;
			System.out.println("mi: "+ mi);
			for(int j=i+1; j<a.length; j++)
			{
				System.out.println("j: "+j);
				if(a[j]<a[mi])
				{
					mi = j;
					System.out.println("change mi: "+mi);
				}
			}
			int t = a[mi];
			a[mi] = a[i];
			a[i] = t;
			for(int x:a)
			{
				System.out.print(x+" ");
			}
			System.out.println();
			System.out.println("--------------");
		}
	}

}
