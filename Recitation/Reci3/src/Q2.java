
public class Q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,5,9,2};
		int max = maxArray(0, arr);
		System.out.println(max);
		String a = "AAbb";
		System.out.println(a.replace(a.substring(0,1), "C"));

	}
	public static int maxArray(int n, int[] arr)
	{
		if(n==arr.length-1)
		{
			return arr[n];
		}
		else
		{
			return Math.max(arr[n], maxArray(n+1, arr));
		}
	}

}