package phoneAgendas;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> in = new ArrayList<String>();
		/*in.add("George");
		in.add("Gregory");
		in.add("Hugo");
		in.add("James");
		in.add("Julia");
		in.add("Lara");
		in.add("Noah");
		in.add("Pamela");
		in.add("Paul");
		in.add("Pauline");
		in.add("Sandra");
		in.add("Salima");
		in.add("Tudor");
		in.add("Adam"); //<--> switching point
		in.add("Alesia");
		in.add("Bridget");
		in.add("Charlie");
		in.add("Celine");
		in.add("Diane");
		in.add("Fabio");*/
		
		
		in.add("George");
		in.add("Gregory");
		in.add("Hugo");
		in.add("James");
		in.add("Charlie"); //<--> switching point
		in.add("Celine");
		in.add("Diane");
		in.add("Fabio");
		
		/*in.add("Adam"); //<--> NO switching point
		in.add("Alesia");
		in.add("Bridget");
		in.add("Charlie");
		in.add("Celine");
		in.add("Diane");
		in.add("Fabio");*/
		
		//phoneAgenda p = new phoneAgenda();
		//int result = p.returnChangeIndex(in);
		//System.out.println("Index at which the switching occurs: " + result);
		
//		phoneAgendaEfficient pe = new phoneAgendaEfficient();
//		int result2 = pe.returnChangeIndex(in);
//		System.out.println("Index at which the switching occurs: " + result2);
		
		phoneAgendaEfficient pe2 = new phoneAgendaEfficient();
		int result3 = pe2.returnChangeIndex(in);
		if(result3!=-1)
		{
			System.out.println("Index at which the switching occurs: " + result3);
		}
	}

}
