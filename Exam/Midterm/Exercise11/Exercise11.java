package cs102Midterm;

public class Exercise11 {
	
	public static int BinarySearch(int key, int[] A, int LI, int HI)
	{
		int mid = (LI+HI)/2;
		if(LI>HI)
		{
			return -1;
		}
		
		if(key==A[mid])
		{
			return mid;
		}
		else if(key<A[mid])
		{
			return BinarySearch(key, A, LI, mid-1);
		}
		else
		{
			return BinarySearch(key, A, mid+1, HI);
		}
			
	}

}
