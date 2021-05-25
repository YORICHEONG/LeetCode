package app.LeetCode.DP;

import java.security.interfaces.RSAKey;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if(n<=1){
            return 1;
        }
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        for(int i = 3;i <=n;i ++){
            result[i]= result[i-1]+result[i-2];
        }
        return result[n];
    }

    public int climbStairs_02(int n) {
        if(n<=1){
            return 1;
        }
        if(n<3){
            return n;
        }
        return climbStairs_02(n-1)+climbStairs_02(n-2);
    }
}
