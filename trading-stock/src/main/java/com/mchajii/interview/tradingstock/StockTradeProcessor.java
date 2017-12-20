package com.mchajii.interview.tradingstock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Central class to process stocks traded.
 *
 * @author Mohamed Chajii
 */
final class StockTradeProcessor {

    private static final Logger logger = LoggerFactory.getLogger(StockTradeProcessor.class);

    private StockTradeProcessor() {}

    /**
     * Calculates the best profit that can be made from from 1 purchase and 1
     * sale of 1 ING stock yesterday.
     * Time complexity: O(n) - Space complexity: O(1).
     *
     * @param stockPricesYesterday the list of stock prices of yesterday
     * @return the max profit
     * @throws IllegalArgumentException in case an invalid list of stock prices is provided as input
     */
    static int getMaxProfit(int[] stockPricesYesterday) {

        // Using an array of int is faster than a Collection of Integer (boxed ints).

        validate(stockPricesYesterday);

        // We need to keep track of the minimum stock price and the max profit.
        int minStockPrice = stockPricesYesterday[0];
        int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];

        for (int i = 1; i < stockPricesYesterday.length; i++) {
            maxProfit = Math.max(maxProfit, stockPricesYesterday[i] - minStockPrice);
            minStockPrice = Math.min(minStockPrice, stockPricesYesterday[i]);
        }

        logger.info("The maximum calculated profit is '{}'.", maxProfit);

        return maxProfit;
    }

    private static void validate(int[] stockPricesYesterday) {

        if (stockPricesYesterday == null) {
            throw new IllegalArgumentException("'stockPricesYesterday' cannot be null");
        }

        if (stockPricesYesterday.length <= 1) {
            throw new IllegalArgumentException(
                    "The profit cannot be calculated if 'stockPricesYesterday' contains less than 2 elements");
        }
    }

}