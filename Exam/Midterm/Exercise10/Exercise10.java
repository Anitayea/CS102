package cs102Midterm;

public class Exercise10 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(12321));
		System.out.println(isPalindrome(1231));
		System.out.println(isPalindrome(1221));

	}
	public static int palindrome(int n, int r)
	{
		if(n==0)
		{
			return r;
		}
		r = r*10+n%10;
		return palindrome(n/10, r);
	}
	public static boolean isPalindrome(int n)
	{
		int a = palindrome(n, 0);
		return a==n;
	}

}
