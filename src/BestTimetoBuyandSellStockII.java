import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimetoBuyandSellStockII {

    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] > prices[i - 1]) {
//                maxProfit += prices[i] - prices[i - 1];
//            }
//        }
//
//        return maxProfit;
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);
        }

        return dp[n - 1];
    }

    @Test
    public void test() {

        assertEquals(7, maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(4, maxProfit(new int[]{1,2,3,4,5}));
        assertEquals(0, maxProfit(new int[]{7,6,4,3,1}));
    }


}
