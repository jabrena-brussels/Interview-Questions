package com.mchajii.interview.tradingstock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Mohamed Chajii
 */
class StockTradeProcessorTest {

    @Test
    void shouldThrowExceptionWhenStockPriceArrayIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StockTradeProcessor.getMaxProfit(null));
    }

    @Test
    void shouldThrowExceptionWhenStockPriceArrayIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StockTradeProcessor.getMaxProfit(new int[]{}));
    }

    @Test
    void shouldThrowExceptionWhenStockPriceArraySizeIsLessThanTwo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StockTradeProcessor.getMaxProfit(new int[]{1}));
    }

    @Test
    void shouldReturnCorrectMaxProfit() {
        Assertions.assertAll("Compute max profit",
                () -> Assertions.assertEquals(StockTradeProcessor.getMaxProfit(new int[]{10, 7, 5, 8, 11, 9}), 6), // random array of stock prices
                () -> Assertions.assertEquals(StockTradeProcessor.getMaxProfit(new int[]{10, 2}), -8), // we can have a negative profit
                () -> Assertions.assertEquals(StockTradeProcessor.getMaxProfit(new int[]{5, 7, 8, 9, 10, 11}), 6), // stock prices sorted in ascending order
                () -> Assertions.assertEquals(StockTradeProcessor.getMaxProfit(new int[]{10, 10, 10}), 0), // stock price does not change
                () -> Assertions.assertEquals(StockTradeProcessor.getMaxProfit(new int[]{11, 10, 9, 8, 7, 5}), -1) // stock prices sorted in descending order
        );
    }
}