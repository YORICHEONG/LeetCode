package swordfingeroffer;

/**
 * @Description 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/7/4 14:12
 * @Tags
 **/
public class NumberOf1 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(6));
    }

    public static int NumberOf1(int n) {
        int count = 0;
        String str = Integer.toBinaryString(n);
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
