package tradingINGstocks;

public class tradingStocks {
	
	    public int getMaxProfit(int[] in) 
	    {
	    	int min = Integer.MAX_VALUE; //max value to be stored in an int
	        int maxProfit = 0,i=0;
	        for(i = 0; i < in.length; i++) 
	        {
	            //if my current value is the min, store it
	        	if (in[i] < min)
	            {
	                min = in[i];
	            }
	        	
	        	//otherwise, the min is a value somewhere behind me, compute current profit
	        	else
	        	{
	        		//compute current profit
	        		int profit = in[i]-min;
	        		
	        		//check if current profit is the best
	        		if(profit>maxProfit)
	        		{
	        			maxProfit = profit;
	        		}
	        	}
	        }
	        return maxProfit;
	    }
	
}
