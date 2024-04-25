package cs102Midterm;

public class Exercise1 {
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {13,66,6,69,22};
		System.out.println(max(arr, 0, 4));

	}
	
	public static int max(int[] x, int start, int end)
	{
		if(end==start)
		{
			return x[start];
		}
		int mid=(start+end)/2;
		int max1=max(x, start, mid);
		int max2=max(x, mid+1, end);
		if(max1>=max2)
		{
			return max1;
		}
		else
		{
			return max2;
		}
	}

}
