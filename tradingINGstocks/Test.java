package tradingINGstocks;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tradingStocks s = new tradingStocks();
		int[] stockPrices = {10,7,5,8,11,9};
		int[] stockPrices2 = {9,12,7,20,14,18};
		int[] stockPrices3 = {20,9,7,11,15,7,4};
		int[] stockPrices4 = {1, 20, 3, 4, 5, 6, 7, 8};
		
		int result = s.getMaxProfit(stockPrices);
		int result2 = s.getMaxProfit(stockPrices2);
		int result3 = s.getMaxProfit(stockPrices3);
		int result4 = s.getMaxProfit(stockPrices4);
		
		System.out.println("Profit resulted from trading: " + result);
		System.out.println("Profit resulted from trading: " + result2);
		System.out.println("Profit resulted from trading: " + result3);
		System.out.println("Profit resulted from trading: " + result4);
		
		
	}

}
