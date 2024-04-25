package cs102Midterm;

public class Exercise4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {13,66,6,69,22};
		System.out.println(average(arr, 0, arr.length));


	}
	public static double average(int a[], int x, int n)
	{
	    double sum;
	    if(n==1)
	    {
	        return a[x];
	    }
	    else
	    {
	    	int f = (int)Math.floor(n/2.0);
	    	int c = (int)Math.ceil(n/2.0);
	    	sum = average(a,x,f)*f+
	    			average(a,x+f,c)*c;
	    	return sum/(f+c);
	        //sum= a[n-1]+ (n-1) * average(a,n-1);
	    }
	}

}
