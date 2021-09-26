package top100;

/**
 * @description: 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 * @author YORICHEONG
 * @date 2021/9/17 10:53
 * @version 1.0
 */
public class CoinChange {
    /**
     * @param: coins
     * @param: amount
     * @description : 使用动态的规划的方法，同时记忆已经进行遍历的过的内容
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/9/17
     */
    public int coinChange(int[] coins, int amount) {
        
        return -1;
    }

    public static void main(String[] args) {


        byte c = -23;
        byte x = -127;

        int result = Byte.toUnsignedInt(c);
        System.out.println(result);
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(result));
        int a = 23;
        System.out.println(Integer.toBinaryString(a));
    }
}
