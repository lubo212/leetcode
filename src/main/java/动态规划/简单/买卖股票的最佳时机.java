package 动态规划.简单;
/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */


/**
 * 解题思路：
 * 动态规划：
 * f(n) = max(xn - xmin(n-1))
 * res = max(f(n),f(n-1)...f(2),0)
 */


public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int maxEarnings = 0;
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min,prices[i-1]);
            maxEarnings = Math.max(prices[i] - min,maxEarnings);
        }
        return maxEarnings;
    }
}
