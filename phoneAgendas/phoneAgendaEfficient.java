package phoneAgendas;
import java.util.ArrayList;

public class phoneAgendaEfficient {
	
	public int returnChangeIndex(ArrayList<String> in)
	{
		String bff = in.get(0);
		int switchingPoint = -1;
		int l=0, r=in.size()-1,m=0;
		
		while(l<=r)
		{
			m = (l+r)/2;
			if(in.get(m).compareTo(bff)>0)
			{
				l=m+1;
			}
			else
			{
				switchingPoint=m;
				r=m-1;
			}
			
			/*for(int i=l;i<=r;i++)
			{
				System.out.print(in.get(i)+"  ");
			}
			System.out.print("\n");*/
		}
		if(switchingPoint!=-1)
		{
			System.out.println("Friend's name where switching point happens: " + in.get(m));
		}
		else
		{
			System.out.println("All names in agenda are in alphabetical order.");
		}
		
		return switchingPoint;
	}

}
