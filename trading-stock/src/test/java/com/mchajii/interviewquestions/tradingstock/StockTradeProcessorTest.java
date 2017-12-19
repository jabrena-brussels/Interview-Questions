package com.mchajii.interviewquestions.tradingstock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * @author Mohamed Chajii
 */
public class StockTradeProcessorTest {

    // TODO: Finish tests.

    @Test
    public void shouldThrowExceptionWhenStockPricesIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StockTradeProcessor.getMaxProfit(null));
    }

    @Test
    public void shouldThrowExceptionWhenStockPricesIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StockTradeProcessor.getMaxProfit(Collections.emptyList()));
    }

    @Test
    public void shouldThrowExceptionWhenStockPricesSizeIsLessThanTwo() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> StockTradeProcessor.getMaxProfit(Collections.singletonList(1)));
    }
}