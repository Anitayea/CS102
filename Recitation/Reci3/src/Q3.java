
public class Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,3,6,-4};
		int a = sumEvenNegative(3, arr);
		System.out.println(a);
		
	}
	public static int sumEvenNegative(int n, int[] arr)
	{
		if(n==0)
		{
			if(arr[n]%2==0||arr[n]<0)
			{
				return arr[n];
			}
			else
			{
				return 0;
			}
		}
		else
		{
			if(arr[n]%2==0||arr[n]<0)
			{
				return arr[n]+sumEvenNegative(n-1, arr);
			}
			else
			{
				return sumEvenNegative(n-1, arr);
			}
		}
	}

}
