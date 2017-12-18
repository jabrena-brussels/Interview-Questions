package be.mchajii.tradingstock;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Collections;

/**
 * @author Mohamed Chajii
 */
public class StockTradeProcessorTest {

    // TODO: Finish tests.

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenStockPricesIsNull() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        StockTradeProcessor.getMaxProfit(null);
    }

    @Test
    public void shouldThrowExceptionWhenStockPricesIsEmpty() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        StockTradeProcessor.getMaxProfit(Collections.<Integer>emptyList());
    }

    @Test
    public void shouldThrowExceptionWhenStockPricesSizeIsLessThanTwo() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        StockTradeProcessor.getMaxProfit(Collections.singletonList(1));
    }
}