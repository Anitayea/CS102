package Ye_HW2;

public class Arrays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "Other entries include a historic district "
				+ "in Charlottesville Virginia cut-flower "
				+ "greenhouse complex";
		
		String [] n = leaveShort(x);
		for(int i=0; i<n.length; i++)
		{
			System.out.println(n[i]);
		}
		

	}
	public static String[] leaveShort(String a)
	{
		String[] s = a.split(" ");
		//put the long string into an array
		int l = s.length;
		//make a new empty array
		String[] str = new String[l/3];
		//loop through the array
		for(int i=0; i<l; i+=3)
		{
			//test every group of three words
			int min = i;
			if(s[i+1].length()<s[i].length())
			{
				min = i+1;
			}
			if(s[i+2].length()<s[min].length())
			{
				min = i+2;
			}
			str[i/3]=s[min];
		}
		return str;
	}

}
