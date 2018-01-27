package In_flightEntertainmentSystem;
/*
 * Your task is to build a feature that will choose 2 movies whose total time is 
 * equal with the exact flight length.
 * Your feature will have 2 input parameters:
 * - the fligth length in minutes
 * - an array of integers that represents the time in minutes for each movie
 * The output should be a boolean that will indicate if there are 2 movies whose sum 
 * equals the flight length.
 * 
 * When building the feature:
 * - assume that the user is watching exactly 2 movies
 * - user should not watch the same movie twice
 */

public class Feature {

	public boolean feature(int flightLength, int[] movies)
	{
		boolean flag=false; 
		int i,j;
		for(i=0;i<movies.length;i++)
		{
			for(j=i+1;j<movies.length;j++)
			{
				if((movies[i]+movies[j])==flightLength)
				{
					flag=true;
					break;
				}
			}
		}
		return flag;
	}
}
