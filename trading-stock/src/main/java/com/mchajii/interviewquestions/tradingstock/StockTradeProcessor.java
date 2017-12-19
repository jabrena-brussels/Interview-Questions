package com.mchajii.interviewquestions.tradingstock;

import java.util.List;

/**
 * Central class to process stocks traded.
 * @author Mohamed Chajii
 */
final class StockTradeProcessor {

    private StockTradeProcessor() {}

    /**
     * Calculates the best profit that can be made from from 1 purchase and 1 sale of 1 ING stock yesterday.
     * Time complexity: O(n) - Space complexity: O(1).
     * @param stockPricesYesterday the list of stock prices of yesterday.
     * @return the max profit
     * @throws IllegalArgumentException in case an invalid list of stock prices is provided
     */
    static int getMaxProfit(List<Integer> stockPricesYesterday) {

        validate(stockPricesYesterday);

        // We need to keep track of the minimum stock price and the max profit.
        int minStockPrice = stockPricesYesterday.get(0);
        int maxProfit = stockPricesYesterday.get(1) - stockPricesYesterday.get(0);

        for(int i = 1; i < stockPricesYesterday.size(); i++) {
            maxProfit = Math.max(maxProfit, stockPricesYesterday.get(i) - minStockPrice);
            minStockPrice = Math.min(minStockPrice, stockPricesYesterday.get(i));
        }

        return maxProfit;
    }

    private static void validate(List<Integer> stockPricesYesterday) {

        if (stockPricesYesterday == null) {
            throw new IllegalArgumentException("'stockPricesYesterday' cannot be null");
        }

        if (stockPricesYesterday.size() <= 1) {
            throw new IllegalArgumentException("The profit cannot be calculated if 'stockPricesYesterday' contains less than 2 elements");
        }
    }

}