package Lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//class package IOTestOut
public class IOTestOut {
	
		//main
	public static void main(String[] agrs) throws IOException
	{
		BufferedReader in = new BufferedReader(
				new InputStreamReader(System.in));
		//request length and width from user
		//save in l & w
		//convert input String to int : Integer.parseInt(stringValue))
		int l =Integer.parseInt(in.readLine());
		int w =Integer.parseInt(in.readLine());
		//Rectangle object
		Rectangle r = new Rectangle(l,w);
		//output rectangle
		int area=r.getArea();
		System.out.println(area);
	}

}
