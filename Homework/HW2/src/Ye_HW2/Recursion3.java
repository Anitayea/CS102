package Ye_HW2;

public class Recursion3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(("kayak")));
		System.out.println(isPalindrome(("kaak")));
		System.out.println(isPalindrome(("wdwfewdw")));
		System.out.println(isPalindrome(("1231")));
		System.out.println(isPalindrome(("qwerrewq")));

	}
	//copies the string backward
	public static String palindrome(String x, String y)
	{
		if(x=="")
		{
			return y;
		}
		y = y+x.substring(x.length()-1, x.length());
		return palindrome(x.substring(0, x.length()-1),y);
	}
	//compare the backward string
	public static boolean isPalindrome(String a)
	{
		String b = palindrome(a,"");
		return b.equals(a);
	}

}
