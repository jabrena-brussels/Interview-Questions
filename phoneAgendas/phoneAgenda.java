package phoneAgendas;

import java.util.ArrayList;

public class phoneAgenda {
	
	public int returnChangeIndex(ArrayList<String> in)
	{
		int switchingPoint=0;
		for(int i=0;i<in.size()-1;i++)
		{
			String current = in.get(i);
			String next = in.get(i+1);
			
			//This will return true if s2 comes before s1 i.e., in the alphabetic order.
			if(current.charAt(0)>next.charAt(0))
			{
				switchingPoint=i+1; //the switching point is the index of "next"
				System.out.println("Friend's name where the switching point occurs: " + next);
				break;
			}
		}
		return switchingPoint;
	}
	
}
