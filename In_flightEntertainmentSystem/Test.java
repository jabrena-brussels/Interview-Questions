package In_flightEntertainmentSystem;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Feature f = new Feature();
		int[] movies = {90,100,160,60,120}; 
		int[] movies2 = {160,200,90,90};
		
		int flightLength = 360; //6-hour flight
		boolean result = f.feature(flightLength, movies);
		boolean result2 = f.feature(flightLength, movies2);
		
		System.out.println(result);
		System.out.println(result2);
	}

}
