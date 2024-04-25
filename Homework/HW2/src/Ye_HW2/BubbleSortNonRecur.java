package Ye_HW2;

public class BubbleSortNonRecur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = {4,77,98,30,20,50,77,22,49,2};
		bubble(x);
		System.out.println("Sorted Array:");
		for(int n : x)
		{
			System.out.println(n);
		}

	}
	//print statements are for tracing the sorting process
	public static void bubble(int[] a) 
	{
		int l=a.length;
		//two for loops 
		for(int i=0; i<l-1; i++)
		{
			System.out.println("i: "+i);
			for(int j=i+1; j<l; j++)
			{
				System.out.println("j: "+j);
				if(a[i]>a[j])
				{
					System.out.println("swap");
					//swap once it passes the test
					int t=a[i];
					a[i]=a[j];
					a[j]=t;
					
					for(int x:a)
					{
						System.out.print(x+" ");
					}
					System.out.println();
				}
			}
			
			//System.out.println();
			for(int x:a)
			{
				System.out.print(x+" ");
			}
			System.out.println();
			System.out.println();
		}
		
	}
	
}
