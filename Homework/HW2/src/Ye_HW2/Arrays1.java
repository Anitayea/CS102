package Ye_HW2;

public class Arrays1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("int", "tni"));
		System.out.println(reverse("int", "ti"));
		System.out.println(reverse("int", "int"));
		System.out.println(reverse("rftghkj", "rftghkj"));
		System.out.println(reverse("data", "atat"));

	}
	public static int reverse(String a, String b)
	{
		int la=a.length();
		int lb=b.length();
		//compare the length: if the lengths do not match they can not be reverse
		if(la!=lb)
		{
			return 0;
		}
		for(int i=0; i<la; i++)
		{
			//compare the string with its reversed index, once fail, return 0
			if(!a.substring(i,i+1).equals(b.substring(la-1-i, la-i)))
			{
				return 0;
			}
		}
		return 1;
	}

}
