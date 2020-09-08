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
 * 假设用户可以预言到明天的涨跌。则可做如下思考： 假如明天要股价大于今天股价，则买入今天股票或者继续持股。假如明天要股价小于今天股价则保持空仓或者抛售今天股票。循环往复，最终拿到的就是最优解。
 * f(1) = x2 > x1 ? (+x1 | --) : (-0 | -x1 )
 * f(2) = x3 > x2 ? (+x2 | --) : (-0 | -x2 )
 * f(n) = xn+1 > xn ?  (+xn | --) : (-0 | -xn )
 */


public class 买卖股票的最佳时机2 {
    public int maxProfit(int[] prices) {
        int earnings = 0;
        int hold = 0;
        if (prices.length < 2) {
            return earnings;
        }
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] > prices[i]){
                //持有或者买入
                if (hold == 0) {
                    hold = prices[i];
                    System.out.println(String.format("买入:i=%d,prices=%d,hold=%d,earnings=%d",i,prices[i],hold,earnings));
                }
            } else {
                //抛售或者保持空仓
                if (hold > 0){
                    earnings += (prices[i] - hold);
                    hold = 0;
                    System.out.println(String.format("抛出:i=%d,prices=%d,hold=%d,earnings=%d",i,prices[i],hold,earnings));
                }
            }
        }
        if (hold > 0){
            earnings += (prices[prices.length-1] - hold);
            hold = 0;
            System.out.println(String.format("最后抛出:i=%d,prices=%d,hold=%d,earnings=%d",prices.length,prices[prices.length],hold,earnings));
        }
        return earnings;
    }
}
