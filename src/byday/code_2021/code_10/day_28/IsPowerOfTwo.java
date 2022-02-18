package byday.code_2021.code_10.day_28;

/**
 * @Description 判断一个数是二的幂
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/28 13:47
 * @Tags
 **/
public class IsPowerOfTwo {
    /**
     * @Description: 使用二进制的表达形式来进行判断
     * @Author: YORICHEONG 
     * @Date: 13:49 2021/10/28
     **/
    public boolean isPowerOfTwo(int n) {
        // n & (n - 1) = 0
        // 如果上面的表达式成立，那么就可以证明这个正整数是2的幂
        return n > 0 && ((n & (n - 1)) == 0);
    }

    public boolean isPowerOfTwo2(int n) {
        // 使用n & (n - 1) 来进行判断
        return n > 0 && (n & -n) == 0;
    }

    public boolean isPowerOfTwo3(int n) {
        // 定义一个这个长度最大的2的幂的数
        // 然后使用当前的数与这个最大的二进制数来进行判断，然后得到一个好的结果
        final int BIG = 1 << 30;

        return n > 0 && n%BIG == 0;
    }
}
