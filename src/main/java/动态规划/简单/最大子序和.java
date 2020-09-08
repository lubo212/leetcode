package 动态规划.简单;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * https://leetcode-cn.com/problems/maximum-subarray/
 */


/**
 * 解题思路：
 * 动态规划：
 * 假设数组长度=1，则f(1) = max(x1).
 * 假设数组长度=2，则f(2) = max( f(1) + x2 , x2 ).
 * 假设数组长度=3，则f(3) = max( f(2) + x3 , x3 ).
 * 同理，假设数组长度=n,则f(n) = max( f(n-1) + xn , xn ).
 */

public class 最大子序和 {


    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans + nums[i], nums[i]);
            max = Math.max(max,ans);
            //如果ans为负值，则置0
            ans = Math.max(ans,0);
            System.out.println("i = " + i + " ,ans = " + ans + " ,max = " + max);
        }
        return max;
    }

}
