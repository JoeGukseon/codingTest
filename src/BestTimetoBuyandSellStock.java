import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int buy = prices[0];
        int sell = Integer.MIN_VALUE;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if(buy > prices[i]) sell = prices[i];
            buy = Math.min(buy, prices[i]);
            sell = Math.max(sell, prices[i]);
            profit = Math.max(profit,sell-buy);
        }

        return profit;
    }

    @Test
    public void test() {

//        assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        assertEquals(0, maxProfit(new int[]{7, 6, 4, 3, 1}));
        assertEquals(2, maxProfit(new int[]{2,4,1}));
    }


}
