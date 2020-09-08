package 动态规划.简单;

/**
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 */


/**
 * 解题思路：
 * 动态规划：
 * 假设数组长度=1，则f(1) = max(x1).
 * 假设数组长度=2，则f(2) = max( f(1) , x2 ).
 * 假设数组长度=3，则f(3) = max( f(1) + x3 , x2 ).
 * 同理，假设数组长度=n,则f(n) = max( f(n-2) + xn , f(n-1) ).
 */

public class 按摩师 {

    public int massage(int[] nums) {
        if (nums.length == 0 ){
            return 0;
        }
        int max = nums[0];
        int pre2 = 0;
        int pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(pre2 + nums[i],pre1);
            pre2 = pre1;
            pre1 = max;
        }
        return max;
    }


}
