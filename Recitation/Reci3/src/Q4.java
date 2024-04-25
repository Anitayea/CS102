
public class Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "AAAbbCCC";
		System.out.println(removeConsecutive(0,a));

	}
	public static String removeConsecutive(int n, String str)
	{
		String s="";
		if (str.length()<2)
		{
			return str;
		}
		else
		{
			if(n==str.length()-1)
			{
				s+=str.charAt(n);
				return s;
			}
			if(str.charAt(n)!=str.charAt(n+1))
			{
				s+=str.charAt(n);
				return s+removeConsecutive(n+=1, str);
			}
			else
			{
				return removeConsecutive(n+=1, str);
			}
		}
	}

}